package tc.lv.service;

import tc.lv.domain.IpAddress;
import tc.lv.exceptions.IpAddressServiceException;

public interface IpAddressService {

    public boolean saveIpByStatus(String address, String status) throws IpAddressServiceException;

    public IpAddress saveIpByAddress(IpAddress tempIp, String address, String listType)
            throws IpAddressServiceException;

    public boolean deleteIpByAddress(String address) throws IpAddressServiceException;

}
