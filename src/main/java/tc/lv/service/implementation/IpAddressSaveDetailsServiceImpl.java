package tc.lv.service.implementation;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpAddressDao;
import tc.lv.dao.SourceDao;
import tc.lv.domain.IpAddress;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.domain.Source;
import tc.lv.exceptions.GeoIpException;
import tc.lv.exceptions.IpAddressServiceException;
import tc.lv.service.IpAddressSaveDetailsService;
import tc.lv.utils.GeoIpUtil;
import tc.lv.utils.IpValidator;
import tc.lv.utils.IpVersionUtil;

@Service
public class IpAddressSaveDetailsServiceImpl implements
	IpAddressSaveDetailsService {

    private static final Logger LOGGER = Logger
	    .getLogger(IpAddressSaveDetailsServiceImpl.class);;
    @Autowired
    private SourceDao sourceDao;

    @Autowired
    private IpAddressDao ipDao;

    private GeoIpUtil geoIpUtil;

    @Override
    @Transactional
    public IpAddress getDetails(String address, String status)
	    throws IpAddressServiceException {
	IpAddress tempIp = null;
	try {
	    geoIpUtil = new GeoIpUtil();
	    if (IpValidator.isIpV4(address)) {
		tempIp = new IpV4Address(address, new Date());
	    } else {
		tempIp = new IpV6Address(address, new Date());
	    }
	    geoIpUtil.addCityToIpAddress(tempIp);
	    ipDao.addSource(tempIp, getSourceByStatus(status));
	    return tempIp;
	} catch (GeoIpException e) {
	    LOGGER.error(e);
	    throw new IpAddressServiceException("Could not save IP by Address",
		    e);
	} finally {
	    geoIpUtil.dispose();
	}
    }

    @Override
    @Transactional
    public Source getSourceByStatus(String status)
	    throws IpAddressServiceException {
	return (status.equals(IpVersionUtil.WHITE_LIST) ? sourceDao
		.findByName(Source.ADMIN_WHITE_LIST) : sourceDao
		.findByName(Source.ADMIN_BLACK_LIST));
    }

}
