package tc.lv.service.implementation;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

@Service
public class IpAddressSaveDetailsServiceImpl implements IpAddressSaveDetailsService {

	private static final Logger LOGGER = Logger
			.getLogger(IpAddressSaveDetailsServiceImpl.class);

	@Autowired
	private SourceDao sourceDao;
	
	private GeoIpUtil geoIpUtil;

	private static final String ADMIN_WHITE_LIST = "Admin Whitelist";
	private static final String ADMIN_BLACK_LIST = "Admin Blacklist";

	@Transactional
	@Override
	public IpAddress getDetails(String address, String status)
			throws IpAddressServiceException {
		IpAddress tempIp = null;
		try {
			geoIpUtil = new GeoIpUtil();
			if (IpValidator.isIpV4(address)) {
				tempIp = new IpV4Address(address, new Date(), null);
			} else {
				tempIp = new IpV6Address(address, new Date(), null);
			}
			geoIpUtil.addCityToIpAddress(tempIp);
			tempIp.getSourceSet().add(getSourceByStatus(status));
			return tempIp;
		} catch (GeoIpException e) {
			LOGGER.error(e);
			throw new IpAddressServiceException("Could not save IP by Address",
					e);
		} finally {
			geoIpUtil.dispose();
		}
	}

	@Transactional
	@Override
	public Source getSourceByStatus(String status)
			throws IpAddressServiceException {
		return (status.equals("whiteList") ? sourceDao
				.findByName(ADMIN_WHITE_LIST) : sourceDao
				.findByName(ADMIN_BLACK_LIST));
	}

}
