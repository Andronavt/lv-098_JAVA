package Test.First.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ipv6_addresses implements Ip {

	private int id;
	private String address;
	private Date date_added;
	private Set<IpSource> ipSourceSet = new HashSet<IpSource>(0);

	public ipv6_addresses(String address, Date date_added) {
		super();
		this.address = address;
		this.date_added = date_added;
	}

	public Set<IpSource> getIpSourceSet() {
		return ipSourceSet;
	}

	public void setIpSourceSet(Set<IpSource> ipSourceSet) {
		this.ipSourceSet = ipSourceSet;
	}

	public ipv6_addresses() {
	}

	public int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate_added() {
		return date_added;
	}

	public void setDate_added(Date date_added) {
		this.date_added = date_added;
	}

	@Override
	public String getIp() {
		return address;
	}

}
