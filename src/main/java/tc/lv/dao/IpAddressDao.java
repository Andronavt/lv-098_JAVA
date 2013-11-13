package tc.lv.dao;

import java.util.List;

import tc.lv.domain.IpAddress;

public interface IpAddressDao {

	List<IpAddress> getListBySource(int sourceId,
			Class<? extends IpAddress> userClass);

	List<IpAddress> getWhiteList(int from, int count,
			Class<? extends IpAddress> userClass);

	List<IpAddress> getWhiteList(Class<? extends IpAddress> userClass);

	IpAddress findByAddress(String address);

	void save(IpAddress address);

	boolean removeFromWhiteList(IpAddress address);

	List<IpAddress> getBlackList(int from, int count);

	List<IpAddress> getBlackList();

	boolean removeFromBlackList(IpAddress address);

}
