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
        @NamedQuery(name = IpV6Address.FIND_BY_SOURCE, query = IpV6Address.FIND_BY_SOURCE_QUERY),
        @NamedQuery(name = IpV6Address.FIND_BY_ADDRESS, query = IpV6Address.FIND_BY_ADDRESS_QUERY),
        @NamedQuery(name = IpV6Address.FIND_WHITE_OR_BLACK_LIST, query = IpV6Address.FIND_WHITE_OR_BLACK_LIST_QUERY),
        @NamedQuery(name = IpV6Address.FIND_UNDEFINEDLIST, query = IpV6Address.FIND_UNDEFINEDLIST_QUERY),
        @NamedQuery(name = IpV6Address.FIND_WHITE_OR_BLACK_IP_BY_NAME, query = IpV6Address.FIND_WHITE_OR_BLACK_IP_BY_NAME_QUERY),
        @NamedQuery(name = IpV6Address.FIND_WHITE_OR_BLACK_LIST_BY_CITY, query = IpV6Address.FIND_WHITE_OR_BLACK_LIST_BY_CITY_QUERY),
        @NamedQuery(name = IpV6Address.FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY, query = IpV6Address.FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY_QUERY),
        @NamedQuery(name = IpV6Address.FIND_CITIES_WHITE_OR_BLACK_LIST, query = IpV6Address.FIND_CITIES_WHITE_OR_BLACK_LIST_QUERY),
        @NamedQuery(name = IpV6Address.FIND_COUNTRIES_WHITE_OR_BLACK_LIST, query = IpV6Address.FIND_COUNTRIES_WHITE_OR_BLACK_LIST_QUERY),

        @NamedQuery(name = IpV6Address.COUNT_ALL, query = IpV6Address.COUNT_ALL_QUERY),
        @NamedQuery(name = IpV6Address.COUNT_WHITE_OR_BLACK_LIST, query = IpV6Address.COUNT_WHITE_OR_BLACK_LIST_QUERY),
        @NamedQuery(name = IpV6Address.FIND_ALL_NOT_VALID, query = IpV6Address.FIND_ALL_NOT_VALID_QUERY),
        @NamedQuery(name = IpV6Address.FIND_ALL_VALID, query = IpV6Address.FIND_ALL_VALID_QUERY),
        @NamedQuery(name = IpV6Address.FIND_IPLIST_BY_CITY, query = IpV6Address.FIND_IPLIST_BY_CITY_QUERY),
        @NamedQuery(name = IpV6Address.FIND_IPLIST_BY_COUNTRY, query = IpV6Address.FIND_IPLIST_BY_COUNTRY_QUERY)
// ---
})
public class IpV6Address extends IpAddress {

    public static final String COUNT_ALL = "IpV6Address.countAll";
    public static final String COUNT_ALL_QUERY = "SELECT count(ip) from IpV6Address ip";

    public static final String COUNT_WHITE_OR_BLACK_LIST = "IpV6Address.countWhiteOrBlackList";
    public static final String COUNT_WHITE_OR_BLACK_LIST_QUERY = "SELECT count(ip) from IpV6Address ip where ip.whiteList = ?1";

    public static final String FIND_ALL = "IpV6Address.findAll";
    public static final String FIND_ALL_QUERY = "SELECT ip from IpV6Address ip";

    public static final String FIND_ALL_NOT_VALID = "IpV6Address.findAllNotValidIp";
    public static final String FIND_ALL_NOT_VALID_QUERY = "SELECT ip FROM IpV6Address ip, NotValidIp nv WHERE ip.id = nv.id";

    public static final String FIND_ALL_VALID = "IpV6Address.findAllValidIp";
    public static final String FIND_ALL_VALID_QUERY = "SELECT ipO FROM IpV6Address ipO WHERE ipO.id NOT IN (SELECT ipI.id FROM IpV6Address ipI, NotValidIp nv WHERE ipI.id = nv.id)";

    public static final String FIND_BY_ADDRESS = "IpV6Address.findByAddress";
    public static final String FIND_BY_ADDRESS_QUERY = "SELECT ip from IpV6Address ip WHERE ip.address= ?1";

    public static final String FIND_BY_SOURCE = "IpV6Address.findBySource";
    public static final String FIND_BY_SOURCE_QUERY = "SELECT ip from IpV6Address ip join ip.sourceSet s where s.sourceId = ?1";

    public static final String FIND_CITIES_WHITE_OR_BLACK_LIST = "IpV6Address.findCityWhiteList";
    public static final String FIND_CITIES_WHITE_OR_BLACK_LIST_QUERY = "SELECT distinct(ip.city) from IpV6Address ip where ip.whiteList = ?1";

    public static final String FIND_COUNTRIES_WHITE_OR_BLACK_LIST = "IpV6Address.findCountryWhiteList";
    public static final String FIND_COUNTRIES_WHITE_OR_BLACK_LIST_QUERY = "SELECT distinct(ip.city.country) from IpV6Address ip where ip.whiteList = ?1";

    public static final String FIND_IPLIST_BY_CITY = "IpV6Address.findIpByCity";
    public static final String FIND_IPLIST_BY_CITY_QUERY = "SELECT ip from IpV6Address ip where ip.city.cityName = ?1";

    public static final String FIND_IPLIST_BY_COUNTRY = "IpV6Address.findIpByCountry";
    public static final String FIND_IPLIST_BY_COUNTRY_QUERY = "SELECT ip from IpV6Address ip where ip.city.country.countryName = ?1";

    public static final String FIND_UNDEFINEDLIST = "IpV6Address.findUndefinedList";
    public static final String FIND_UNDEFINEDLIST_QUERY = "SELECT ip from IpV6Address ip where ip.whiteList is null";

    public static final String FIND_WHITE_OR_BLACK_IP_BY_NAME = "IpV6Address.findWhiteOrBlackIpByName";
    public static final String FIND_WHITE_OR_BLACK_IP_BY_NAME_QUERY = "SELECT ip from IpV6Address ip where ip.whiteList = ?1 and ip.address = ?2";

    public static final String FIND_WHITE_OR_BLACK_LIST = "IpV6Address.findWhiteOrBlackList";
    public static final String FIND_WHITE_OR_BLACK_LIST_QUERY = "SELECT ip from IpV6Address ip where ip.whiteList = ?1";

    public static final String FIND_WHITE_OR_BLACK_LIST_BY_CITY = "IpV6Address.findWhiteOrBlackListByCity";
    public static final String FIND_WHITE_OR_BLACK_LIST_BY_CITY_QUERY = "SELECT ip from IpV6Address ip where ip.whiteList = ?1 and ip.city.cityName = ?2";

    public static final String FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY = "IpV6Address.findWhiteOrBlackListByCountry";
    public static final String FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY_QUERY = "SELECT ip from IpV6Address ip where ip.whiteList = ?1 and ip.city.country.countryName = ?2";

    public IpV6Address() {

    }

    public IpV6Address(String address) {
        this.address = address;
    }

    public IpV6Address(String address, Date dateAdded) {
        this.address = address;
        this.dateAdded = dateAdded;
    }
}
