package tc.lv.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    int id;

    @ManyToOne
    @JoinColumn(name = "country")
    Country country = new Country();

    @OneToMany
    @JoinColumn(name = "ip_addresses")
    Set<IpAddress> ipAddresses = new HashSet<IpAddress>();

    @Column(name = "city_name")
    String cityName;

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

}
