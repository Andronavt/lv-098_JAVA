package tc.lv.service;

import java.util.List;

import tc.lv.domain.IpAddress;
import tc.lv.exceptions.LocationServiceException;

public interface LocationService {

    public Integer countStatusIpByCountryName(String countryName, Class<? extends IpAddress> ipType, boolean status)
            throws LocationServiceException;

    public Integer countStatusIpByCityName(String cityName, Class<? extends IpAddress> ipType, boolean status)
            throws LocationServiceException;

    public List<String> findCountryListByStatus(Class<? extends IpAddress> ipType, boolean status)
            throws LocationServiceException;

    public List<String> findCityListByStatus(Class<? extends IpAddress> ipType, boolean status)
            throws LocationServiceException;

    public List<IpAddress> findStatusListByCity(int from, int count, String cityName,
            Class<? extends IpAddress> ipType, boolean status) throws LocationServiceException;

    public List<IpAddress> findStatusListByCountry(int from, int count, String countryName,
            Class<? extends IpAddress> ipType, boolean status) throws LocationServiceException;

}
