package tc.lv.service.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.CityDao;
import tc.lv.dao.CountryDao;
import tc.lv.dao.IpAddressDao;
import tc.lv.domain.IpAddress;
import tc.lv.exceptions.LocationServiceException;
import tc.lv.service.LocationService;
import tc.lv.utils.IpVersionUtil;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    IpAddressDao ipAddressDao;
    @Autowired
    CityDao cityDao;
    @Autowired
    CountryDao countryDao;

    @Override
    @Transactional
    public Integer countStatusIpByCityName(String cityName, String ipType,
	    String status) throws LocationServiceException {
	try {
	    return ipAddressDao.countStatusIpByCityName(
		    IpVersionUtil.isWhiteIpAddress(status), cityName,
		    IpVersionUtil.ipVersion(ipType)).intValue();
	} catch (Exception e) {
	    throw new LocationServiceException("Could not load location list.",
		    e);
	}
    }

    @Override
    @Transactional
    public Integer countStatusIpByCountryName(String countryName,
	    String ipType, String status) throws LocationServiceException {
	try {
	    return ipAddressDao.countStatusIpByCountryName(
		    IpVersionUtil.isWhiteIpAddress(status),
		    countryDao.findCountryCodeByCountryName(countryName,
			    IpVersionUtil.ipVersion(ipType)),
		    IpVersionUtil.ipVersion(ipType)).intValue();
	} catch (Exception e) {
	    throw new LocationServiceException("Could not load location list.",
		    e);
	}
    }

    @Override
    @Transactional
    public List<String> findCityListByStatus(String ipType, String status)
	    throws LocationServiceException {
	try {
	    return cityDao.findCityNameListByStatus(IpVersionUtil
		    .isWhiteIpAddress(status));
	} catch (Exception e) {
	    throw new LocationServiceException("Could not load location list.",
		    e);
	}

    }

    @Override
    @Transactional
    public List<String> findCountryListByStatus(String ipType, String status)
	    throws LocationServiceException {
	try {
	    return countryDao.findCountryNameListByStatus(
		    IpVersionUtil.isWhiteIpAddress(status),
		    IpVersionUtil.ipVersion(ipType));
	} catch (Exception e) {
	    throw new LocationServiceException("Could not load location list.",
		    e);
	}
    }

    @Override
    @Transactional
    public List<IpAddress> findStatusListByCity(int from, int count,
	    String cityName, String ipType, String status)
	    throws LocationServiceException {
	try {
	    List<IpAddress> resultList = ipAddressDao.findStatusListByCity(
		    IpVersionUtil.isWhiteIpAddress(status), from, count,
		    cityName, IpVersionUtil.ipVersion(ipType));
	    if (resultList != null){
		 return resultList;
	    }
	    return resultList = new ArrayList<IpAddress>();
	       
	} catch (Exception e) {
	    throw new LocationServiceException("Could not load location list.",
		    e);
	}
    }

    @Override
    @Transactional
    public List<IpAddress> findStatusListByCountry(int from, int count,
	    String countryName, String ipType, String status)
	    throws LocationServiceException {
	try {
	    return ipAddressDao.findStatusListByCountryName(
		    IpVersionUtil.isWhiteIpAddress(status), from, count,
		    countryName, IpVersionUtil.ipVersion(ipType));
	} catch (Exception e) {
	    throw new LocationServiceException("Could not load location list.",
		    e);
	}
    }
}
