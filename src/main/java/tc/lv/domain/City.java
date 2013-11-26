package tc.lv.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "city")
@NamedQueries({
        // -----
        @NamedQuery(name = City.FIND_ALL, query = City.FIND_ALL_QUERY),
        @NamedQuery(name = City.FIND_CITY_NAME_LIST_BY_STATUS, query = City.FIND_CITY_NAME_LIST_BY_STATUS_QUERY),

// -----
})
public class City {
    public static final String FIND_ALL = "City.findAll";
    static final String FIND_ALL_QUERY = "SELECT ci from City ci";

    public static final String FIND_CITY_NAME_LIST_BY_STATUS = "City.findCityNameListByStatus";
    static final String FIND_CITY_NAME_LIST_BY_STATUS_QUERY = "SELECT distinct(ip.city.cityName) from City ci, IpAddress ip where ip.status = ?1";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "country")
    private Country country = new Country();

    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private Set<IpAddress> ipAddresses = new HashSet<IpAddress>();

    @Column(name = "city_name")
    private String cityName;

    public City() {

    }

    public City(String cityName, Country country) {
        this.cityName = cityName;
        this.country = country;
    }

    public String getCityName() {
        return cityName;
    }

    public Country getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

    public Set<IpAddress> getIpAddresses() {
        return ipAddresses;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIpAddresses(Set<IpAddress> ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    @Override
    public int hashCode() {
        return cityName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return cityName.equals(((City) obj).getCityName());
    }

    @PrePersist
    private void setLocationData() {

    }

}
