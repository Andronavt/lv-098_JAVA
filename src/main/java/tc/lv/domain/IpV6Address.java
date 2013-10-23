package tc.lv.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "ipv6_addresses")
public class IpV6Address extends IpAddress {

	@ManyToMany(cascade = CascadeType.MERGE, mappedBy = "ipv6Set")
	private Set<Source> sourceSet = new HashSet<Source>();

	public IpV6Address() {

	}

	public IpV6Address(String address) {
		this.address = address;
	}

	public IpV6Address(String address, Date dateAdded) {
		this.address = address;
		this.dateAdded = dateAdded;
	}

	public Set<Source> getSourceSet() {
		return sourceSet;
	}

	public void setSourceSet(Set<Source> sourceSet) {
		this.sourceSet = sourceSet;
	}

	public void addElementToSourceSet(Source source) {
		sourceSet.add(source);
	}

}
