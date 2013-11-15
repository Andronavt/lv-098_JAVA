package tc.lv.service;

import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpV4AddressDao;
import tc.lv.dao.IpV6AddressDao;
import tc.lv.dao.SourceDao;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.exceptions.WhiteListServiceException;

@Service
public class WhiteListServiceImpl implements WhiteListService {

    private static final Logger LOGGER = Logger.getLogger(WhiteListServiceImpl.class);
    private static final String ADMIN_WHITE_LIST = "Admin Whitelist";

    @Autowired
    private IpV4AddressDao ipV4AddressDao;

    @Autowired
    private IpV6AddressDao ipV6AddressDao;

    @Autowired
    private SourceDao sourceDao;

    @Transactional
    @Override
    public boolean deleteIpV4(String address) throws WhiteListServiceException {
        try {
            IpV4Address tempIpV4 = ipV4AddressDao.findByAddress(address);

            if (tempIpV4 != null) {
                ipV4AddressDao.removeFromWhiteList(tempIpV4);
                return true;
            }
            return false;

        } catch (Exception e) {
            LOGGER.error(e);
            throw new WhiteListServiceException("Could not delete IPv4 from White List", e);
        }
    }

    @Transactional
    @Override
    public boolean deleteIpV6(String address) throws WhiteListServiceException {
        try {
            IpV6Address tempIpV6 = ipV6AddressDao.findByAddress(address);

            if (tempIpV6 != null) {
                ipV6AddressDao.removeFromWhiteList(tempIpV6);
                return true;
            }
            return false;

        } catch (Exception e) {
            LOGGER.error(e);
            throw new WhiteListServiceException("Could not delete IPv6 from White List", e);
        }
    }

    @Transactional
    @Override
    public boolean saveIpV4(String address) throws WhiteListServiceException {
        try {
            IpV4Address tempIpV4 = ipV4AddressDao.findByAddress(address);
            if ((tempIpV4 == null) || (tempIpV4.getWhiteList() != true)) {

                if (tempIpV4 == null) {
                    tempIpV4 = new IpV4Address(address, new Date());
                    tempIpV4.getSourceSet().add(sourceDao.findByName(ADMIN_WHITE_LIST));
                    tempIpV4.setWhiteList(true);
                    ipV4AddressDao.save(tempIpV4);

                } else {
                    tempIpV4.getSourceSet().add(sourceDao.findByName(ADMIN_WHITE_LIST));
                    tempIpV4.setWhiteList(true);
                    ipV4AddressDao.save(tempIpV4);
                }
                return true;
            }
            return false;

        } catch (Exception e) {
            LOGGER.error(e);
            throw new WhiteListServiceException("Could not save IPv4 to White List", e);
        }
    }

    @Transactional
    @Override
    public boolean saveIpV6(String address) throws WhiteListServiceException {
        try {
            IpV6Address tempIpV6 = ipV6AddressDao.findByAddress(address);
            if ((tempIpV6 == null) || (tempIpV6.getWhiteList() != true)) {

                if (tempIpV6 == null) {
                    tempIpV6 = new IpV6Address(address, new Date());
                    tempIpV6.getSourceSet().add(sourceDao.findByName(ADMIN_WHITE_LIST));
                    tempIpV6.setWhiteList(true);
                    ipV6AddressDao.save(tempIpV6);

                } else {
                    tempIpV6.getSourceSet().add(sourceDao.findByName(ADMIN_WHITE_LIST));
                    tempIpV6.setWhiteList(true);
                    ipV6AddressDao.save(tempIpV6);
                }
                return true;
            }
            return false;

        } catch (Exception e) {
            LOGGER.error(e);
            throw new WhiteListServiceException("Could not save IPv6 to White List", e);
        }
    }

    @Transactional
    @Override
    public Collection<IpV4Address> loadIpV4List() throws WhiteListServiceException {
        try {
            return ipV4AddressDao.getWhiteList();

        } catch (Exception e) {
            LOGGER.error(e);
            throw new WhiteListServiceException("Could not load IPv4 White List", e);
        }
    }

    @Transactional
    @Override
    public Collection<IpV6Address> loadIpV6List() throws WhiteListServiceException {
        try {
            return ipV6AddressDao.getWhiteList();

        } catch (Exception e) {
            LOGGER.error(e);
            throw new WhiteListServiceException("Could not load IPv6 White List", e);
        }
    }

    @Transactional
    @Override
    public Collection<IpV4Address> loadIpV4ListByRange(int from, int count) throws WhiteListServiceException {
        try {
            return ipV4AddressDao.getWhiteList(from, count);

        } catch (Exception e) {
            LOGGER.error(e);
            throw new WhiteListServiceException("Could not load IPv4 White List by range", e);
        }
    }

    @Transactional
    @Override
    public Collection<IpV6Address> loadIpV6ListByRange(int from, int count) throws WhiteListServiceException {
        try {
            return ipV6AddressDao.getWhiteList(from, count);

        } catch (Exception e) {
            LOGGER.error(e);
            throw new WhiteListServiceException("Could not load IPv6 White List by range", e);
        }
    }

}
