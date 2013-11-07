package tc.lv.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ipv4_addresses")
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({
	@NamedQuery(name = "loadIpV4BySource", query = "SELECT ip FROM IpV4Address ip, Source s JOIN ip.sourceSet ipS JOIN s.ipSet sIp WHERE ipS.sourceId = :id AND sIp.id = ip.id"),
	@NamedQuery(name = "loadIpV4ByName", query = "SELECT c from IpV4Address c WHERE c.address= :address"),
	@NamedQuery(name = "loadWhiteIpV4List", query = "SELECT s from IpV4Address s where s.whiteList = :whitelist"),
	@NamedQuery(name = "loadUndefinedIpV4List", query = "SELECT s from IpV4Address s where s.whiteList is null"),
	@NamedQuery(name = "loadWhiteIpV4byName", query = "SELECT s from IpV4Address s where s.whiteList = TRUE and s.address =:address"),
	@NamedQuery(name = "loadBlackIpV4byName", query = "SELECT s from IpV4Address s where s.whiteList = FALSE and s.address =:address") })
public class IpV4Address extends IpAddress implements Serializable {

    @Column(name = "white_list")
    private Boolean whiteList;

    public IpV4Address() {

    }

    public IpV4Address(String address) {
	this.address = address;
    }

    public IpV4Address(String address, Date dateAdded) {
	this.address = address;
	this.dateAdded = dateAdded;
    }

    public Boolean getWhiteList() {
	return this.whiteList;
    }

    public void setWhiteList(Boolean whiteList) {
	this.whiteList = whiteList;
    }

}
