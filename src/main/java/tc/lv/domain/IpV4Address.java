package tc.lv.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ipv4_addresses")
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({
        // --------
        @NamedQuery(name = IpV4Address.FIND_ALL, query = IpV4Address.FIND_ALL_QUERY),
        @NamedQuery(name = IpV4Address.FIND_IP_LIST_BY_SOURCE, query = IpV4Address.FIND_IP_LIST_BY_SOURCE_QUERY),
        @NamedQuery(name = IpV4Address.FIND_IP_LIST_BY_ADDRESS, query = IpV4Address.FIND_IP_LIST_BY_ADDRESS_QUERY),
        @NamedQuery(name = IpV4Address.FIND_STATUS_LIST, query = IpV4Address.FIND_STATUS_LIST_QUERY),
        @NamedQuery(name = IpV4Address.FIND_UNDEFINED_LIST, query = IpV4Address.FIND_UNDEFINEDLIST_QUERY),
        @NamedQuery(name = IpV4Address.FIND_IP_BY_NAME, query = IpV4Address.FIND_IP_BY_NAME_QUERY),
        @NamedQuery(name = IpV4Address.FIND_STATUS_LIST_BY_CITY, query = IpV4Address.FIND_STATUS_LIST_BY_CITY_QUERY),
        @NamedQuery(name = IpV4Address.FIND_STATUS_LIST_BY_COUNTRY_NAME, query = IpV4Address.FIND_STATUS_LIST_BY_COUNTRY_NAME_QUERY),

        @NamedQuery(name = IpV4Address.COUNT_ALL, query = IpV4Address.COUNT_ALL_QUERY),
        @NamedQuery(name = IpV4Address.COUNT_STATUS_LIST, query = IpV4Address.COUNT_STATUS_LIST_QUERY),
        @NamedQuery(name = IpV4Address.COUNT_STATUS_IP_BY_COUNTRY_CODE, query = IpV4Address.COUNT_STATUS_IP_BY_COUNTRY_CODE_QUERY),
        @NamedQuery(name = IpV4Address.COUNT_STATUS_IP_BY_COUNTRY_NAME, query = IpV4Address.COUNT_STATUS_IP_BY_COUNTRY_NAME_QUERY),
        @NamedQuery(name = IpV4Address.COUNT_STATUS_IP_BY_CITY_NAME, query = IpV4Address.COUNT_STATUS_IP_BY_CITY_NAME_QUERY),
        @NamedQuery(name = IpV4Address.FIND_ALL_NOT_VALID, query = IpV4Address.FIND_ALL_NOT_VALID_QUERY),
        @NamedQuery(name = IpV4Address.FIND_ALL_VALID, query = IpV4Address.FIND_ALL_VALID_QUERY),
        @NamedQuery(name = IpV4Address.FIND_IP_LIST_BY_CITY, query = IpV4Address.FIND_IP_LIST_BY_CITY_QUERY),
        @NamedQuery(name = IpV4Address.FIND_IP_LIST_BY_COUNTRY, query = IpV4Address.FIND_IP_LIST_BY_COUNTRY_QUERY)
// ---
})
public class IpV4Address extends IpAddress {

    public static final String COUNT_ALL = "IpV4Address.countAll";
    static final String COUNT_ALL_QUERY = "SELECT count(ip) from IpV4Address ip";

    public static final String COUNT_STATUS_LIST = "IpV4Address.countStatusList";
    static final String COUNT_STATUS_LIST_QUERY = "SELECT count(ip) from IpV4Address ip where ip.status = ?1";

    public static final String COUNT_STATUS_IP_BY_CITY_NAME = "IpV4Address.countStatusIpByCityName";
    static final String COUNT_STATUS_IP_BY_CITY_NAME_QUERY = "SELECT count(ip) from IpV4Address ip where ip.status = ?1 and ip.city.cityName = ?2";

    public static final String COUNT_STATUS_IP_BY_COUNTRY_CODE = "IpV4Address.countStatusIpByCountryCode";
    static final String COUNT_STATUS_IP_BY_COUNTRY_CODE_QUERY = "SELECT count(ip) from IpV4Address ip where ip.status = ?1 and ip.city.country.countryCode = ?2";

    public static final String COUNT_STATUS_IP_BY_COUNTRY_NAME = "IpV4Address.countStatusIpByCountryName";
    static final String COUNT_STATUS_IP_BY_COUNTRY_NAME_QUERY = "SELECT count(ip) from IpV4Address ip where ip.status = ?1 and ip.city.country.countryName = ?2";
    
    public static final String FIND_ALL = "IpV4Address.findAll";
    static final String FIND_ALL_QUERY = "SELECT ip from IpV4Address ip";

    public static final String FIND_ALL_NOT_VALID = "IpV4Address.findAllNotValidIp";
    static final String FIND_ALL_NOT_VALID_QUERY = "SELECT ip FROM IpV4Address ip, NotValidIp nv WHERE ip.id = nv.id";

