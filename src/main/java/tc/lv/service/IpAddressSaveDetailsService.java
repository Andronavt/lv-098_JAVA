package tc.lv.service;

import tc.lv.domain.IpAddress;
import tc.lv.domain.Source;
import tc.lv.exceptions.IpAddressServiceException;

public interface IpAddressSaveDetailsService {

	public IpAddress getDetails(String address, String status)
			throws IpAddressServiceException;
    public Source getSourceByStatus(String status) throws IpAddressServiceException;
}
