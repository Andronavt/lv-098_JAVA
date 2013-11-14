package tc.lv.dao;

import java.util.List;

import tc.lv.domain.IpV6Address;

public interface IpV6AddressDao {

	IpV6Address findByAddress(String address);

	List<IpV6Address> getBlackList();

	List<IpV6Address> getBlackList(int from, int count);

	List<IpV6Address> getListBySource(int sourceId);

	List<IpV6Address> getWhiteList();

	List<IpV6Address> getWhiteList(int from, int count);

	void removeFromBlackList(IpV6Address address);

	void removeFromWhiteList(IpV6Address address);

	void save(IpV6Address address);

}
