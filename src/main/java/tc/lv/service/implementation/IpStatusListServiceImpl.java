package tc.lv.service.implementation;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpAddressDao;
import tc.lv.domain.IpAddress;
import tc.lv.exceptions.IpStatusListServiceException;
import tc.lv.service.IpStatusListService;
import tc.lv.utils.IpVersionUtil;

@Service
public class IpStatusListServiceImpl implements IpStatusListService {

    private static final Logger LOGGER = Logger.getLogger(IpStatusListServiceImpl.class);

    @Autowired
    private IpAddressDao ipAddressDao;

    @Transactional
    @Override
    public Collection<IpAddress> findIpList(int from, int count, String ipType, String status)
            throws IpStatusListServiceException {
        try {
            return ipAddressDao.findStatusList(IpVersionUtil.isWhiteIpAddress(status), from, count,
                    IpVersionUtil.ipVersion(ipType));
        } catch (Exception e) {
            LOGGER.error(e);
            throw new IpStatusListServiceException("Could not load IP List by range", e);
        }
    }

}
