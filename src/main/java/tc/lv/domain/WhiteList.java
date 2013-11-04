package tc.lv.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "whitelist")
@NamedQueries({
		@NamedQuery(name = "findIpV4ByNameInWL", query = "SELECT c from WhiteList c, IpV4Address d WHERE d.id=c.ipV4.id AND d.address= :address"),
		@NamedQuery(name = "findIpV6ByNameInWL", query = "SELECT c from WhiteList c, IpV6Address d WHERE d.id=c.ipV6.id AND d.address= :address"),
		@NamedQuery(name = "getIpV4WL", query = "SELECT ip from WhiteList wl, IpV4Address ip WHERE wl.ipV4.id = ip.id") })
public class WhiteList extends GeneralList {
	private static final long serialVersionUID = 8180638304564102169L;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ipV4_id", referencedColumnName = "id", updatable = true, nullable = true, unique = false)
	protected IpV4Address ipV4;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ipV6_id", referencedColumnName = "id", updatable = true, nullable = true, unique = false)
	protected IpV6Address ipV6;

	public WhiteList() {
		super();
	}

	public WhiteList(IpV4Address ipV4) {
		super();
		this.ipV4 = ipV4;
	}

	public WhiteList(IpV6Address ipV6) {
		super();
		this.ipV6 = ipV6;
	}

	public IpV4Address getIpV4() {
		return ipV4;
	}

	public void setIpV4(IpV4Address ipV4) {
		this.ipV4 = ipV4;
	}

}
