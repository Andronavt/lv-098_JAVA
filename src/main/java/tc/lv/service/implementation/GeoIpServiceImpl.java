package tc.lv.service.implementation;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.IpAddress;
import tc.lv.exceptions.GeoIpServiceException;
import tc.lv.service.GeoIpService;
import tc.lv.utils.IpValidator;

import com.maxmind.geoip.LookupService;

public class GeoIpServiceImpl implements GeoIpService {
    private static final String DIR = "/lv-098_JAVA/src/main/resources/geoIP";
    private static final String GEO_IPV4_DB_COUNTRY = "GeoIP.dat";
    private static final String GEO_IPV6_DB_COUNTRY = "GeoIPv6.dat";
    private static final String GEO_IPV4_DB_CITY = "GeoIP.dat";
    private static final String GEO_IPV6_DB_CITY = "GeoIPv6.dat";
    private static final Logger LOGGER = Logger.getLogger(GeoIpServiceImpl.class);

    @Override
    @Transactional
    public String findCountryByIpAddress(IpAddress ipAddress) throws GeoIpServiceException {
        String result = null;
        String dbfile = null;

        try {
            if (IpValidator.isIpV4(ipAddress.getAddress())) {
                dbfile = DIR + GEO_IPV4_DB_COUNTRY;
            } else {
                dbfile = DIR + GEO_IPV6_DB_COUNTRY;
            }

            LookupService cl = new LookupService(dbfile, LookupService.GEOIP_MEMORY_CACHE);
            result = cl.getCountry(ipAddress.getAddress()).getCode();
            cl.close();
        } catch (Exception e) {
            LOGGER.error("Could not find GeoIP Data Base file!", e);
            throw new GeoIpServiceException("Could not find GeoIP Data Base file!", e);
        }
        return result;
    }

    @Override
    @Transactional
    public String findCityByIpAddress(IpAddress ipAddress) throws GeoIpServiceException {
        String result = null;
        String dbfile = null;

        try {
            if (IpValidator.isIpV4(ipAddress.getAddress())) {
                dbfile = DIR + GEO_IPV4_DB_CITY;
            } else {
                dbfile = DIR + GEO_IPV6_DB_CITY;
            }

            LookupService cl = new LookupService(dbfile, LookupService.GEOIP_MEMORY_CACHE);
            result = cl.getLocation(ipAddress.getAddress()).city;
            cl.close();
        } catch (Exception e) {
            LOGGER.error("Could not find GeoIP Data Base file!", e);
            throw new GeoIpServiceException("Could not find GeoIP Data Base file!", e);
        }
        return result;
    }

}