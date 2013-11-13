package tc.lv.dao;

import java.util.List;

import tc.lv.domain.IpV6Address;

public interface IpV6AddressDao {

	List<IpV6Address> getListBySource(int sourceId);

	List<IpV6Address> getWhiteList(int from, int count);

	List<IpV6Address> getWhiteList();

	IpV6Address findByAddress(String address);

	void save(IpV6Address address);

	void removeFromWhiteList(IpV6Address address);

	List<IpV6Address> getBlackList(int from, int count);

	List<IpV6Address> getBlackList();

	void removeFromBlackList(IpV6Address address);

}
