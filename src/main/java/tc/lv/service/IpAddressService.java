package tc.lv.service;

import java.util.List;
import java.util.Map;

import tc.lv.domain.IpAddress;
import tc.lv.exceptions.IpAddressServiceException;

public interface IpAddressService {

    public boolean saveIpByStatus(String address, String status)
	    throws IpAddressServiceException;

    public boolean deleteIpByAddress(String address)
	    throws IpAddressServiceException;

    void saveList(List<? extends IpAddress> list, int sourceId,
	    Class<? extends IpAddress> ipType, Map<String, IpAddress> map)
	    throws IpAddressServiceException;

    void updateStatusList(Map<String, IpAddress> map)
	    throws IpAddressServiceException;

    public void createIpMap();

}
