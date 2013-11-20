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
        @NamedQuery(name = IpV4Address.FIND_BY_SOURCE, query = IpV4Address.FIND_BY_SOURCE_QUERY),
        @NamedQuery(name = IpV4Address.FIND_BY_ADDRESS, query = IpV4Address.FIND_BY_ADDRESS_QUERY),
        @NamedQuery(name = IpV4Address.FIND_WHITE_OR_BLACK_LIST, query = IpV4Address.FIND_WHITE_OR_BLACK_LIST_QUERY),
        @NamedQuery(name = IpV4Address.FIND_UNDEFINEDLIST, query = IpV4Address.FIND_UNDEFINEDLIST_QUERY),
        @NamedQuery(name = IpV4Address.FIND_WHITE_OR_BLACK_IP_BY_NAME, query = IpV4Address.FIND_WHITE_OR_BLACK_IP_BY_NAME_QUERY),
        @NamedQuery(name = IpV4Address.FIND_WHITE_OR_BLACK_LIST_BY_CITY, query = IpV4Address.FIND_WHITE_OR_BLACK_LIST_BY_CITY_QUERY),
        @NamedQuery(name = IpV4Address.FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY, query = IpV4Address.FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY_QUERY),
        @NamedQuery(name = IpV4Address.FIND_CITIES_WHITE_OR_BLACK_LIST, query = IpV4Address.FIND_CITIES_WHITE_OR_BLACK_LIST_QUERY),
        @NamedQuery(name = IpV4Address.FIND_COUNTRIES_WHITE_OR_BLACK_LIST, query = IpV4Address.FIND_COUNTRIES_WHITE_OR_BLACK_LIST_QUERY),

        @NamedQuery(name = IpV4Address.COUNT_ALL, query = IpV4Address.COUNT_ALL_QUERY),
        @NamedQuery(name = IpV4Address.COUNT_WHITE_OR_BLACK_LIST, query = IpV4Address.COUNT_WHITE_OR_BLACK_LIST_QUERY),
        @NamedQuery(name = IpV4Address.FIND_ALL_NOT_VALID, query = IpV4Address.FIND_ALL_NOT_VALID_QUERY),
        @NamedQuery(name = IpV4Address.FIND_ALL_VALID, query = IpV4Address.FIND_ALL_VALID_QUERY),
        @NamedQuery(name = IpV4Address.FIND_IPLIST_BY_CITY, query = IpV4Address.FIND_IPLIST_BY_CITY_QUERY),
        @NamedQuery(name = IpV4Address.FIND_IPLIST_BY_COUNTRY, query = IpV4Address.FIND_IPLIST_BY_COUNTRY_QUERY)
// ---
})
public class IpV4Address extends IpAddress {

    public static final String COUNT_ALL = "IpV4Address.countAll";
    public static final String COUNT_ALL_QUERY = "SELECT count(ip) from IpV4Address ip";

    public static final String COUNT_WHITE_OR_BLACK_LIST = "IpV4Address.countWhiteOrBlackList";
    public static final String COUNT_WHITE_OR_BLACK_LIST_QUERY = "SELECT count(ip) from IpV4Address ip where ip.whiteList = ?1";

    public static final String FIND_ALL = "IpV4Address.findAll";
    public static final String FIND_ALL_QUERY = "SELECT ip from IpV4Address ip";

    public static final String FIND_ALL_NOT_VALID = "IpV4Address.findAllNotValidIp";
    public static final String FIND_ALL_NOT_VALID_QUERY = "SELECT ip FROM IpV4Address ip, NotValidIp nv WHERE ip.id = nv.id";

    public static final String FIND_ALL_VALID = "IpV4Address.findAllValidIp";
    public static final String FIND_ALL_VALID_QUERY = "SELECT ipO FROM IpV4Address ipO WHERE ipO.id NOT IN (SELECT ipI.id FROM IpV4Address ipI, NotValidIp nv WHERE ipI.id = nv.id)";

    public static final String FIND_BY_ADDRESS = "IpV4Address.findByAddress";
    public static final String FIND_BY_ADDRESS_QUERY = "SELECT ip from IpV4Address ip WHERE ip.address= ?1";

    public static final String FIND_BY_SOURCE = "IpV4Address.findBySource";
    public static final String FIND_BY_SOURCE_QUERY = "SELECT ip from IpV4Address ip join ip.sourceSet s where s.sourceId = ?1";

    public static final String FIND_CITIES_WHITE_OR_BLACK_LIST = "IpV4Address.findCityWhiteList";
    public static final String FIND_CITIES_WHITE_OR_BLACK_LIST_QUERY = "SELECT distinct(ip.city) from IpV4Address ip where ip.whiteList = ?1";

    public static final String FIND_COUNTRIES_WHITE_OR_BLACK_LIST = "IpV4Address.findCountryWhiteList";
    public static final String FIND_COUNTRIES_WHITE_OR_BLACK_LIST_QUERY = "SELECT distinct(ip.city.country) from IpV4Address ip where ip.whiteList = ?1";

    public static final String FIND_IPLIST_BY_CITY = "IpV4Address.findIpByCity";
    public static final String FIND_IPLIST_BY_CITY_QUERY = "SELECT ip from IpV4Address ip where ip.city.cityName = ?1";

    public static final String FIND_IPLIST_BY_COUNTRY = "IpV4Address.findIpByCountry";
    public static final String FIND_IPLIST_BY_COUNTRY_QUERY = "SELECT ip from IpV4Address ip where ip.city.country.countryName = ?1";

    public static final String FIND_UNDEFINEDLIST = "IpV4Address.findUndefinedList";
    public static final String FIND_UNDEFINEDLIST_QUERY = "SELECT ip from IpV4Address ip where ip.whiteList is null";

    public static final String FIND_WHITE_OR_BLACK_IP_BY_NAME = "IpV4Address.findWhiteOrBlackIpByName";
    public static final String FIND_WHITE_OR_BLACK_IP_BY_NAME_QUERY = "SELECT ip from IpV4Address ip where ip.whiteList = ?1 and ip.address = ?2";

    public static final String FIND_WHITE_OR_BLACK_LIST = "IpV4Address.findWhiteOrBlackList";
    public static final String FIND_WHITE_OR_BLACK_LIST_QUERY = "SELECT ip from IpV4Address ip where ip.whiteList = ?1";

    public static final String FIND_WHITE_OR_BLACK_LIST_BY_CITY = "IpV4Address.findWhiteOrBlackListByCity";
    public static final String FIND_WHITE_OR_BLACK_LIST_BY_CITY_QUERY = "SELECT ip from IpV4Address ip where ip.whiteList = ?1 and ip.city.cityName = ?2";

    public static final String FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY = "IpV4Address.findWhiteOrBlackListByCountry";
    public static final String FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY_QUERY = "SELECT ip from IpV4Address ip where ip.whiteList = ?1 and ip.city.country.countryName = ?2";

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
}
