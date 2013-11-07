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
	@NamedQuery(name = "loadIpV6BySource", query = "SELECT ip FROM IpV6Address ip, Source s JOIN ip.sourceSet ipS JOIN s.ipSet sIp WHERE ipS.sourceId = :id AND sIp.id = ip.id"),
	@NamedQuery(name = "loadIpV6ByName", query = "SELECT c from IpV6Address c WHERE c.address= :address"),
	@NamedQuery(name = "loadWhiteIpV6List", query = "SELECT s from IpV6Address s where s.whiteList = :whitelist"),
	@NamedQuery(name = "loadUndefinedIpV6List", query = "SELECT s from IpV6Address s where s.whiteList is null"),
	@NamedQuery(name = "loadWhiteIpV6byName", query = "SELECT s from IpV6Address s where s.whiteList = TRUE and s.address =:address"),
	@NamedQuery(name = "loadBlackIpV6byName", query = "SELECT s from IpV6Address s where s.whiteList = FALSE and s.address =:address") })
public class IpV6Address extends IpAddress {

    @Column(name = "white_list")
    private Boolean whiteList;

    public void setWhiteList(boolean whiteList) {
	this.whiteList = whiteList;
    }

    public IpV6Address() {

    }

    public Boolean getWhiteList() {
	return this.whiteList;
    }

    public void setWhiteList(Boolean whiteList) {
	this.whiteList = whiteList;
    }

    public IpV6Address(String address) {
	this.address = address;
    }

    public IpV6Address(String address, Date dateAdded) {
	this.address = address;
	this.dateAdded = dateAdded;
    }
}
