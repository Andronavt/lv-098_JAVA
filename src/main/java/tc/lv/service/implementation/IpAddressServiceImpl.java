package tc.lv.service.implementation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpAddressDao;
import tc.lv.dao.SourceDao;
import tc.lv.domain.IpAddress;
import tc.lv.exceptions.IpAddressServiceException;
import tc.lv.service.IpAddressSaveDetailsService;
import tc.lv.service.IpAddressService;
import tc.lv.utils.IpVersionUtil;

@Service
public class IpAddressServiceImpl implements IpAddressService {

    private static final Logger LOGGER = Logger.getLogger(IpAddressServiceImpl.class);

    @Autowired
    private IpAddressDao ipAddressDao;

    @Autowired
    private SourceDao sourceDao;

    @Autowired
    private IpAddressSaveDetailsService ipAddressSaveDetailsService;

    @Transactional
    @Override
    public boolean saveIpByStatus(String address, String status) throws IpAddressServiceException {
        try {
            IpAddress tempIp = ipAddressDao.findByAddress(address, IpAddress.class);
            if (tempIp != null) {
                tempIp.getSourceSet().add(ipAddressSaveDetailsService.getSourceByStatus(status));
            } else {
                tempIp = ipAddressSaveDetailsService.getDetails(address, status);
            }
            tempIp.setStatus(IpVersionUtil.isWhiteIpAddress(status));
            ipAddressDao.save(tempIp);
            return true;
        } catch (Exception e) {
            LOGGER.error(e);
            throw new IpAddressServiceException("Could not save IP to List", e);
        }
    }

    @Transactional
    @Override
    public boolean deleteIpByAddress(String address) throws IpAddressServiceException {
        try {
            IpAddress tempIp = ipAddressDao.findByAddress(address, IpAddress.class);
            if (tempIp != null) {
                ipAddressDao.deleteIp(tempIp);
                return true;
            }
        } catch (Exception e) {
            LOGGER.error(e);
            throw new IpAddressServiceException("Could not delete ip from list", e);
        }
        return false;
    }
}
