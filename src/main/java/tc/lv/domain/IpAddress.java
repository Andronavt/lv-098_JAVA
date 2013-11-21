package tc.lv.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "ip_addresses")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        // --------
        @NamedQuery(name = IpAddress.FIND_ALL, query = IpAddress.FIND_ALL_QUERY),
        @NamedQuery(name = IpAddress.FIND_BY_SOURCE, query = IpAddress.FIND_BY_SOURCE_QUERY),
        @NamedQuery(name = IpAddress.FIND_BY_ADDRESS, query = IpAddress.FIND_BY_ADDRESS_QUERY),
        @NamedQuery(name = IpAddress.FIND_WHITE_OR_BLACK_LIST, query = IpAddress.FIND_WHITE_OR_BLACK_LIST_QUERY),
        @NamedQuery(name = IpAddress.FIND_UNDEFINEDLIST, query = IpAddress.FIND_UNDEFINEDLIST_QUERY),
        @NamedQuery(name = IpAddress.FIND_WHITE_OR_BLACK_IP_BY_NAME, query = IpAddress.FIND_WHITE_OR_BLACK_IP_BY_NAME_QUERY),
        @NamedQuery(name = IpAddress.FIND_WHITE_OR_BLACK_LIST_BY_CITY, query = IpAddress.FIND_WHITE_OR_BLACK_LIST_BY_CITY_QUERY),
        @NamedQuery(name = IpAddress.FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY, query = IpAddress.FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY_QUERY),
        @NamedQuery(name = IpAddress.FIND_CITIES_WHITE_OR_BLACK_LIST, query = IpAddress.FIND_CITIES_WHITE_OR_BLACK_LIST_QUERY),
        @NamedQuery(name = IpAddress.FIND_COUNTRIES_WHITE_OR_BLACK_LIST, query = IpAddress.FIND_COUNTRIES_WHITE_OR_BLACK_LIST_QUERY),

        @NamedQuery(name = IpAddress.COUNT_ALL, query = IpAddress.COUNT_ALL_QUERY),
        @NamedQuery(name = IpAddress.COUNT_WHITE_OR_BLACK_LIST, query = IpAddress.COUNT_WHITE_OR_BLACK_LIST_QUERY),
        @NamedQuery(name = IpAddress.COUNT_WHITE_OR_BLACK_LIST_BY_COUNTRY, query = IpAddress.COUNT_WHITE_OR_BLACK_LIST_BY_COUNTRY_QUERY),
        @NamedQuery(name = IpAddress.FIND_ALL_NOT_VALID, query = IpAddress.FIND_ALL_NOT_VALID_QUERY),
        @NamedQuery(name = IpAddress.FIND_ALL_VALID, query = IpAddress.FIND_ALL_VALID_QUERY),
        @NamedQuery(name = IpAddress.FIND_IPLIST_BY_CITY, query = IpAddress.FIND_IPLIST_BY_CITY_QUERY),
        @NamedQuery(name = IpAddress.FIND_IPLIST_BY_COUNTRY, query = IpAddress.FIND_IPLIST_BY_COUNTRY_QUERY)
// ---
})
public class IpAddress {

    public static final String COUNT_ALL = "IpAddress.countAll";
    public static final String COUNT_ALL_QUERY = "SELECT count(ip) from IpAddress ip";

    public static final String COUNT_WHITE_OR_BLACK_LIST = "IpAddress.countWhiteOrBlackList";
    public static final String COUNT_WHITE_OR_BLACK_LIST_QUERY = "SELECT count(ip) from IpAddress ip where ip.whiteList = ?1";
    
    public static final String COUNT_WHITE_OR_BLACK_LIST_BY_COUNTRY = "IpAddress.countWhiteOrBlackListByCountry";
    public static final String COUNT_WHITE_OR_BLACK_LIST_BY_COUNTRY_QUERY = "SELECT count(ip) from IpAddress ip where ip.whiteList = ?1 and ip.city.country.countryName = ?2";

    public static final String FIND_ALL = "IpAddress.findAll";
    public static final String FIND_ALL_QUERY = "SELECT ip from IpAddress ip";

    public static final String FIND_ALL_NOT_VALID = "IpAddress.findAllNotValidIp";
    public static final String FIND_ALL_NOT_VALID_QUERY = "SELECT ip FROM IpAddress ip, NotValidIp nv WHERE ip.id = nv.id";

    public static final String FIND_ALL_VALID = "IpAddress.findAllValidIp";
    public static final String FIND_ALL_VALID_QUERY = "SELECT ipO FROM IpAddress ipO WHERE ipO.id NOT IN (SELECT ipI.id FROM IpAddress ipI, NotValidIp nv WHERE ipI.id = nv.id)";

