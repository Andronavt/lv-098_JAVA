package tc.lv.domain.ipclasses;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "not_valid_ip")
public class NotValidIp extends IpAddress {
	
	public NotValidIp() {

	}
	
	public NotValidIp(String address, Date dateAdded) {
		this.address = address;
		this.dateAdded = dateAdded;
	}

}
