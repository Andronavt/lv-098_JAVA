package tc.lv.service.implementation;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.exceptions.GeoIpServiceException;
import tc.lv.service.GeoIpService;
import tc.lv.utils.IpValidator;

import com.maxmind.geoip.LookupService;

public class GeoIpServiceImpl implements GeoIpService {
    private static final String DIR = "C://Users//Oleg//workspace//lv-098_JAVA//src//main//resources//geoIP//";
    private static final String GEO_IPV4_DB_COUNTRY = "GeoIP.dat";
    private static final String GEO_IPV6_DB_COUNTRY = "GeoIPv6.dat";
    private static final String GEO_IPV4_DB_CITY = "GeoLiteCity.dat";
    private static final String GEO_IPV6_DB_CITY = "GeoLiteCityv6.dat";
    private static final Logger LOGGER = Logger.getLogger(GeoIpServiceImpl.class);

    @Override
    @Transactional
    public String findCountryByIpAddress(String ipAddress) throws GeoIpServiceException {
        String result = null;
        String dbfile = null;

        try {
            if (IpValidator.isIpV4(ipAddress)) {
                dbfile = DIR + GEO_IPV4_DB_COUNTRY;
            } else {
                dbfile = DIR + GEO_IPV6_DB_COUNTRY;
            }

            LookupService cl = new LookupService(dbfile, LookupService.GEOIP_MEMORY_CACHE);
            result = cl.getCountry(ipAddress).getCode();
            cl.close();
        } catch (Exception e) {
            LOGGER.error("Could not find GeoIP Data Base file!", e);
            throw new GeoIpServiceException("Could not find GeoIP Data Base file!", e);
        }
        return result;
    }

    @Override
    @Transactional
    public String findCountryCodeByIpAddress(String ipAddress) throws GeoIpServiceException {
        String result = null;
        String dbfile = null;

        try {
            if (IpValidator.isIpV4(ipAddress)) {
                dbfile = DIR + GEO_IPV4_DB_COUNTRY;
            } else {
                dbfile = DIR + GEO_IPV6_DB_COUNTRY;
            }

            LookupService cl = new LookupService(dbfile, LookupService.GEOIP_MEMORY_CACHE);
            result = cl.getCountry(ipAddress).getCode();
            cl.close();
        } catch (Exception e) {
            LOGGER.error("Could not find GeoIP Data Base file!", e);
            throw new GeoIpServiceException("Could not find GeoIP Data Base file!", e);
        }
        return result;
    }

    @Override
    @Transactional
    public String findCityByIpAddress(String ipAddress) throws GeoIpServiceException {
        String result = null;
        String dbfile = null;

        try {
            if (IpValidator.isIpV4(ipAddress)) {
                dbfile = DIR + GEO_IPV4_DB_CITY;
            } else {
                dbfile = DIR + GEO_IPV6_DB_CITY;
            }

            LookupService cl = new LookupService(dbfile, LookupService.GEOIP_MEMORY_CACHE);

            // result = "CITY";
            result = cl.getLocation(ipAddress).city;
            cl.close();
        } catch (Exception e) {
            LOGGER.error("Could not find GeoIP Data Base file!", e);
            throw new GeoIpServiceException("Could not find GeoIP Data Base file!", e);
        }
        return result;
    }
}