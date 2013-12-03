package tc.lv.service.implementation;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.CityDao;
import tc.lv.dao.CountryDao;
import tc.lv.dao.IpAddressDao;
import tc.lv.dao.SourceDao;
import tc.lv.domain.City;
import tc.lv.domain.Country;
import tc.lv.domain.IpAddress;
import tc.lv.domain.Source;
import tc.lv.exceptions.DBException;
import tc.lv.exceptions.GeoIpException;
import tc.lv.exceptions.IpAddressServiceException;
import tc.lv.exceptions.SourceDownloaderServiceException;
import tc.lv.service.IpAddressSaveDetailsService;
import tc.lv.service.IpAddressService;
import tc.lv.utils.GeoIpUtil;
import tc.lv.utils.IpVersionUtil;

@Service
public class IpAddressServiceImpl implements IpAddressService {

    private static final Logger LOGGER = Logger.getLogger(IpAddressServiceImpl.class);

    @Autowired
    private IpAddressDao ipDao;

    @Autowired
    private SourceDao sourceDao;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private CountryDao countryDao;

    @Autowired
    private IpAddressSaveDetailsService ipAddressSaveDetailsService;

    private static GeoIpUtil geoIpUtil;

    @Override
    @Transactional
    public boolean saveIpByStatus(String address, String status) throws IpAddressServiceException {
        try {
            IpAddress tempIp = ipDao.findByAddress(address, IpAddress.class);
            if (tempIp != null) {
                tempIp.getSourceSet().add(ipAddressSaveDetailsService.getSourceByStatus(status));
            } else {
                tempIp = ipAddressSaveDetailsService.getDetails(address, status);
            }
            tempIp.setStatus(IpVersionUtil.isWhiteIpAddress(status));
            ipDao.save(tempIp);
            return true;
        } catch (Exception e) {
            LOGGER.error(e);
            throw new IpAddressServiceException("Could not save IP to List", e);
        }
    }

    @Override
    @Transactional
    public boolean deleteIpByAddress(String address) throws IpAddressServiceException {
        try {
            IpAddress tempIp = ipDao.findByAddress(address, IpAddress.class);
            if (tempIp != null) {
                ipDao.deleteIp(tempIp);
                return true;
            }
        } catch (Exception e) {
            LOGGER.error(e);
            throw new IpAddressServiceException("Could not delete ip from list", e);
        }
        return false;
    }

    @Override
    @Transactional
    public void saveList(List<? extends IpAddress> list, int sourceId, Class<? extends IpAddress> ipType,
            Map<String, IpAddress> map) throws DBException, GeoIpException {
        // Source source = entityManager.find(Source.class, sourceId);
        Source source = sourceDao.findByID(sourceId);
        if (source == null) {
            throw new DBException("Didn't find source with id " + sourceId);
        } else {
            geoIpUtil = new GeoIpUtil();
            int persist = 0;
            int merge = 0;
            int notModified = 0;
            for (IpAddress ip : list) {
                if (!map.containsKey(ip.getAddress()) && ip != null) {
                    ip.getSourceSet().add(source);
                    ipCountry(ip);
                    // save(ip);
                    ipDao.save(ip);
                    persist++;
                } else {
                    IpAddress temp = map.get(ip.getAddress());
                    if (temp.getSourceSet().add(source)) {
                        // update(temp);
                        temp.setModified(true);
                        ipDao.update(temp);
                        merge++;
                    } else {
                        notModified++;
                    }
                }
            }
            LOGGER.info("persist operations: " + persist + ", merge operations: " + merge + ", not modified: "
                    + notModified);
        }
    }

    private void ipCountry(IpAddress ip) throws GeoIpException {
        // if (ipAddress == null) {
        // LOGGER.info("setLocation(IpAddress ipAddress) has null as parameter");
        // return;
        // }

        City city = getLocation(ip);
        Country country = city.getCountry();
        // if (!Country.COUNTRY_MAP.containsKey(country.getCountryName())) {
        if (!countryDao.isCountryExists(country)) {
            // entityManager.persist(country);
            countryDao.save(country);
            // entityManager.persist(city);
            cityDao.save(city);
        } else {
            // Country tempCountry =
            // Country.COUNTRY_MAP.get(country.getCountryName());
            Country tempCountry = Country.COUNTRY_MAP.get(country.getCountryName());
            // if (!City.CITY_MAP.containsKey(city.getCityName())) {
            if (!cityDao.isCityExists(city)) {
                city.setCountry(tempCountry);
                // entityManager.merge(tempCountry);
                countryDao.update(tempCountry);
                // entityManager.persist(city);
                cityDao.save(city);
            } else {
                city = City.CITY_MAP.get(city.getCityName());
                ip.setCity(city);
                // entityManager.merge(city);
                cityDao.update(city);
                // entityManager.merge(tempCountry);
                countryDao.update(tempCountry);
            }
        }
    }

    private City getLocation(IpAddress ip) throws GeoIpException {

        geoIpUtil.addCityToIpAddress(ip);

        City city = ip.getCity();
        if (city.getCityName() == null)
            city.setCityName("UNKNOWN");

        Country country = city.getCountry();
        if (country.getCountryName() == null)
            country.setCountryName("UNKNOWN");
        return city;
    }

    @Override
    @Transactional
    public void updateStatusList(Map<String, IpAddress> map) throws SourceDownloaderServiceException {
        LOGGER.info("Start update WhiteList");
        try {
            int merge = 0;
            int notModified = 0;
            Iterator<String> it = map.keySet().iterator();
            IpAddress ip;
            while (it.hasNext()) {
                ip = map.get(it.next());
                if (calculateRank(ip)) {
                    ipDao.update(ip);
                    // entityManager.merge(ip);
                    merge++;
                } else {
                    notModified++;
                }
            }
            LOGGER.info("merge operations: " + merge + ", not modified: " + notModified);
        } catch (Exception e) {
            LOGGER.error(e);
            throw new SourceDownloaderServiceException("class of Parser cannot be instantiated!", e);
        }
        LOGGER.info("Finish update WhiteList");
    }

    private boolean calculateRank(IpAddress ip) throws DBException {
        if (ip == null || ip.getModified() == null) {
            return false;
        }
        Set<Source> sourceSet = ip.getSourceSet();
        if (sourceSet.size() != 0 && ip.getModified()) {
            // return false;
            // }
            // if (ip.getModified()) {
            Iterator<Source> it = sourceSet.iterator();
            ip.setStatus(rankLogick(it) > 0);
            ip.setModified(false);
            return true;
        }
        return false;
    }

    private double rankLogick(Iterator<Source> it) throws DBException {
        double statuskRank = 0;
        while (it.hasNext()) {
            Source source = it.next();
            if (source.getListType().equals(Source.WHITE_LIST)) {
                statuskRank += source.getRank();
            } else if (source.getListType().equals(Source.BLACK_LIST)) {
                statuskRank -= source.getRank();
            } else {
                throw new DBException(source.getListType() + " didn't supported by updateStatusList() method");
            }
        }
        return statuskRank;
    }

}
