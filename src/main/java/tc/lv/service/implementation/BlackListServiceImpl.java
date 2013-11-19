package tc.lv.service.implementation;

import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tc.lv.dao.IpAddressDao;
import tc.lv.dao.SourceDao;
import tc.lv.dao.implementations.IpQueryEnum;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.Location;
import tc.lv.exceptions.BlackListServiceException;
import tc.lv.service.BlackListService;

@Service
public class BlackListServiceImpl implements BlackListService {
    private static final Logger LOGGER = Logger.getLogger(BlackListServiceImpl.class);
    private static final String ADMIN_BLACK_LIST = "Admin Blacklist";

    @Autowired
    private IpAddressDao ipAddressDao;

    @Autowired
    private SourceDao sourceDao;
    

    @Override
    public boolean deleteIpV4ByName(String address) throws BlackListServiceException {
        try {
            IpV4Address tempObject = ipAddressDao.findByAddress(address, IpQueryEnum.IP_V4);

            if (tempObject != null) {
                ipAddressDao.removeFromBlackList(tempObject, IpQueryEnum.IP_V4);
                return true;
            }
            return false;

        } catch (Exception e) {
            LOGGER.error(e);
            throw new BlackListServiceException("Could not delete ip version 4 from BlackList", e);
        }
    }

    @Override
    public boolean deleteIpV6ByName(String address) throws BlackListServiceException {
        try {
            IpV6Address tempObject = ipAddressDao.findByAddress(address, IpQueryEnum.IP_V6);

            if (tempObject != null) {
                ipAddressDao.removeFromBlackList(tempObject, IpQueryEnum.IP_V6);
                return true;
            }
            return false;

        } catch (Exception e) {
            LOGGER.error(e);
            throw new BlackListServiceException("Could not delete ip version 6 from BlackList", e);
        }
    }

    @Override
    public boolean saveIpV4ByName(String address) throws BlackListServiceException {
        try {
            IpV4Address tempIpV4 = ipAddressDao.findByAddress(address, IpQueryEnum.IP_V4);
            if ((tempIpV4 == null) || (tempIpV4.getWhiteList() != false)) {

                if (tempIpV4 == null) {
                    tempIpV4 = new IpV4Address(address, new Date(), new Location(
                            geo.findCountryByIpAddress(address), geo.findCountryCodeByIpAddress(address),
                            geo.findCityByIpAddress(address)));
                    tempIpV4.getSourceSet().add(sourceDao.findByName(ADMIN_BLACK_LIST));
                    tempIpV4.setWhiteList(false);
                    ipAddressDao.save(tempIpV4);

                } else {
                    tempIpV4.getSourceSet().add(sourceDao.findByName(ADMIN_BLACK_LIST));
                    tempIpV4.setWhiteList(false);
                    ipAddressDao.save(tempIpV4);
                }
                return true;
            }
            return false;

        } catch (Exception e) {
            LOGGER.error(e);
            throw new BlackListServiceException("Could not save ip version 4", e);
        }

    }

    @Override
    public boolean saveIpV6ByName(String address) throws BlackListServiceException {
       
        try {
            IpV6Address tempIpV6 = ipAddressDao.findByAddress(address, IpQueryEnum.IP_V6);
            if ((tempIpV6 == null) || (tempIpV6.getWhiteList() != false)) {

                if (tempIpV6 == null) {
                    tempIpV6 = new IpV6Address(address, new Date(), new Location(
                            geo.findCountryByIpAddress(address), geo.findCountryCodeByIpAddress(address),
                            geo.findCityByIpAddress(address)));
                    tempIpV6.getSourceSet().add(sourceDao.findByName(ADMIN_BLACK_LIST));
                    tempIpV6.setWhiteList(false);
                    ipAddressDao.save(tempIpV6);

                } else {
                    tempIpV6.getSourceSet().add(sourceDao.findByName(ADMIN_BLACK_LIST));
                    tempIpV6.setWhiteList(false);
                    ipAddressDao.save(tempIpV6);
                }
                return true;
            }
            return false;

        } catch (Exception e) {
            LOGGER.error(e);
            throw new BlackListServiceException("Entity manager Exception", e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<IpV4Address> loadIpV4List() throws BlackListServiceException {
        try {
            return (Collection<IpV4Address>) ipAddressDao.findBlackList(IpQueryEnum.IP_V4);

        } catch (Exception e) {
            LOGGER.error(e);
            throw new BlackListServiceException("Could not load list of ip version 4", e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<IpV6Address> loadIpV6List() throws BlackListServiceException {
        try {
            return (Collection<IpV6Address>) ipAddressDao.findBlackList(IpQueryEnum.IP_V6);

        } catch (Exception e) {
            LOGGER.error(e);
            throw new BlackListServiceException("Could not load list of ip version 6", e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<IpV4Address> loadIpV4ListByRange(int from, int count) throws BlackListServiceException {
        try {
            return (Collection<IpV4Address>) ipAddressDao.findBlackList(from, count, IpQueryEnum.IP_V4);

        } catch (Exception e) {
            LOGGER.error(e);
            throw new BlackListServiceException("Could not load list of ip version 4 by range", e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Collection<IpV6Address> loadIpV6ListByRange(int from, int count) throws BlackListServiceException {
        try {
            return (Collection<IpV6Address>) ipAddressDao.findBlackList(from, count, IpQueryEnum.IP_V6);

        } catch (Exception e) {
            LOGGER.error(e);
            throw new BlackListServiceException("Could not load list of ip version 6 by range", e);
        }
    }
}
