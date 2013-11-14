package tc.lv.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ipv6_addresses")
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({
		@NamedQuery(name = "IpV6Address.getAll", query = "SELECT ip from IpV6Address ip"),
		@NamedQuery(name = "IpV6Address.getBySource", query = "SELECT ip from IpV6Address ip join ip.sourceSet s where s.sourceId= :id"),
		@NamedQuery(name = "IpV6Address.findByAddress", query = "SELECT ip from IpV6Address ip WHERE ip.address= :address"),
		@NamedQuery(name = "IpV6Address.getWhiteList", query = "SELECT ip from IpV6Address ip where ip.whiteList = :whitelist"),
		@NamedQuery(name = "IpV6Address.getUndefinedList", query = "SELECT ip from IpV6Address ip where ip.whiteList is null"),
		@NamedQuery(name = "IpV6Address.findWhiteIpByName", query = "SELECT ip from IpV6Address ip where ip.whiteList = TRUE and ip.address =:address"),
		@NamedQuery(name = "IpV6Address.findBlackIpByName", query = "SELECT ip from IpV6Address ip where ip.whiteList = FALSE and ip.address =:address") })
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
