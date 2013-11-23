package tc.lv.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpAddressDao;
import tc.lv.domain.City;
import tc.lv.domain.Country;
import tc.lv.domain.IpAddress;
import tc.lv.exceptions.LocationServiceException;
import tc.lv.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    IpAddressDao ipAddressDao;

    @Override
    @Transactional
    public Integer countStatusIpByCityName(String cityName, Class<? extends IpAddress> ipType, boolean status)
            throws LocationServiceException {
        try {
            return ipAddressDao.countStatusIpByCityName(status, cityName, ipType).intValue();

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }
    }

    @Override
    @Transactional
    public Integer countStatusIpByCountryName(String countryName, Class<? extends IpAddress> ipType, boolean status)
            throws LocationServiceException {
        try {
            return ipAddressDao.countStatusIpByCountryName(status, countryName, ipType).intValue();

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }
    }

    @Override
    @Transactional
    public List<City> findCityListByStatus(Class<? extends IpAddress> ipType, boolean status)
            throws LocationServiceException {
        try {
            return ipAddressDao.findCityListByStatus(status, ipType);

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }

    }

    @Override
    @Transactional
    public List<Country> findCountryListByStatus(Class<? extends IpAddress> ipType, boolean status)
            throws LocationServiceException {
        try {
            return ipAddressDao.findCountryListByStatus(status, ipType);

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }
    }

    @Override
    @Transactional
    public List<IpAddress> findStatusListByCity(int from, int count, String cityName,
            Class<? extends IpAddress> ipType, boolean status) throws LocationServiceException {
        try {
            return ipAddressDao.findStatusListByCity(status, from, count, cityName, ipType);

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }
    }

    @Override
    @Transactional
    public List<IpAddress> findStatusListByCountry(int from, int count, String countryName,
            Class<? extends IpAddress> ipType, boolean status) throws LocationServiceException {
        try {
            return ipAddressDao.findStatusListByCountry(status, from, count, countryName, ipType);

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }
    }
}
