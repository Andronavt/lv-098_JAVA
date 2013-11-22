package tc.lv.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ipv6_addresses")
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({
        // --------
    @NamedQuery(name = IpV6Address.FIND_ALL, query = IpV6Address.FIND_ALL_QUERY),
    @NamedQuery(name = IpV6Address.FIND_IP_LIST_BY_SOURCE, query = IpV6Address.FIND_IP_LIST_BY_SOURCE_QUERY),
    @NamedQuery(name = IpV6Address.FIND_IP_LIST_BY_ADDRESS, query = IpV6Address.FIND_IP_LIST_BY_ADDRESS_QUERY),
    @NamedQuery(name = IpV6Address.FIND_STATUS_LIST, query = IpV6Address.FIND_STATUS_LIST_QUERY),
    @NamedQuery(name = IpV6Address.FIND_UNDEFINED_LIST, query = IpV6Address.FIND_UNDEFINEDLIST_QUERY),
    @NamedQuery(name = IpV6Address.FIND_IP_BY_NAME, query = IpV6Address.FIND_IP_BY_NAME_QUERY),
    @NamedQuery(name = IpV6Address.FIND_STATUS_LIST_BY_CITY, query = IpV6Address.FIND_STATUS_LIST_BY_CITY_QUERY),
    @NamedQuery(name = IpV6Address.FIND_STATUS_LIST_BY_COUNTRY, query = IpV6Address.FIND_STATUS_LIST_BY_COUNTRY_QUERY),
    @NamedQuery(name = IpV6Address.FIND_CITY_LIST_BY_STATUS, query = IpV6Address.FIND_CITY_LIST_BY_STATUS_QUERY),
    @NamedQuery(name = IpV6Address.FIND_COUNTRY_LIST_BY_STATUS, query = IpV6Address.FIND_COUNTRY_LIST_BY_STATUS_QUERY),

    @NamedQuery(name = IpV6Address.COUNT_ALL, query = IpV6Address.COUNT_ALL_QUERY),
    @NamedQuery(name = IpV6Address.COUNT_STATUS_LIST, query = IpV6Address.COUNT_STATUS_LIST_QUERY),
    @NamedQuery(name = IpV6Address.COUNT_STATUS_IP_BY_COUNTRY, query = IpV6Address.COUNT_STATUS_IP_BY_COUNTRY_QUERY),
    @NamedQuery(name = IpV6Address.COUNT_STATUS_IP_BY_CITY, query = IpV6Address.COUNT_STATUS_IP_BY_CITY_QUERY),
    @NamedQuery(name = IpV6Address.FIND_ALL_NOT_VALID, query = IpV6Address.FIND_ALL_NOT_VALID_QUERY),
    @NamedQuery(name = IpV6Address.FIND_ALL_VALID, query = IpV6Address.FIND_ALL_VALID_QUERY),
    @NamedQuery(name = IpV6Address.FIND_IP_LIST_BY_CITY, query = IpV6Address.FIND_IP_LIST_BY_CITY_QUERY),
    @NamedQuery(name = IpV6Address.FIND_IP_LIST_BY_COUNTRY, query = IpV6Address.FIND_IP_LIST_BY_COUNTRY_QUERY)
// ---
})
public class IpV6Address extends IpAddress {

    public static final String COUNT_ALL = "IpV6Address.countAll";
    public static final String COUNT_ALL_QUERY = "SELECT count(ip) from IpV6Address ip";

    public static final String COUNT_STATUS_LIST = "IpV6Address.countStatusList";
    public static final String COUNT_STATUS_LIST_QUERY = "SELECT count(ip) from IpV6Address ip where ip.status = ?1";

    public static final String COUNT_STATUS_IP_BY_CITY = "IpV6Address.countStatusIpByCity";
    public static final String COUNT_STATUS_IP_BY_CITY_QUERY = "SELECT count(ip) from IpV6Address ip where ip.status = ?1 and ip.city.cityName = ?2";

    public static final String COUNT_STATUS_IP_BY_COUNTRY = "IpV6Address.countStatusIpByCountry";
    public static final String COUNT_STATUS_IP_BY_COUNTRY_QUERY = "SELECT count(ip) from IpV6Address ip where ip.status = ?1 and ip.city.country.countryName = ?2";

    public static final String FIND_ALL = "IpV6Address.findAll";
    public static final String FIND_ALL_QUERY = "SELECT ip from IpV6Address ip";

    public static final String FIND_ALL_NOT_VALID = "IpV6Address.findAllNotValidIp";
    public static final String FIND_ALL_NOT_VALID_QUERY = "SELECT ip FROM IpV6Address ip, NotValidIp nv WHERE ip.id = nv.id";

    public static final String FIND_ALL_VALID = "IpV6Address.findAllValidIp";
    public static final String FIND_ALL_VALID_QUERY = "SELECT ipO FROM IpV6Address ipO WHERE ipO.id NOT IN (SELECT ipI.id FROM IpV6Address ipI, NotValidIp nv WHERE ipI.id = nv.id)";

    public static final String FIND_IP_LIST_BY_ADDRESS = "IpV6Address.findIpListByAddress";
    public static final String FIND_IP_LIST_BY_ADDRESS_QUERY = "SELECT ip from IpV6Address ip WHERE ip.address= ?1";

