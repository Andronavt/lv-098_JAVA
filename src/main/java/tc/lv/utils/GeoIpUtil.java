package tc.lv.utils;

import org.apache.log4j.Logger;

import tc.lv.domain.City;
import tc.lv.domain.Country;
import tc.lv.exceptions.GeoIpException;

import com.maxmind.geoip.LookupService;

public class GeoIpUtil {
    private static final String DIR = System.getenv("LV098_JAVA") + "/src/main/resources/geoIP/";

    private static final String GEO_IPV4_DB_COUNTRY = "GeoIP.dat";
    private static final String GEO_IPV6_DB_COUNTRY = "GeoIPv6.dat";
    private static final String GEO_IPV4_DB_CITY = "GeoLiteCity.dat";
    private static final String GEO_IPV6_DB_CITY = "GeoLiteCityv6.dat";
    private static final Logger LOGGER = Logger.getLogger(GeoIpUtil.class);

    private LookupService lookupServiceIpV4Country;
    private LookupService lookupServiceIpV6Country;
    private LookupService lookupServiceIpV4City;
    private LookupService lookupServiceIpV6City;

    public GeoIpUtil() {
    }

    public void init() throws GeoIpException {
        try {
            lookupServiceIpV4Country = new LookupService(DIR + GEO_IPV4_DB_COUNTRY,
                    LookupService.GEOIP_MEMORY_CACHE);
            lookupServiceIpV6Country = new LookupService(DIR + GEO_IPV6_DB_COUNTRY,
                    LookupService.GEOIP_MEMORY_CACHE);
            lookupServiceIpV4City = new LookupService(DIR + GEO_IPV4_DB_CITY, LookupService.GEOIP_MEMORY_CACHE);
            lookupServiceIpV6City = new LookupService(DIR + GEO_IPV6_DB_CITY, LookupService.GEOIP_MEMORY_CACHE);
        } catch (Exception e) {
            LOGGER.error("Problem with GeoIp", e);
            throw new GeoIpException("Problem with GeoIp", e);
        }
    }

    public City findLocationIpV4Address(String ipAddress) throws GeoIpException {
        City city = null;
        Country country = null;
        String countryName, countryCode, cityName;
        try {
            countryName = lookupServiceIpV4Country.getCountry(ipAddress).getName();
            countryCode = lookupServiceIpV4Country.getCountry(ipAddress).getCode();
            if (lookupServiceIpV4City.getLocation(ipAddress) != null) {
                cityName = lookupServiceIpV4City.getLocation(ipAddress).city;
            } else {
                cityName = "None";
            }
            country = new Country(countryName, countryCode);
            city = new City(cityName, country);

        } catch (Exception e) {
            LOGGER.error("Problem with GeoIp!", e);
            close();
            throw new GeoIpException("Problem with GeoIp!", e);
        }
        return city;
    }

    public City findLocationIpV6Address(String ipAddress) throws GeoIpException {
        City city = null;
        Country country = null;
        String countryName, countryCode, cityName;
        try {
            countryName = lookupServiceIpV6Country.getCountry(ipAddress).getName();
            countryCode = lookupServiceIpV6Country.getCountry(ipAddress).getCode();
            if (lookupServiceIpV6City.getLocation(ipAddress) != null) {
                cityName = lookupServiceIpV6City.getLocation(ipAddress).city;
            } else {
                cityName = "None";
            }

            country = new Country(countryName, countryCode);
            city = new City(cityName, country);
        } catch (Exception e) {
            LOGGER.error("Problem with GeoIp!", e);
            close();
            throw new GeoIpException("Problem with GeoIp!", e);
        }
        return city;
    }

    public void close() {
        lookupServiceIpV4Country.close();
        lookupServiceIpV6Country.close();
        lookupServiceIpV4City.close();
        lookupServiceIpV6City.close();
    }
}