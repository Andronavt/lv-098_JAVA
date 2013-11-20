package tc.lv.service.implementation;

import java.util.Collection;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpAddressDao;
import tc.lv.dao.SourceDao;
import tc.lv.dao.implementations.IpQueryEnum;
import tc.lv.domain.City;
import tc.lv.domain.Country;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.exceptions.WhiteListServiceException;
import tc.lv.service.WhiteListService;

@Service
public class WhiteListServiceImpl implements WhiteListService {

    private static final Logger LOGGER = Logger.getLogger(WhiteListServiceImpl.class);
    private static final String ADMIN_WHITE_LIST = "Admin WhiteList";

    @Autowired
    private IpAddressDao ipAddressDao;

    @Autowired
    private SourceDao sourceDao;

    @Transactional
    @Override
    public boolean deleteIpV4ByName(String address) throws WhiteListServiceException {
        try {
            IpV4Address tempIpV4 = ipAddressDao.findByAddress(address, IpQueryEnum.IP_V4);

            if (tempIpV4 != null) {
                ipAddressDao.deleteIp(tempIpV4);
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
    public boolean deleteIpV6ByName(String address) throws WhiteListServiceException {
        try {
            IpV6Address tempIpV6 = ipAddressDao.findByAddress(address, IpQueryEnum.IP_V6);

            if (tempIpV6 != null) {
                ipAddressDao.deleteIp(tempIpV6);
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
    public boolean saveIpV4ByName(String address) throws WhiteListServiceException {
        GeoIpServiceImpl geo = new GeoIpServiceImpl();
        try {
            IpV4Address tempIpV4 = ipAddressDao.findByAddress(address, IpQueryEnum.IP_V4);
            if ((tempIpV4 == null) || (tempIpV4.getWhiteList() != true)) {

                if (tempIpV4 == null) {
                    tempIpV4 = new IpV4Address(address, new Date(), new City(geo.findCityByIpAddress(address),
                            new Country(geo.findCountryByIpAddress(address),
                                    geo.findCountryCodeByIpAddress(address))));
                    tempIpV4.getSourceSet().add(sourceDao.findByName(ADMIN_WHITE_LIST));
                    tempIpV4.setWhiteList(true);
                    ipAddressDao.save(tempIpV4);

                } else {
                    tempIpV4.getSourceSet().add(sourceDao.findByName(ADMIN_WHITE_LIST));
                    tempIpV4.setWhiteList(true);
                    ipAddressDao.save(tempIpV4);
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
    public boolean saveIpV6ByName(String address) throws WhiteListServiceException {
        try {
            IpV6Address tempIpV6 = ipAddressDao.findByAddress(address, IpQueryEnum.IP_V6);
            if ((tempIpV6 == null) || (tempIpV6.getWhiteList() != true)) {

                if (tempIpV6 == null) {
                    tempIpV6 = new IpV6Address(address, new Date());
                    tempIpV6.getSourceSet().add(sourceDao.findByName(ADMIN_WHITE_LIST));
                    tempIpV6.setWhiteList(true);
                    ipAddressDao.save(tempIpV6);

                } else {
                    tempIpV6.getSourceSet().add(sourceDao.findByName(ADMIN_WHITE_LIST));
                    tempIpV6.setWhiteList(true);
                    ipAddressDao.save(tempIpV6);
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
    @SuppressWarnings("unchecked")
    public Collection<IpV4Address> loadIpV4List() throws WhiteListServiceException {
        try {
            return (Collection<IpV4Address>) ipAddressDao.findWhiteList(IpQueryEnum.IP_V4);

        } catch (Exception e) {
            LOGGER.error(e);
            throw new WhiteListServiceException("Could not load IPv4 White List", e);
        }
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public Collection<IpV6Address> loadIpV6List() throws WhiteListServiceException {
        try {
            return (Collection<IpV6Address>) ipAddressDao.findWhiteList(IpQueryEnum.IP_V6);

        } catch (Exception e) {
            LOGGER.error(e);
            throw new WhiteListServiceException("Could not load IPv6 White List", e);
        }
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public Collection<IpV4Address> loadIpV4ListByRange(int from, int count) throws WhiteListServiceException {
        try {
            return (Collection<IpV4Address>) ipAddressDao.findWhiteList(from, count, IpQueryEnum.IP_V4);

        } catch (Exception e) {
            LOGGER.error(e);
            throw new WhiteListServiceException("Could not load IPv4 White List by range", e);
        }
    }

    @Transactional
    @Override
    @SuppressWarnings("unchecked")
    public Collection<IpV6Address> loadIpV6ListByRange(int from, int count) throws WhiteListServiceException {
        try {
            return (Collection<IpV6Address>) ipAddressDao.findWhiteList(from, count, IpQueryEnum.IP_V6);

        } catch (Exception e) {
            LOGGER.error(e);
            throw new WhiteListServiceException("Could not load IPv6 White List by range", e);
        }
    }

}
