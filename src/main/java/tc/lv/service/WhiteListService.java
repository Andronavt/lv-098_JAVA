package tc.lv.service;

import java.util.Collection;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.exceptions.WhiteListServiceException;

public interface WhiteListService {

	public void deleteIpV4(String address) throws WhiteListServiceException;

	public void deleteIpV6(String address) throws WhiteListServiceException;

	public void saveIpV4(String address) throws WhiteListServiceException;

	public void saveIpV6(String address) throws WhiteListServiceException;

	public Collection<IpV4Address> loadIpV4List()
			throws WhiteListServiceException;

	public Collection<IpV6Address> loadIpV6List()
			throws WhiteListServiceException;

	public Collection<IpV4Address> loadIpV4ListByRange(int from, int count)
			throws WhiteListServiceException;

	public Collection<IpV6Address> loadIpV6ListByRange(int from, int count)
			throws WhiteListServiceException;
}
