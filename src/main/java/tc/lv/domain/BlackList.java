package tc.lv.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "blacklist")
@NamedQueries({
		@NamedQuery(name = "IpV4Address.findByNameInBlackList", query = "SELECT c from BlackList c, IpV4Address d WHERE d.id=c.ipV4.id AND d.address= :address"),
		@NamedQuery(name = "IpV6Address.findByNameInBlackList", query = "SELECT c from BlackList c, IpV6Address d WHERE d.id=c.ipV4.id AND d.address= :address")})
public class BlackList extends GeneralList {
	private static final long serialVersionUID = 2844104889899109411L;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ipV4_id", referencedColumnName = "id", updatable = true, nullable = true, unique = false)
	protected IpV4Address ipV4;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ipV6_id", referencedColumnName = "id", updatable = true, nullable = true, unique = false)
	protected IpV4Address ipV6;

	public BlackList() {
		super();
	}

	public IpV4Address getIpV4() {
		return ipV4;
	}

	public void setIpV4(IpV4Address ipV4) {
		this.ipV4 = ipV4;
	}

}
