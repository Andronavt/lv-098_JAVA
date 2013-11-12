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
		@NamedQuery(name = "IpV6Address.getAll", query = "SELECT c from IpV6Address c"),
		@NamedQuery(name = "IpV6Address.getBySource", query = "SELECT ip FROM IpV6Address ip, Source s JOIN ip.sourceSet ipS JOIN s.ipSet sIp WHERE ipS.sourceId = :id AND sIp.id = ip.id"),
		@NamedQuery(name = "IpV6Address.findByAddress", query = "SELECT c from IpV6Address c WHERE c.address= :address"),
		@NamedQuery(name = "IpV6Address.getWhiteList", query = "SELECT s from IpV6Address s where s.whiteList = :whitelist"),
		@NamedQuery(name = "IpV6Address.getUndefinedList", query = "SELECT s from IpV6Address s where s.whiteList is null"),
		@NamedQuery(name = "IpV6Address.findWhiteIpByName", query = "SELECT s from IpV6Address s where s.whiteList = TRUE and s.address =:address"),
		@NamedQuery(name = "IpV6Address.findBlackIpByName", query = "SELECT s from IpV6Address s where s.whiteList = FALSE and s.address =:address") })
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
