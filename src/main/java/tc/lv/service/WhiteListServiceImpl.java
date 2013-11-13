package tc.lv.service;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpV4AddressDao;
import tc.lv.dao.IpV6AddressDao;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.exceptions.WhiteListServiceException;

@Service
public class WhiteListServiceImpl implements WhiteListService {
	private static final Logger logger = Logger.getLogger("errorLog");
	@Autowired
	private IpV4AddressDao ipV4AddressDao;

	@Autowired
	private IpV6AddressDao ipV6AddressDao;

	@Transactional
	public void deleteIpV4(String address) throws WhiteListServiceException {
		try {
			IpV4Address tempIpV4 = ipV4AddressDao.findByAddress(address);
			if (tempIpV4 != null)
				ipV4AddressDao.removeFromWhiteList(tempIpV4);
			else {
				throw new WhiteListServiceException(
						"There is no such ip in database");
			}
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

	@Transactional
	public void deleteIpV6(String address) throws WhiteListServiceException {
		try {
			IpV6Address tempIpV6 = ipV6AddressDao.findByAddress(address);
			if (tempIpV6 != null)
				ipV6AddressDao.removeFromWhiteList(tempIpV6);
			else {
				throw new WhiteListServiceException(
						"There is no such ip in database");
			}
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}
	@Transactional
	public void saveIpV4(String address) throws WhiteListServiceException {
		try {
			IpV4Address tempIpV4 = ipV4AddressDao.findByAddress(address);
			if (tempIpV4 == null)
				ipV4AddressDao.save(tempIpV4);
			else {
				throw new WhiteListServiceException(
						"There is such ip in WhiteList");
			}
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

	@Transactional
	public void saveIpV6(String address) throws WhiteListServiceException {
		try {
			IpV6Address tempIpV6 = ipV6AddressDao.findByAddress(address);
			if (tempIpV6 == null)
				ipV6AddressDao.save(tempIpV6);
			else {
				throw new WhiteListServiceException(
						"There is such ip in WhiteList");
			}
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

	@Transactional
	public Collection<IpV4Address> loadIpV4List()
			throws WhiteListServiceException {
		try {
			return ipV4AddressDao.getWhiteList();
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

	@Transactional
	public Collection<IpV6Address> loadIpV6List()
			throws WhiteListServiceException {
		try {
			return ipV6AddressDao.getWhiteList();
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

	@Transactional
	public Collection<IpV4Address> loadIpV4ListByRange(int from, int count)
			throws WhiteListServiceException {
		try {
			return ipV4AddressDao.getWhiteList(from, count);
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

	@Transactional
	public Collection<IpV6Address> loadIpV6ListByRange(int from, int count)
			throws WhiteListServiceException {
		try {
			return ipV6AddressDao.getWhiteList(from, count);
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

}
