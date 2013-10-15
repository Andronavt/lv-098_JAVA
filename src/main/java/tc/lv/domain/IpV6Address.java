package tc.lv.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(initialValue = 1, name = "generatev6")
@Table(name = "ipv6_addresses")
public class IpV6Address extends IpAddress {

	public IpV6Address() {

	}

	public IpV6Address(String address, Date dateAdded) {
		this.address = address;
		this.dateAdded = dateAdded;
	}
}
