package tc.lv.service;

import tc.lv.exceptions.GeoIpException;

public interface GeoIpService {

    public String findCountryByIpAddress(String ipAddress) throws GeoIpException;

    public String findCountryCodeByIpAddress(String ipAddress) throws GeoIpException;

    public String findCityByIpAddress(String ipAddress) throws GeoIpException;

}
