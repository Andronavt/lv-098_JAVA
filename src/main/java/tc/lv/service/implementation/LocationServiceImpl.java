package tc.lv.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpAddressDao;
import tc.lv.domain.IpAddress;
import tc.lv.exceptions.LocationServiceException;
import tc.lv.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    IpAddressDao ipAddressDao;

    @Override
    @Transactional
    public Long countStatusIpByCityName(String cityName, Class<? extends IpAddress> ipType, boolean status)
            throws LocationServiceException {
        try {
            return ipAddressDao.countStatusIpByCityName(cityName, ipType, status);

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }
    }

    @Override
    @Transactional
    public Long countStatusIpByCountryName(String countryName, Class<? extends IpAddress> ipType, boolean status)
            throws LocationServiceException {
        try {
            return ipAddressDao.countStatusIpByCountryName(countryName, ipType, status);

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }
    }

    @Override
    @Transactional
    public List<String> findCityListByStatus(Class<? extends IpAddress> ipType, boolean status)
            throws LocationServiceException {
        try {
            return ipAddressDao.findCityListByStatus(ipType, status);

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }
        ;
    }

    @Override
    @Transactional
    public List<String> findCountryListByStatus(Class<? extends IpAddress> ipType, boolean status)
            throws LocationServiceException {
        try {
            return ipAddressDao.findCountryListByStatus(ipType, status);

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }
    }

    @Override
    @Transactional
    public List<IpAddress> findStatusListByCity(int from, int count, String cityName,
            Class<? extends IpAddress> ipType, boolean status) throws LocationServiceException {
        try {
            return ipAddressDao.findStatusListByCity(from, count, cityName, ipType, status);

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }
    }

    @Override
    @Transactional
    public List<IpAddress> findStatusListByCountry(int from, int count, String countryName,
            Class<? extends IpAddress> ipType, boolean status) throws LocationServiceException {
        try {
            return ipAddressDao.findStatusListByCountry(from, count, countryName, ipType, status);

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }
    }
}