    public static final String FIND_IP_LIST_BY_SOURCE = "IpV6Address.findIpListBySource";
    public static final String FIND_IP_LIST_BY_SOURCE_QUERY = "SELECT ip from IpV6Address ip join ip.sourceSet s where s.sourceId = ?1";

    public static final String FIND_CITY_LIST_BY_STATUS = "IpV6Address.findCityListByStatus";
    public static final String FIND_CITY_LIST_BY_STATUS_QUERY = "SELECT distinct(ip.city.cityName) from IpV6Address ip where ip.status = ?1";

    public static final String FIND_COUNTRY_LIST_BY_STATUS = "IpV6Address.findCountryListByStatus";
    public static final String FIND_COUNTRY_LIST_BY_STATUS_QUERY = "SELECT distinct(ip.city.country.countryCode) from IpV6Address ip where ip.status = ?1";

    public static final String FIND_IP_LIST_BY_CITY = "IpV6Address.findIpByCity";
    public static final String FIND_IP_LIST_BY_CITY_QUERY = "SELECT ip from IpV6Address ip where ip.city.cityName = ?1";

    public static final String FIND_IP_LIST_BY_COUNTRY = "IpV6Address.findIpByCountry";
    public static final String FIND_IP_LIST_BY_COUNTRY_QUERY = "SELECT ip from IpV6Address ip where ip.city.country.countryName = ?1";

    public static final String FIND_IP_BY_NAME = "IpV6Address.findIpByName";
    public static final String FIND_IP_BY_NAME_QUERY = "SELECT ip from IpV6Address ip where ip.status = ?1 and ip.address = ?2";

    public static final String FIND_STATUS_LIST = "IpV6Address.findStatusList";
    public static final String FIND_STATUS_LIST_QUERY = "SELECT ip from IpV6Address ip where ip.status = ?1";

    public static final String FIND_STATUS_LIST_BY_CITY = "IpV6Address.findStatusListByCity";
    public static final String FIND_STATUS_LIST_BY_CITY_QUERY = "SELECT ip from IpV6Address ip where ip.status = ?1 and ip.city.cityName = ?2";

    public static final String FIND_STATUS_LIST_BY_COUNTRY = "IpV6Address.findStatusListByCountry";
    public static final String FIND_STATUS_LIST_BY_COUNTRY_QUERY = "SELECT ip from IpV6Address ip where ip.status = ?1 and ip.city.country.countryCode = ?2";

    public static final String FIND_UNDEFINED_LIST = "IpV6Address.findUndefinedList";
    public static final String FIND_UNDEFINEDLIST_QUERY = "SELECT ip from IpV6Address ip where ip.status is null";

    public IpV6Address() {

    }

    public IpV6Address(String address) {
        this.address = address;
    }

    public IpV6Address(String address, Date dateAdded, City city) {
        this.address = address;
        this.dateAdded = dateAdded;
        this.city = city;
    }
    // ----- IpInterface implementation -----
    @Override
    public String countAll() {
        return IpV6Address.COUNT_ALL;
    }

    @Override
    public String countStatusList() {
        return IpV6Address.COUNT_STATUS_LIST;
    }

    @Override
    public String countStatusIpByCity() {
        return IpV6Address.COUNT_STATUS_IP_BY_CITY;
    }

    @Override
    public String countStatusIpByCountry() {
        return IpV6Address.COUNT_STATUS_IP_BY_COUNTRY;
    }

    @Override
    public String findAll() {
        return IpV6Address.FIND_ALL;
    }

    @Override
    public String findAllNotValid() {
        return IpV6Address.FIND_ALL_NOT_VALID;
    }

    @Override
    public String findAllValid() {
        return IpV6Address.FIND_ALL_VALID;
    }

    @Override
    public String findByAddress() {
        return IpV6Address.FIND_IP_LIST_BY_ADDRESS;
    }

    @Override
    public String findIpListBySource() {
        return IpV6Address.FIND_IP_LIST_BY_SOURCE;
    }

    @Override
    public String findCityListByStatus() {
        return IpV6Address.FIND_CITY_LIST_BY_STATUS;
    }

    @Override
    public String findCountryListByStatus() {
        return IpV6Address.FIND_COUNTRY_LIST_BY_STATUS;
    }

    @Override
    public String findIpListByCity() {
        return IpV6Address.FIND_IP_LIST_BY_CITY;
    }

    @Override
    public String findIpListByCountry() {
        return IpV6Address.FIND_IP_LIST_BY_COUNTRY;
    }

    @Override
    public String findIpByName() {
        return IpV6Address.FIND_IP_BY_NAME;
    }

    @Override
    public String findStatusList() {
        return IpV6Address.FIND_STATUS_LIST;
    }

    @Override
    public String findStatusListByCity() {
        return IpV6Address.FIND_STATUS_LIST_BY_CITY;
    }

    @Override
    public String findStatusListByCountry() {
        return IpV6Address.FIND_STATUS_LIST_BY_COUNTRY;
    }

    @Override
    public String findUndefinedList() {
        return IpV6Address.FIND_UNDEFINED_LIST;
    }
}
