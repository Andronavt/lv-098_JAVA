package tc.lv.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

@Embeddable
public class Location {

    @JoinColumn(name = "country_name")
    private String countryName;

    @JoinColumn(name = "country_code")
    private String countryCode;

    @JoinColumn(name = "city_name")
    private String cityName;

    public Location() {
    }

    public Location(String countryName, String countryCode, String cityName) {
        this.countryName = countryName;
        this.countryCode = countryCode;
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
