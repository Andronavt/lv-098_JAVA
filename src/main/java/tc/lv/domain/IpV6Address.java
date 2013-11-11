package tc.lv.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ipv6_addresses")
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({
	@NamedQuery(name = "IpV6Address.loadBySource", query = "SELECT ip FROM IpV6Address ip, Source s JOIN ip.sourceSet ipS JOIN s.ipSet sIp WHERE ipS.sourceId = :id AND sIp.id = ip.id"),
	@NamedQuery(name = "IpV6Address.loadAll", query = "SELECT c from IpV6Address c"),
	@NamedQuery(name = "IpV6Address.loadByName", query = "SELECT c from IpV6Address c WHERE c.address= :address"),
	@NamedQuery(name = "IpV6Address.loadWhiteList", query = "SELECT s from IpV6Address s where s.whiteList = :whitelist"),
	@NamedQuery(name = "IpV6Address.loadUndefinedList", query = "SELECT s from IpV6Address s where s.whiteList is null"),
	@NamedQuery(name = "IpV6Address.loadWhiteIpByName", query = "SELECT s from IpV6Address s where s.whiteList = TRUE and s.address =:address"),
	@NamedQuery(name = "IpV6Address.loadBlackIpByName", query = "SELECT s from IpV6Address s where s.whiteList = FALSE and s.address =:address") })
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
