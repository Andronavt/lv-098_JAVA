package tc.lv.service;

import tc.lv.exceptions.IpAddressServiceException;

public interface IpAddressService {

    public boolean saveIpByStatus(String address, String status) throws IpAddressServiceException;

    public boolean deleteIpByAddress(String address) throws IpAddressServiceException;

}
