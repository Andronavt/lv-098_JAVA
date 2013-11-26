package tc.lv.service;

import java.util.Collection;

import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.exceptions.BlackListServiceException;

public interface BlackListService {

    public boolean deleteIpV4ByName(String address) throws BlackListServiceException;

    public boolean deleteIpV6ByName(String address) throws BlackListServiceException;

    public boolean saveIpV4ByName(String address) throws BlackListServiceException;

    public boolean saveIpV6ByName(String address) throws BlackListServiceException;

    public Collection<IpV4Address> loadIpV4List() throws BlackListServiceException;

    public Collection<IpV6Address> loadIpV6List() throws BlackListServiceException;

    public Collection<IpV4Address> loadIpV4ListByRange(int from, int count) throws BlackListServiceException;

    public Collection<IpV6Address> loadIpV6ListByRange(int from, int count) throws BlackListServiceException;
}
