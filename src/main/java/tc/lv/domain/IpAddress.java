package tc.lv.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IpAddress implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8772938813496814011L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	protected int id;
	@Column(name = "address", updatable = true, nullable = false)
	protected String address;
	@Column(name = "date_added")
	protected Date dateAdded;

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

	public Date getdateAdded() {
		return dateAdded;
	}

	public void setdateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
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

}
