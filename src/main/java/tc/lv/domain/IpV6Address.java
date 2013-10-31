package tc.lv.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
@Table(name = "ipv6_addresses")
public class IpV6Address extends IpAddress {

	
	@ManyToMany(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name = "source_to_addresses", joinColumns = { @JoinColumn(name = "v6_id", updatable = true, nullable = true) }, inverseJoinColumns = { @JoinColumn(name = "source_id", updatable = true, nullable = true) })
	@Fetch(FetchMode.JOIN)
	private Set<Source> sourceSet = new HashSet<Source>();
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "ipV6")
	private WhiteList whiteList;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "ipV6")
	private BlackList blackList;

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
