package tc.lv.dao;

import java.util.List;

import tc.lv.domain.IpV4Address;

public interface IpV4AddressDao {

	IpV4Address findByAddress(String address);

	List<IpV4Address> getBlackList();

	List<IpV4Address> getBlackList(int from, int count);

	List<IpV4Address> getListBySource(int sourceId);

	List<IpV4Address> getWhiteList();

	List<IpV4Address> getWhiteList(int from, int count);

	void removeFromBlackList(IpV4Address address);

	void removeFromWhiteList(IpV4Address address);

	void save(IpV4Address address);

}
