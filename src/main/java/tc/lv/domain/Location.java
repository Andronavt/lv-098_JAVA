package tc.lv.domain;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

@Embeddable
public class Location {
    
    @JoinColumn(name = "country")
    private String country;
    
    @JoinColumn(name = "city")
    private String city;

    public Location() {
    }

    public Location(String country, String city) {
	this.country = country;
	this.city = city;
    }

    public String getCountry() {
	return this.country;
    }

    public void setCountry(String country) {
	this.country = country;
    }

    public String getCity() {
	return this.city;
    }

    public void setCity(String city) {
	this.city = city;
    }
}
