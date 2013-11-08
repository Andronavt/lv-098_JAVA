package tc.lv.domain;

import java.io.Serializable;
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
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "ip_addresses")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class IpAddress implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	protected int id;

	@Column(name = "address", updatable = true, nullable = false)
	protected String address;

	@Column(name = "date_added")
	protected Date dateAdded;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "source_to_addresses", joinColumns = { @JoinColumn(name = "ip_id", updatable = true, nullable = true) }, inverseJoinColumns = { @JoinColumn(name = "source_id", updatable = true, nullable = true) })
	@Fetch(FetchMode.JOIN)
	private Set<Source> sourceSet = new HashSet<Source>();

	public IpAddress() {
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getIp() {
		return address;
	}

	@Override
	public int hashCode() {
		return address.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.getAddress().equals(((IpAddress) obj).getAddress());
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
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
