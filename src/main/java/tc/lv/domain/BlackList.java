package tc.lv.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "blacklist")
public class BlackList extends GeneralList {

	private static final long serialVersionUID = -1063159778990773734L;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ipV4_id", referencedColumnName = "id", updatable = true, nullable = true, unique = false)
	protected IpV4Address ipV4;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ipV6_id", referencedColumnName = "id", updatable = true, nullable = true, unique = false)
	protected IpV6Address ipV6;

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
