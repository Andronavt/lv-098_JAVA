package tc.lv.service;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import tc.lv.dao.IpV4AddressDao;
import tc.lv.dao.IpV6AddressDao;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.exceptions.BlackListServiceException;

public class BlackListServiceImpl implements BlackListService {
	private static final Logger logger = Logger.getLogger("errorLog");
	@Autowired
	private IpV4AddressDao ipV4AddressDao;

	@Autowired
	private IpV6AddressDao ipV6AddressDao;

	@Override
	public void deleteIpV4(String address) throws BlackListServiceException {
		try {
			IpV4Address tempObject = new IpV4Address(address);
			ipV4AddressDao.removeFromBlackList(tempObject);
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}

	}

	@Override
	public void deleteIpV6(String address) throws BlackListServiceException {
		try {
			IpV6Address tempObject = new IpV6Address(address);
			ipV6AddressDao.removeFromBlackList(tempObject);
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}

	}

	@Override
	public void saveIpV4(String address) throws BlackListServiceException {
		try {
			IpV4Address tempObject = new IpV4Address(address);
			ipV4AddressDao.save(tempObject);
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}

	}

	@Override
	public void saveIpV6(String address) throws BlackListServiceException {
		try {
			IpV6Address tempObject = new IpV6Address(address);
			ipV6AddressDao.save(tempObject);
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}

	}

	@Override
	public Collection<IpV4Address> loadIpV4List()
			throws BlackListServiceException {
		try {
			return ipV4AddressDao.getBlackList();
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}
	}

	@Override
	public Collection<IpV6Address> loadIpV6List()
			throws BlackListServiceException {
		try {
			return ipV6AddressDao.getBlackList();
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}
	}

	@Override
	public Collection<IpV4Address> loadIpV4ListByRange(int from, int count)
			throws BlackListServiceException {
		try {
			return ipV4AddressDao.getBlackList(from, count);
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}
	}

	@Override
	public Collection<IpV6Address> loadIpV6ListByRange(int from, int count)
			throws BlackListServiceException {
		try {
			return ipV6AddressDao.getBlackList(from, count);
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}
	}

}
