package tc.lv.service;

import java.util.Collection;

import tc.lv.domain.IpAddress;
import tc.lv.exceptions.IpStatusListServiceException;

public interface IpStatusListService {

    public Collection<IpAddress> findIpList(int from, int count, String ipType, String status)
            throws IpStatusListServiceException;

}
