package tc.lv.dao;
import java.util.Collection;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;

public interface WhiteListDao {

	public Collection<IpV4Address> getUndefinedIpV4List();

	public void deleteIpV4FromWL(String address);

	public void addIpV4ToWL(String address);

	public void addIpV4ListToWL(Collection<String> list);

	public Collection<IpV6Address> getUndefinedIpV6List();

	public void deleteIpV6FromWL(String address);

	public void addIpV6ToWL(String address);

	public void addIpV6ListToWL(Collection<String> list);

	public Collection<IpV4Address> getWhiteIpV4List();
	
	public Collection<IpV6Address> getWhiteIpV6List();

}
