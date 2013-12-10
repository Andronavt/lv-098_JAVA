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
import tc.lv.service.IpAddressSaveDetailsService;
import tc.lv.service.IpAddressService;
import tc.lv.utils.GeoIpUtil;
import tc.lv.utils.IpVersionUtil;

@Service
public class IpAddressServiceImpl implements IpAddressService {

    private static final Logger LOGGER = Logger
	    .getLogger(IpAddressServiceImpl.class);

    @Autowired
    private IpAddressDao ipAddressDao;

    @Autowired
    private SourceDao sourceDao;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private CountryDao countryDao;

    @Autowired
    private IpAddressSaveDetailsService ipAddressSaveDetailsService;

    private static GeoIpUtil geoIpUtil;

    public IpAddressServiceImpl() throws IpAddressServiceException {
	try {
	    if (geoIpUtil == null)
		geoIpUtil = new GeoIpUtil();
	} catch (GeoIpException e) {
	    LOGGER.error(e);
	    throw new IpAddressServiceException(
		    "Could not initialize GeoIpUtil", e);
	}
    }

    @Override
    @Transactional
    public boolean saveIpByStatus(String address, String status)
	    throws IpAddressServiceException {
	boolean result = false;
	try {
	    IpAddress tempIp = new IpAddress();
	    tempIp.setAddress(address);
	    tempIp.setStatus(IpVersionUtil.isWhiteIpAddress(status));
	    result = procesingIpAddress(tempIp,
		    ipAddressSaveDetailsService.getSourceByStatus(status));
	    LOGGER.info(" RESULT " + result + " status: " + tempIp.getStatus());
	    tempIp = IpAddress.IP_MAP.get(address);
	    if (calculateRank(tempIp)) {
		ipAddressDao.update(tempIp);
	    }
	    return result;
	} catch (Exception e) {
	    LOGGER.error(e);
	    throw new IpAddressServiceException("Could not save IP to List", e);
	}
    }

    @Override
    @Transactional
    public boolean deleteIpByAddress(String address)
	    throws IpAddressServiceException {
	try {
	    IpAddress tempIp = ipAddressDao.findByAddress(address,
		    IpAddress.class);
	    if (tempIp != null) {
		ipAddressDao.deleteIp(tempIp);
		return true;
	    }
	} catch (Exception e) {
	    LOGGER.error(e);
	    throw new IpAddressServiceException(
		    "Could not delete ip from list", e);
	}
	return false;
    }

    @Override
    @Transactional
    public void saveList(List<? extends IpAddress> list, int sourceId,
	    Class<? extends IpAddress> ipType, Map<String, IpAddress> map)
	    throws IpAddressServiceException {
	try {
	    Source source = sourceDao.findByID(sourceId);
	    for (IpAddress ip : list) {
		procesingIpAddress(ip, source);
	    }
	} catch (Exception e) {
	    LOGGER.error(e);
	    throw new IpAddressServiceException("Could not save IP List", e);
	}

    }

    private void ipCountry(IpAddress ip) throws GeoIpException {
	geoIpUtil.addCityToIpAddress(ip);
	City city = ip.getCity();
	Country country = city.getCountry();
	if (!countryDao.isCountryExists(country)) {
	    countryDao.save(country);
	    cityDao.save(city);
	} else {
	    ipCity(ip, city);
	}
    }

    private void ipCity(IpAddress ip, City city) {
	Country country = city.getCountry();
	Country tempCountry = Country.COUNTRY_MAP.get(country.getCountryName());
	if (!cityDao.isCityExists(city)) {
	    city.setCountry(tempCountry);
	    countryDao.update(tempCountry);
	    cityDao.save(city);
	} else {
	    city = City.CITY_MAP.get(city.getCityName());
	    ip.setCity(city);
	    cityDao.update(city);
	    countryDao.update(tempCountry);
	}
    }

    @Override
    @Transactional
    public void updateStatusList(Map<String, IpAddress> map)
	    throws IpAddressServiceException {
	LOGGER.info("Start update WhiteList");
	try {
	    Iterator<String> it = map.keySet().iterator();
	    IpAddress ip;
	    while (it.hasNext()) {
		ip = map.get(it.next());
		if (calculateRank(ip)) {
		    ipAddressDao.update(ip);
		}
	    }
	} catch (Exception e) {
	    LOGGER.error(e);
	    throw new IpAddressServiceException(
		    "class of Parser cannot be instantiated!", e);
	}
	LOGGER.info("Finish update WhiteList");
    }

    private boolean calculateRank(IpAddress ip) throws DBException {
	if (ip == null || ip.getModified() == null) {
	    return false;
	}
	Set<Source> sourceSet = ip.getSourceSet();
	if (ip.getModified()) {
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
		continue;
	    }
	    if (source.getListType().equals(Source.BLACK_LIST)) {
		statuskRank -= source.getRank();
	    }
	}
	return statuskRank;
    }

    @Override
    @Transactional
    public void createAllMaps() {
	LOGGER.info("Start creating IP-address Map");
	ipAddressDao.creatIpMap();
	LOGGER.info("Finish creating IP-address Map");

	LOGGER.info("Start creating Country Map");
	countryDao.creatCountryMap();
	LOGGER.info("Finish creating Country Map");

	LOGGER.info("Start creating City Map");
	cityDao.creatCityMap();
	LOGGER.info("Finish creating City Map");
    }

    @Override
    @Transactional
    public boolean procesingIpAddress(IpAddress ip, Source source)
	    throws GeoIpException, IpAddressServiceException {
	if (tryToSaveIp(ip, source)){
	    LOGGER.info("Try to save!!!!");
	    return true;}
	IpAddress temp = IpAddress.IP_MAP.get(ip.getAddress());
	if (tryToUpdateIp(temp, source)){
	    LOGGER.info("Try to update!!!");
	    return true;}
	temp.setModified(false);
	return false;
    }

    private boolean tryToSaveIp(IpAddress ip, Source source)
	    throws GeoIpException, IpAddressServiceException {
	if (!IpAddress.IP_MAP.containsKey(ip.getAddress())) {
	    ipAddressDao.addSource(ip, source);
	    ipCountry(ip);
	    ipAddressDao.save(ip);
	    return true;
	}
	return false;
    }

    private boolean tryToUpdateIp(IpAddress ip, Source source)
	    throws IpAddressServiceException {
	if (ipAddressDao.addSource(ip, source)) {
	    ip.setModified(true);
	    ipAddressDao.update(ip);
	    return true;
	}
	return false;

    }
}
