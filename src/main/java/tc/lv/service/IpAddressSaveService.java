package tc.lv.service;

import tc.lv.domain.IpAddress;
import tc.lv.domain.Source;
import tc.lv.exceptions.IpAddressServiceException;

public interface IpAddressSaveService {

	public IpAddress saveIpAddress(String address, String status)
			throws IpAddressServiceException;
	public Source getSourceByStatus(String status)
			throws IpAddressServiceException;

}
