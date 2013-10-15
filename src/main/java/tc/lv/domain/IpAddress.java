package Test.First.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IpAddress implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "idGenerator")
	@Column(name = "id")
	private int id;
	@Column(name = "address")
	protected String address;
	@Column(name = "date_added")
	protected Date dateAdded;
	protected Set<IpSource> ipSourceSet = new HashSet<IpSource>(0);

	public IpAddress() {
	}

	public Set<IpSource> getIpSourceSet() {
		return ipSourceSet;
	}

	public void setIpSourceSet(Set<IpSource> ipSourceSet) {
		this.ipSourceSet = ipSourceSet;
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

	public Date getdateAdded() {
		return dateAdded;
	}

	public void setdateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getIp() {
		return address;
	}
}
