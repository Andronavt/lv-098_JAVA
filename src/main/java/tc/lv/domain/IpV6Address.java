package tc.lv.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "ipv6_addresses")
@NamedQueries({
		@NamedQuery(name = "loadIpV6ByName", query = "SELECT c from IpV6Address c WHERE c.address= :address"),
		@NamedQuery(name = "loadWhiteIpV6List", query = "SELECT s from IpV6Address s where s.whiteList = :whitelist"),
		@NamedQuery(name = "loadUndefinedIpV6List", query = "SELECT s from IpV6Address s where s.whiteList is null"),
		@NamedQuery(name = "loadWhiteIpV6byName", query = "SELECT s from IpV6Address s where s.whiteList = TRUE and s.address =:address"),
		@NamedQuery(name = "loadBlackIpV6byName", query = "SELECT s from IpV6Address s where s.whiteList = FALSE and s.address =:address")})
public class IpV6Address extends IpAddress {

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "source_to_addresses", joinColumns = {@JoinColumn(name = "v6_id", updatable = true, nullable = true)}, inverseJoinColumns = {@JoinColumn(name = "source_id", updatable = true, nullable = true)})
	@Fetch(FetchMode.JOIN)
	private Set<Source> sourceSet = new HashSet<Source>();

	@Column(name = "white_list")
	private Boolean whiteList;

	public void setWhiteList(boolean whiteList) {
		this.whiteList = whiteList;
	}

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

	public Boolean getWhiteList() {
		return whiteList;
	}

	public void setWhiteList(Boolean whiteList) {
		this.whiteList = whiteList;
	}

}
