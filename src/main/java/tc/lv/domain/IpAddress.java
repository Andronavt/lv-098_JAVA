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

import tc.lv.dao.IpInterface;

@Entity
@Table(name = "ip_addresses")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQueries({
        // -----
        @NamedQuery(name = IpAddress.FIND_ALL, query = IpAddress.FIND_ALL_QUERY),
        @NamedQuery(name = IpAddress.FIND_IP_LIST_BY_SOURCE, query = IpAddress.FIND_IP_LIST_BY_SOURCE_QUERY),
        @NamedQuery(name = IpAddress.FIND_IP_LIST_BY_ADDRESS, query = IpAddress.FIND_IP_LIST_BY_ADDRESS_QUERY),
        @NamedQuery(name = IpAddress.FIND_STATUS_LIST, query = IpAddress.FIND_STATUS_LIST_QUERY),
        @NamedQuery(name = IpAddress.FIND_UNDEFINED_LIST, query = IpAddress.FIND_UNDEFINEDLIST_QUERY),
        @NamedQuery(name = IpAddress.FIND_IP_BY_NAME, query = IpAddress.FIND_IP_BY_NAME_QUERY),
        @NamedQuery(name = IpAddress.FIND_STATUS_LIST_BY_CITY, query = IpAddress.FIND_STATUS_LIST_BY_CITY_QUERY),
        @NamedQuery(name = IpAddress.FIND_STATUS_LIST_BY_COUNTRY_NAME, query = IpAddress.FIND_STATUS_LIST_BY_COUNTRY_NAME_QUERY),

        @NamedQuery(name = IpAddress.COUNT_ALL, query = IpAddress.COUNT_ALL_QUERY),
        @NamedQuery(name = IpAddress.COUNT_STATUS_LIST, query = IpAddress.COUNT_STATUS_LIST_QUERY),
        @NamedQuery(name = IpAddress.COUNT_STATUS_IP_BY_COUNTRY_CODE, query = IpAddress.COUNT_STATUS_IP_BY_COUNTRY_CODE_QUERY),
        @NamedQuery(name = IpAddress.COUNT_STATUS_IP_BY_COUNTRY_NAME, query = IpAddress.COUNT_STATUS_IP_BY_COUNTRY_NAME_QUERY),
        @NamedQuery(name = IpAddress.COUNT_STATUS_IP_BY_CITY_NAME, query = IpAddress.COUNT_STATUS_IP_BY_CITY_NAME_QUERY),
        @NamedQuery(name = IpAddress.FIND_ALL_NOT_VALID, query = IpAddress.FIND_ALL_NOT_VALID_QUERY),
        @NamedQuery(name = IpAddress.FIND_ALL_VALID, query = IpAddress.FIND_ALL_VALID_QUERY),
        @NamedQuery(name = IpAddress.FIND_IP_LIST_BY_CITY, query = IpAddress.FIND_IP_LIST_BY_CITY_QUERY),
        @NamedQuery(name = IpAddress.FIND_IP_LIST_BY_COUNTRY, query = IpAddress.FIND_IP_LIST_BY_COUNTRY_QUERY)
// -----
})
public class IpAddress implements IpInterface {

    public static final String COUNT_ALL = "IpAddress.countAll";
    static final String COUNT_ALL_QUERY = "SELECT count(ip) from IpAddress ip";

    public static final String COUNT_STATUS_LIST = "IpAddress.countStatusList";
    static final String COUNT_STATUS_LIST_QUERY = "SELECT count(ip) from IpAddress ip where ip.status = ?1";

    public static final String COUNT_STATUS_IP_BY_CITY_NAME = "IpAddress.countStatusIpByCityName";
    static final String COUNT_STATUS_IP_BY_CITY_NAME_QUERY = "SELECT count(ip) from IpAddress ip where ip.status = ?1 and ip.city.cityName = ?2";

    public static final String COUNT_STATUS_IP_BY_COUNTRY_CODE = "IpAddress.countStatusIpByCountryCode";
    static final String COUNT_STATUS_IP_BY_COUNTRY_CODE_QUERY = "SELECT count(ip) from IpAddress ip where ip.status = ?1 and ip.city.country.countryCode = ?2";

    public static final String COUNT_STATUS_IP_BY_COUNTRY_NAME = "IpAddress.countStatusIpByCountryName";
    static final String COUNT_STATUS_IP_BY_COUNTRY_NAME_QUERY = "SELECT count(ip) from IpAddress ip where ip.status = ?1 and ip.city.country.countryName = ?2";

    public static final String FIND_ALL = "IpAddress.findAll";
    static final String FIND_ALL_QUERY = "SELECT ip from IpAddress ip";

