package tc.lv.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(initialValue = 1, name = "generatev4")
@Table(name = "ipv4_addresses")
//test comment
public class IpV4Address extends IpAddress {

	public IpV4Address() {

	}

	public IpV4Address(String address, Date dateAdded) {
		this.address = address;
		this.dateAdded = dateAdded;
	}
}
