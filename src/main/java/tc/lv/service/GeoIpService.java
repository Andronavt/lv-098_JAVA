package tc.lv.service;

import tc.lv.exceptions.GeoIpServiceException;

public interface GeoIpService {

    public String findCountryByIpAddress(String ipAddress) throws GeoIpServiceException;

    public String findCountryCodeByIpAddress(String ipAddress) throws GeoIpServiceException;

    public String findCityByIpAddress(String ipAddress) throws GeoIpServiceException;

}
