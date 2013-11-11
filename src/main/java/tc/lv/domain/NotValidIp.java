
package tc.lv.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "not_valid_ip")
@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({
	@NamedQuery(name = "NotValidIp.loadAll" , query = "SELECT ip FROM NotValidIp ip"),
	@NamedQuery(name = "NotValidIp.loadBySource", query = "SELECT ip FROM NotValidIp ip, Source s JOIN ip.sourceSet ipS JOIN s.ipSet sIp WHERE ipS.sourceId = :id AND sIp.id = ip.id")})
public class NotValidIp extends IpAddress {

	public NotValidIp() {

	}

	public NotValidIp(String address) {
		this.address = address;
	}

	public NotValidIp(String address, Date dateAdded) {
		this.address = address;
		this.dateAdded = dateAdded;
	}

}
