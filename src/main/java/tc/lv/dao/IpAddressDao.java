package tc.lv.dao;

import java.util.List;

import tc.lv.domain.IpAddress;
import tc.lv.domain.IpAddressImpl;

public interface IpAddressDao {

	IpAddressImpl findByAddress(String address,
			Class<? extends IpAddress> ipClass) throws InstantiationException,
			IllegalAccessException;

	List<? extends IpAddress> getBlackList(Class<? extends IpAddress> ipClass)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException;

	List<? extends IpAddress> getBlackList(int from, int count,
			Class<? extends IpAddress> ipClass) throws InstantiationException,
			IllegalAccessException;

	List<? extends IpAddress> getListBySource(int sourceId,
			Class<? extends IpAddress> ipClass) throws InstantiationException,
			IllegalAccessException;

	List<? extends IpAddress> getUnDefList(Class<? extends IpAddress> ipClass)
			throws InstantiationException, IllegalAccessException;

	List<? extends IpAddress> getWhiteList(Class<? extends IpAddress> ipClass)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException;

	List<? extends IpAddress> getWhiteList(int from, int count,
			Class<? extends IpAddress> ipClass) throws InstantiationException,
			IllegalAccessException;

	void removeFromBlackList(IpAddressImpl address,
			Class<? extends IpAddress> ipClass);

	void removeFromWhiteList(IpAddressImpl address,
			Class<? extends IpAddress> ipClass);

	void save(IpAddressImpl address);

	void saveList(List<? extends IpAddressImpl> list, int sourceId)
			throws InstantiationException, IllegalAccessException;

	void updateWhiteList(Class<? extends IpAddressImpl> updateClass)
			throws InstantiationException, IllegalAccessException;

}
