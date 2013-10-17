package tc.lv.domain.ipClasses;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ipv6_addresses")
public class IpV6Address extends IpAddress {

	public IpV6Address() {

	}
	
	public IpV6Address(String address) {
		this.address = address;
	}
	
	public IpV6Address(String address, Date dateAdded) {
		this.address = address;
		this.dateAdded = dateAdded;
	}
}
