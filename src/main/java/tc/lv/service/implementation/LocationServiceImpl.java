package tc.lv.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpAddressDao;
import tc.lv.dao.implementations.IpQueryEnum;
import tc.lv.domain.IpAddress;
import tc.lv.exceptions.LocationServiceException;
import tc.lv.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    IpAddressDao ipAddressDao;

    @Override
    @Transactional
    public List<IpAddress> loadBlackListOfCityByRange(int from, int count, String cityName)
            throws LocationServiceException {
        try {
            return ipAddressDao.findBlackListByCityName(from, count, cityName, IpQueryEnum.IP);

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }

    }

    @Override
    @Transactional
    public List<IpAddress> loadBlackListOfCountryByRange(int from, int count, String countryName)
            throws LocationServiceException {
        try {
            return ipAddressDao.findBlackListByCountryName(from, count, countryName, IpQueryEnum.IP);

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }
    }

    @Override
    @Transactional
    public List<IpAddress> loadWhiteListOfCityByRange(int from, int count, String cityName)
            throws LocationServiceException {
        try {
            return ipAddressDao.findWhiteListByCityName(from, count, cityName, IpQueryEnum.IP);

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }
    }

    @Override
    @Transactional
    public List<IpAddress> loadWhiteListOfCountryByRange(int from, int count, String countryName)
            throws LocationServiceException {

        try {
            return ipAddressDao.findWhiteListByCountryName(from, count, countryName, IpQueryEnum.IP);

        } catch (Exception e) {
            throw new LocationServiceException("Could not load location list.", e);
        }
    }
}
