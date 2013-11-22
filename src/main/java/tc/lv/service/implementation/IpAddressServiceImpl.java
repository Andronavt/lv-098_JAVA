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
import tc.lv.exceptions.GeoIpException;
import tc.lv.exceptions.IpAddressServiceException;
import tc.lv.service.IpAddressService;
import tc.lv.utils.GeoIpUtil;
import tc.lv.utils.IpValidator;
import tc.lv.utils.IpVersionUtil;

@Service
public class IpAddressServiceImpl implements IpAddressService {

	private static final Logger LOGGER = Logger
			.getLogger(IpAddressServiceImpl.class);
	private static final String ADMIN_WHITE_LIST = "Admin WhiteList";
	private static final String ADMIN_BLACK_LIST = "Admin BlackList";

	@Autowired
	private IpAddressDao ipAddressDao;

	@Autowired
	private SourceDao sourceDao;

	GeoIpUtil geoIpUtil = new GeoIpUtil();

	@Transactional
	@Override
	public boolean saveIpByStatus(String address, int status)
			throws IpAddressServiceException {
		try {
			geoIpUtil.init();
			IpAddress tempIp = ipAddressDao.findByAddress(address,
					IpAddress.class);
			if (IpVersionUtil.makeStatus(status)) {
				tempIp = saveIpByAddress(tempIp, address, ADMIN_WHITE_LIST);
				tempIp.setStatus(IpVersionUtil.makeStatus(status));
				ipAddressDao.save(tempIp);
				return true;
			} else {
				tempIp = saveIpByAddress(tempIp, address, ADMIN_BLACK_LIST);
				tempIp.setStatus(IpVersionUtil.makeStatus(status));
				ipAddressDao.save(tempIp);
				return true;
			}
		} catch (Exception e) {
			LOGGER.error(e);
			throw new IpAddressServiceException("Could not save IP to List", e);
		}
	}

	@Transactional
	@Override
	public IpAddress saveIpByAddress(IpAddress tempIp, String address,
			String listType) throws IpAddressServiceException {
		try {
			if ((tempIp == null) || tempIp.getStatus()) {
				if (tempIp == null && IpValidator.isIpV4(address)) {

					tempIp = new IpV4Address(address, new Date(),
							geoIpUtil.findLocationByIpAddress(address));

					tempIp.getSourceSet().add(sourceDao.findByName(listType));
				} else if (tempIp == null && IpValidator.isIpV6(address)) {
					tempIp = new IpV6Address(address, new Date(),
							geoIpUtil.findLocationByIpAddress(address));
					tempIp.getSourceSet().add(sourceDao.findByName(listType));
				} else {
					tempIp.getSourceSet().add(sourceDao.findByName(listType));
				}
				geoIpUtil.close();
			}

		} catch (GeoIpException e) {
			LOGGER.error(e);
			throw new IpAddressServiceException("Could not save IP by Address",
					e);
		}
		return tempIp;
	}

	@Transactional
	@Override
	public boolean deleteIpByAddress(String address)
			throws IpAddressServiceException {
		try {
			IpAddress tempIp = null;
			if (IpValidator.isIpV4(address)) {
				tempIp = ipAddressDao.findByAddress(address, IpV4Address.class);
			} else {
				tempIp = ipAddressDao.findByAddress(address, IpV6Address.class);
			}
			if (tempIp != null) {
				ipAddressDao.deleteIp(tempIp);
				return true;
			}
			return false;

		} catch (Exception e) {
			LOGGER.error(e);
			throw new IpAddressServiceException(
					"Could not delete ip from list", e);
		}
	}

}
