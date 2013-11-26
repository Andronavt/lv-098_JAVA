package tc.lv.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "country")
@NamedQueries({
        // -----
        @NamedQuery(name = Country.FIND_ALL, query = Country.FIND_ALL_QUERY),
        @NamedQuery(name = Country.FIND_COUNTRY_CODE_LIST_BY_STATUS, query = Country.FIND_COUNTRY_CODE_LIST_BY_STATUS_QUERY),
        @NamedQuery(name = Country.FIND_COUNTRY_CODE_BY_COUNTRY_NAME, query = Country.FIND_COUNTRY_CODE_BY_COUNTRY_NAME_QUERY),
        @NamedQuery(name = Country.FIND_COUNTRY_NAME_LIST_BY_STATUS, query = Country.FIND_COUNTRY_NAME_LIST_BY_STATUS_QUERY),
// -----
})
public class Country {
    public static final String FIND_ALL = "Country.findAll";
    static final String FIND_ALL_QUERY = "SELECT co from Country co";

    public static final String FIND_COUNTRY_CODE_LIST_BY_STATUS = "Country.findCountryCodeListByStatus";
    static final String FIND_COUNTRY_CODE_LIST_BY_STATUS_QUERY = "SELECT distinct(ip.city.country.countryCode) from IpAddress ip where ip.status = ?1";

    public static final String FIND_COUNTRY_NAME_LIST_BY_STATUS = "Country.findCountryNameListByStatus";
    static final String FIND_COUNTRY_NAME_LIST_BY_STATUS_QUERY = "SELECT distinct(ip.city.country.countryName) from IpAddress ip where ip.status = ?1";

    public static final String FIND_COUNTRY_CODE_BY_COUNTRY_NAME = "Country.findCountryCodeByCountryName";
    static final String FIND_COUNTRY_CODE_BY_COUNTRY_NAME_QUERY = "SELECT distinct(co.countryCode) from Country co where co.countryName = ?1";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @OneToMany(mappedBy = "country", fetch = FetchType.LAZY)
    private Set<City> cities;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "country_name")
    private String countryName;

    public Country() {

    }

    public Country(String countryName, String countryCode) {
        this.countryName = countryName;
        this.countryCode = countryCode;
    }

    public Set<City> getCitySet() {
        return cities;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getId() {
        return id;
    }

    public void setCities(Set<City> cities) {
        this.cities = cities;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return countryName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return countryName.equals(((Country) obj).getCountryName());
    }

    @PrePersist
    private void setLocationData() {

    }

}
