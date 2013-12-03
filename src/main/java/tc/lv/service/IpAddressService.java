package tc.lv.service;

import java.util.List;
import java.util.Map;

import tc.lv.domain.IpAddress;
import tc.lv.exceptions.DBException;
import tc.lv.exceptions.GeoIpException;
import tc.lv.exceptions.IpAddressServiceException;
import tc.lv.exceptions.SourceDownloaderServiceException;

public interface IpAddressService {

    public boolean saveIpByStatus(String address, String status) throws IpAddressServiceException;

    public boolean deleteIpByAddress(String address) throws IpAddressServiceException;

    void saveList(List<? extends IpAddress> list, int sourceId, Class<? extends IpAddress> ipType,
            Map<String, IpAddress> map) throws DBException, GeoIpException;

    void updateStatusList(Map<String, IpAddress> map) throws DBException, SourceDownloaderServiceException;

}
