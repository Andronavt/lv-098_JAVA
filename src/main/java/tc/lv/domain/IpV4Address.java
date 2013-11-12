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
		@NamedQuery(name = "IpV4Address.getAll", query = "SELECT c from IpV4Address c"),
		@NamedQuery(name = "IpV4Address.getBySource", query = "SELECT ip FROM IpV4Address ip, Source s JOIN ip.sourceSet ipS JOIN s.ipSet sIp WHERE ipS.sourceId = :id AND sIp.id = ip.id"),
		@NamedQuery(name = "IpV4Address.findByAddress", query = "SELECT c from IpV4Address c WHERE c.address= :address"),
		@NamedQuery(name = "IpV4Address.getWhiteList", query = "SELECT ip from IpV4Address ip where ip.whiteList = :whitelist"),
		@NamedQuery(name = "IpV4Address.getUndefinedList", query = "SELECT s from IpV4Address s where s.whiteList is null"),
		@NamedQuery(name = "IpV4Address.findWhiteIpByName", query = "SELECT s from IpV4Address s where s.whiteList = TRUE and s.address =:address"),
		@NamedQuery(name = "IpV4Address.findBlackIpByName", query = "SELECT s from IpV4Address s where s.whiteList = FALSE and s.address =:address") })
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

	// @PrePersist()
	// public void persist(){
	// File file = new File();
	// }
}
