package tc.lv.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "whitelist")
public class WhiteList extends GeneralList {
	/**
	 * 
	 */
	private static final long serialVersionUID = 130104776898930876L;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ipV4_id", referencedColumnName = "id", updatable = true, nullable = true, unique = false)
	protected IpV4Address ipV4;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ipV6_id", referencedColumnName = "id", updatable = true, nullable = true, unique = false)
	protected IpV6Address ipV6;

	// @PreRemove
	// private void preRemove() {
	// WhiteList whiteList = ipV4.getWhiteList();
	// ipV4.setWhiteList(null);
	// }

	public WhiteList() {
		super();
	}

	public IpV4Address getIpV4() {
		return ipV4;
	}

	public void setIpV4(IpV4Address ipV4) {
		this.ipV4 = ipV4;
	}
	

}
