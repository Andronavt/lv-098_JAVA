package tc.lv.service;

import java.util.Collection;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.exceptions.BlackListServiceException;

public interface BlackListService {

	public void deleteIpV4(String address) throws BlackListServiceException;

	public void deleteIpV6(String address) throws BlackListServiceException;

	public void saveIpV4(String address) throws BlackListServiceException;

	public void saveIpV6(String address) throws BlackListServiceException;

	public Collection<IpV4Address> loadIpV4List()
			throws BlackListServiceException;

	public Collection<IpV6Address> loadIpV6List()
			throws BlackListServiceException;

	public Collection<IpV4Address> loadIpV4ListByRange(int from, int count)
			throws BlackListServiceException;

	public Collection<IpV6Address> loadIpV6ListByRange(int from, int count)
			throws BlackListServiceException;
}
