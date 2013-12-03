package tc.lv.service;

import java.util.List;

import tc.lv.domain.IpAddress;
import tc.lv.exceptions.LocationServiceException;

public interface LocationService {

    public Integer countStatusIpByCountryName(String countryName,
	    String ipType, String status) throws LocationServiceException;

    public Integer countStatusIpByCityName(String cityName, String ipType,
	    String status) throws LocationServiceException;

    public List<String> findCountryListByStatus(String ipType, String status)
	    throws LocationServiceException;

    public List<String> findCityListByStatus(String ipType, String status)
	    throws LocationServiceException;

    public List<IpAddress> findStatusListByCity(int from, int count,
	    String cityName, String ipType, String status)
	    throws LocationServiceException;

    public List<IpAddress> findStatusListByCountry(int from, int count,
	    String countryName, String ipType, String status)
	    throws LocationServiceException;

}
