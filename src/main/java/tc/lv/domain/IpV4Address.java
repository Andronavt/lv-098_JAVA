package tc.lv.domain;

import java.io.Serializable;
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

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "ipv4_addresses")
public class IpV4Address extends IpAddress implements Serializable {

	
	@ManyToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinTable(name = "source_to_addresses", joinColumns = { @JoinColumn(name = "v4_id", updatable = true, nullable = true) }, inverseJoinColumns = { @JoinColumn(name = "source_id", updatable = true, nullable = true) })
	@Fetch(FetchMode.JOIN)
	//@OnDelete(action = OnDeleteAction.CASCADE)
	@Cascade(org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
	private Set<Source> sourceSet = new HashSet<Source>();
	
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "ipV4")
	private WhiteList whiteList;

	@OneToOne(fetch = FetchType.EAGER, mappedBy = "ipV4")
	private BlackList blackList;

	public IpV4Address() {

	}

	public IpV4Address(String address) {
		this.address = address;
	}

	public IpV4Address(String address, Date dateAdded) {
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