    public static final String FIND_ALL_VALID = "IpV4Address.findAllValidIp";
    static final String FIND_ALL_VALID_QUERY = "SELECT ipO FROM IpV4Address ipO WHERE ipO.id NOT IN (SELECT ipI.id FROM IpV4Address ipI, NotValidIp nv WHERE ipI.id = nv.id)";

    public static final String FIND_IP_LIST_BY_ADDRESS = "IpV4Address.findIpListByAddress";
    static final String FIND_IP_LIST_BY_ADDRESS_QUERY = "SELECT ip from IpV4Address ip WHERE ip.address= ?1";

    public static final String FIND_IP_LIST_BY_SOURCE = "IpV4Address.findIpListBySource";
    static final String FIND_IP_LIST_BY_SOURCE_QUERY = "SELECT ip from IpV4Address ip join ip.sourceSet s where s.sourceId = ?1";

    public static final String FIND_CITY_LIST_BY_STATUS = "IpV4Address.findCityListByStatus";
    static final String FIND_CITY_LIST_BY_STATUS_QUERY = "SELECT distinct(ip.city.cityName) from IpV4Address ip where ip.status = ?1";

    public static final String FIND_COUNTRY_LIST_BY_STATUS = "IpV4Address.findCountryListByStatus";
    static final String FIND_COUNTRY_LIST_BY_STATUS_QUERY = "SELECT distinct(ip.city.country.countryName) from IpV4Address ip where ip.status = ?1";

    public static final String FIND_COUNTRY_CODE_BY_COUNTRY_NAME = "IpV4Address.findCountryCodeByCountryName";
    static final String FIND_COUNTRY_CODE_BY_COUNTRY_NAME_QUERY = "SELECT distinct(ip.city.country.countryCode) from IpV4Address ip where ip.city.country.countryName = ?1";

    public static final String FIND_IP_LIST_BY_CITY = "IpV4Address.findIpByCity";
    static final String FIND_IP_LIST_BY_CITY_QUERY = "SELECT ip from IpV4Address ip where ip.city.cityName = ?1";

    public static final String FIND_IP_LIST_BY_COUNTRY = "IpV4Address.findIpByCountry";
    static final String FIND_IP_LIST_BY_COUNTRY_QUERY = "SELECT ip from IpV4Address ip where ip.city.country.countryCode = ?1";

    public static final String FIND_IP_BY_NAME = "IpV4Address.findIpByName";
    static final String FIND_IP_BY_NAME_QUERY = "SELECT ip from IpV4Address ip where ip.status = ?1 and ip.address = ?2";

    public static final String FIND_STATUS_LIST = "IpV4Address.findStatusList";
    static final String FIND_STATUS_LIST_QUERY = "SELECT ip from IpV4Address ip where ip.status = ?1";

    public static final String FIND_STATUS_LIST_BY_CITY = "IpV4Address.findStatusListByCity";
    static final String FIND_STATUS_LIST_BY_CITY_QUERY = "SELECT ip from IpV4Address ip where ip.status = ?1 and ip.city.cityName = ?2";

    public static final String FIND_STATUS_LIST_BY_COUNTRY_NAME = "IpV4Address.findStatusListByCountryName";
    static final String FIND_STATUS_LIST_BY_COUNTRY_NAME_QUERY = "SELECT ip from IpV4Address ip where ip.status = ?1 and ip.city.country.countryName = ?2";

    public static final String FIND_UNDEFINED_LIST = "IpV4Address.findUndefinedList";
    static final String FIND_UNDEFINEDLIST_QUERY = "SELECT ip from IpV4Address ip where ip.status is null";

    public IpV4Address() {

    }

    public IpV4Address(String address) {
        this.address = address;
    }

    public IpV4Address(String address, Date dateAdded, City city) {
        this.address = address;
        this.dateAdded = dateAdded;
        this.city = city;
    }

    // ----- IpInterface implementation -----
    @Override
    public String countAll() {
        return IpV4Address.COUNT_ALL;
    }

    @Override
    public String countStatusList() {
        return IpV4Address.COUNT_STATUS_LIST;
    }

    @Override
    public String countStatusIpByCityName() {
        return IpV4Address.COUNT_STATUS_IP_BY_CITY_NAME;
    }

    @Override
    public String countStatusIpByCountryName() {
        return IpV4Address.COUNT_STATUS_IP_BY_COUNTRY_CODE;
    }

    @Override
    public String findAll() {
        return IpV4Address.FIND_ALL;
    }

    @Override
    public String findByAddress() {
        return IpV4Address.FIND_IP_LIST_BY_ADDRESS;
    }

    @Override
    public String findIpListBySource() {
        return IpV4Address.FIND_IP_LIST_BY_SOURCE;
    }

    @Override
    public String findStatusList() {
        return IpV4Address.FIND_STATUS_LIST;
    }

    @Override
    public String findStatusListByCity() {
        return IpV4Address.FIND_STATUS_LIST_BY_CITY;
    }

    @Override
    public String findStatusListByCountryName() {
        return IpV4Address.FIND_STATUS_LIST_BY_COUNTRY_NAME;
    }

    @Override
    public String findUndefinedList() {
        return IpV4Address.FIND_UNDEFINED_LIST;
    }

}
