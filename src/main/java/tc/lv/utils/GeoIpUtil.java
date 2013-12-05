package tc.lv.utils;

import org.apache.log4j.Logger;

import tc.lv.domain.City;
import tc.lv.domain.Country;
import tc.lv.domain.IpAddress;
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

    public GeoIpUtil() throws GeoIpException {
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

    public void addCityToIpAddress(IpAddress ipAddress) throws GeoIpException {
        City city = null;
        Country country = null;
        String countryName, countryCode, cityName;
        String address = ipAddress.getAddress();
        try {
            if (IpValidator.isIpV4(ipAddress.getAddress())) {
                countryName = lookupServiceIpV4Country.getCountry(address).getName();
                countryCode = lookupServiceIpV4Country.getCountry(address).getCode();
                cityName = (lookupServiceIpV4City.getLocation(address) != null ? lookupServiceIpV4City
                        .getLocation(address).city : "None");

            } else {
                countryName = lookupServiceIpV6Country.getCountry(address).getName();
                countryCode = lookupServiceIpV6Country.getCountry(address).getCode();
                cityName = (lookupServiceIpV6City.getLocation(address) != null ? lookupServiceIpV6City
                        .getLocation(address).city : "None");
            }

            country = new Country(countryName, countryCode);
            city = new City(cityName, country);
            ipAddress.setCity(city);

        } catch (Exception e) {
            LOGGER.error("Problem with GeoIp!", e);
            dispose();
            throw new GeoIpException("Problem with GeoIp!", e);
        }
    }

    public void dispose() {
        lookupServiceIpV4Country.close();
        lookupServiceIpV6Country.close();
        lookupServiceIpV4City.close();
        lookupServiceIpV6City.close();
    }
}