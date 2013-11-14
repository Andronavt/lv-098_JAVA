package tc.lv.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ipv4_addresses")
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({
		@NamedQuery(name = "IpV4Address.getAll", query = "SELECT ip from IpV4Address ip"),
		@NamedQuery(name = "IpV4Address.getBySource", query = "SELECT ip from IpV4Address ip join ip.sourceSet s where s.sourceId= :id"),
		@NamedQuery(name = "IpV4Address.findByAddress", query = "SELECT ip from IpV4Address ip WHERE ip.address= :address"),
		@NamedQuery(name = "IpV4Address.getWhiteList", query = "SELECT ip from IpV4Address ip where ip.whiteList = :whitelist"),
		@NamedQuery(name = "IpV4Address.getUndefinedList", query = "SELECT ip from IpV4Address ip where ip.whiteList is null"),
		@NamedQuery(name = "IpV4Address.findWhiteIpByName", query = "SELECT ip from IpV4Address ip where ip.whiteList = TRUE and ip.address =:address"),
		@NamedQuery(name = "IpV4Address.findBlackIpByName", query = "SELECT ip from IpV4Address ip where ip.whiteList = FALSE and ip.address =:address") })
public class IpV4Address extends IpAddress implements Serializable {

	public IpV4Address() {

	}

	public IpV4Address(String address) {
		this.address = address;
	}

	public IpV4Address(String address, Date dateAdded) {
		this.address = address;
		this.dateAdded = dateAdded;
	}
}