    public static final String FIND_ALL_NOT_VALID = "IpAddress.findAllNotValidIp";
    static final String FIND_ALL_NOT_VALID_QUERY = "SELECT ip FROM IpAddress ip, NotValidIp nv WHERE ip.id = nv.id";

    public static final String FIND_ALL_VALID = "IpAddress.findAllValidIp";
    static final String FIND_ALL_VALID_QUERY = "SELECT ipO FROM IpAddress ipO WHERE ipO.id NOT IN (SELECT ipI.id FROM IpAddress ipI, NotValidIp nv WHERE ipI.id = nv.id)";

    public static final String FIND_IP_LIST_BY_ADDRESS = "IpAddress.findIpListByAddress";
    static final String FIND_IP_LIST_BY_ADDRESS_QUERY = "SELECT ip from IpAddress ip WHERE ip.address= ?1";

    public static final String FIND_IP_LIST_BY_SOURCE = "IpAddress.findIpListBySource";
    static final String FIND_IP_LIST_BY_SOURCE_QUERY = "SELECT ip from IpAddress ip join ip.sourceSet s where s.sourceId = ?1";

    public static final String FIND_IP_LIST_BY_CITY = "IpAddress.findIpByCity";
    static final String FIND_IP_LIST_BY_CITY_QUERY = "SELECT ip from IpAddress ip where ip.city.cityName = ?1";

    public static final String FIND_IP_LIST_BY_COUNTRY = "IpAddress.findIpByCountry";
    static final String FIND_IP_LIST_BY_COUNTRY_QUERY = "SELECT ip from IpAddress ip where ip.city.country.countryName = ?1";

    public static final String FIND_IP_BY_NAME = "IpAddress.findIpByName";
    static final String FIND_IP_BY_NAME_QUERY = "SELECT ip from IpAddress ip where ip.status = ?1 and ip.address = ?2";

    public static final String FIND_STATUS_LIST = "IpAddress.findStatusList";
    static final String FIND_STATUS_LIST_QUERY = "SELECT ip from IpAddress ip where ip.status = ?1";

    public static final String FIND_STATUS_LIST_BY_CITY = "IpAddress.findStatusListByCity";
    static final String FIND_STATUS_LIST_BY_CITY_QUERY = "SELECT ip from IpAddress ip where ip.status = ?1 and ip.city.cityName = ?2";

    public static final String FIND_STATUS_LIST_BY_COUNTRY_NAME = "IpAddress.findStatusListByCountryName";
    static final String FIND_STATUS_LIST_BY_COUNTRY_NAME_QUERY = "SELECT ip from IpAddress ip where ip.status = ?1 and ip.city.country.countryName = ?2";

    public static final String FIND_UNDEFINED_LIST = "IpAddress.findUndefinedList";
    static final String FIND_UNDEFINEDLIST_QUERY = "SELECT ip from IpAddress ip where ip.status is null";

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

    @Column(name = "status")
    protected Boolean status;

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

    public Boolean getStatus() {
        return this.status;
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

    public void setStatus(Boolean status) {
        this.status = status;
    }

    // ----- IpInterface implementation -----
    @Override
    public String countAll() {
        return IpAddress.COUNT_ALL;
    }

    @Override
    public String countStatusList() {
        return IpAddress.COUNT_STATUS_LIST;
    }

    @Override
    public String countStatusIpByCityName() {
        return IpAddress.COUNT_STATUS_IP_BY_CITY_NAME;
    }

    @Override
    public String countStatusIpByCountryName() {
        return IpAddress.COUNT_STATUS_IP_BY_COUNTRY_NAME;
    }

    @Override
    public String countStatusIpByCountryCode() {
        return IpAddress.COUNT_STATUS_IP_BY_COUNTRY_CODE;
    }

    @Override
    public String findAll() {
        return IpAddress.FIND_ALL;
    }

    @Override
    public String findByAddress() {
        return IpAddress.FIND_IP_LIST_BY_ADDRESS;
    }

    @Override
    public String findIpListBySource() {
        return IpAddress.FIND_IP_LIST_BY_SOURCE;
    }

    @Override
    public String findStatusList() {
        return IpAddress.FIND_STATUS_LIST;
    }

    @Override
    public String findStatusListByCity() {
        return IpAddress.FIND_STATUS_LIST_BY_CITY;
    }

    @Override
    public String findStatusListByCountryName() {
        return IpAddress.FIND_STATUS_LIST_BY_COUNTRY_NAME;
    }

    @Override
    public String findUndefinedList() {
        return IpAddress.FIND_UNDEFINED_LIST;
    }

}