    public static final String FIND_BY_ADDRESS = "IpAddress.findByAddress";
    public static final String FIND_BY_ADDRESS_QUERY = "SELECT ip from IpAddress ip WHERE ip.address= ?1";

    public static final String FIND_BY_SOURCE = "IpAddress.findBySource";
    public static final String FIND_BY_SOURCE_QUERY = "SELECT ip from IpAddress ip join ip.sourceSet s where s.sourceId = ?1";

    public static final String FIND_CITIES_WHITE_OR_BLACK_LIST = "IpAddress.findCityWhiteList";
    public static final String FIND_CITIES_WHITE_OR_BLACK_LIST_QUERY = "SELECT distinct(ip.city.cityName) from IpAddress ip where ip.whiteList = ?1";

    public static final String FIND_COUNTRIES_WHITE_OR_BLACK_LIST = "IpAddress.findCountryWhiteList";
    public static final String FIND_COUNTRIES_WHITE_OR_BLACK_LIST_QUERY = "SELECT distinct(ip.city.country.countryCode) from IpAddress ip where ip.whiteList = ?1";

    public static final String FIND_IPLIST_BY_CITY = "IpAddress.findIpByCity";
    public static final String FIND_IPLIST_BY_CITY_QUERY = "SELECT ip from IpAddress ip where ip.city.cityName = ?1";

    public static final String FIND_IPLIST_BY_COUNTRY = "IpAddress.findIpByCountry";
    public static final String FIND_IPLIST_BY_COUNTRY_QUERY = "SELECT ip from IpAddress ip where ip.city.country.countryName = ?1";

    public static final String FIND_UNDEFINEDLIST = "IpAddress.findUndefinedList";
    public static final String FIND_UNDEFINEDLIST_QUERY = "SELECT ip from IpAddress ip where ip.whiteList is null";

    public static final String FIND_WHITE_OR_BLACK_IP_BY_NAME = "IpAddress.findWhiteOrBlackIpByName";
    public static final String FIND_WHITE_OR_BLACK_IP_BY_NAME_QUERY = "SELECT ip from IpAddress ip where ip.whiteList = ?1 and ip.address = ?2";

    public static final String FIND_WHITE_OR_BLACK_LIST = "IpAddress.findWhiteOrBlackList";
    public static final String FIND_WHITE_OR_BLACK_LIST_QUERY = "SELECT ip from IpAddress ip where ip.whiteList = ?1";

    public static final String FIND_WHITE_OR_BLACK_LIST_BY_CITY = "IpAddress.findWhiteOrBlackListByCity";
    public static final String FIND_WHITE_OR_BLACK_LIST_BY_CITY_QUERY = "SELECT ip from IpAddress ip where ip.whiteList = ?1 and ip.city.cityName = ?2";

    public static final String FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY = "IpAddress.findWhiteOrBlackListByCountry";
    public static final String FIND_WHITE_OR_BLACK_LIST_BY_COUNTRY_QUERY = "SELECT ip from IpAddress ip where ip.whiteList = ?1 and ip.city.country.countryCode = ?2";

    @Column(name = "address", updatable = true, nullable = false, unique = true)
    protected String address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city")
    protected City city = new City();

    @Column(name = "date_added")
    protected Date dateAdded;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    protected int id;

    @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH }, fetch = FetchType.EAGER)
    @JoinTable(name = "sources_to_addresses", joinColumns = { @JoinColumn(name = "ip_id", updatable = true, nullable = true) }, inverseJoinColumns = { @JoinColumn(name = "source_id", updatable = true, nullable = true) })
    @Fetch(FetchMode.JOIN)
    private Set<Source> sourceSet = new HashSet<Source>();

    @Column(name = "white_list")
    protected Boolean whiteList;

    public IpAddress() {
    }

    @Override
    public boolean equals(Object obj) {
        return this.getAddress().equals(((IpAddress) obj).getAddress());
    }

    public String getAddress() {
        return address;
    }

    public City getCity() {
        return city;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public int getId() {
        return id;
    }

    public String getIp() {
        return address;
    }

    public Set<Source> getSourceSet() {
        return sourceSet;
    }

    public Boolean getWhiteList() {
        return this.whiteList;
    }

    @Override
    public int hashCode() {
        return address.hashCode();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSourceSet(Set<Source> sourceSet) {
        this.sourceSet = sourceSet;
    }

    public void setWhiteList(Boolean whiteList) {
        this.whiteList = whiteList;
    }

}
