package tc.lv.service;

import tc.lv.domain.IpAddress;
import tc.lv.exceptions.GeoIpServiceException;

public interface GeoIpService {

    public String findCountryByIpAddress(IpAddress ipAddress) throws GeoIpServiceException;

    public String findCityByIpAddress(IpAddress ipAddress) throws GeoIpServiceException;

}
