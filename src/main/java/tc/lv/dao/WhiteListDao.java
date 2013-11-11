package tc.lv.dao;

import java.util.Collection;
import java.util.List;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;

public interface WhiteListDao {

	List<IpV4Address> loadIpV4List(int from, int count);

	List<IpV6Address> loadIpV6List(int from, int count);

	void saveIpV4(String address);

	void saveIpV6(String address);

	void saveIpV4List(Collection<String> list);

	void saveIpV6List(Collection<String> list);

	void deleteIpV4(String address);

	void deleteIpV6(String address);

}
