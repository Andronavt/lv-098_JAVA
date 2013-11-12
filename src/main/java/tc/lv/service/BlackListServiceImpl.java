package tc.lv.service;

import java.util.Collection;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import tc.lv.dao.BlackListDao;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.exceptions.BlackListServiceException;
import tc.lv.exceptions.DBException;
import tc.lv.exceptions.DBIllegalArgumentException;
import tc.lv.exceptions.DBIllegalStateException;
import tc.lv.exceptions.DBPersistanceException;

public class BlackListServiceImpl implements BlackListService {
	private static final Logger logger = Logger.getLogger("errorLog");
	@Autowired
	private BlackListDao blackListDao;

	@Override
	public void deleteIpV4(String address) throws BlackListServiceException {
		try {
			IpV4Address tempObject = new IpV4Address(address);
			blackListDao.deleteIpV4(tempObject);
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}

	}

	@Override
	public void deleteIpV6(String address) throws BlackListServiceException {
		try {
			IpV6Address tempObject = new IpV6Address(address);
			blackListDao.deleteIpV6(tempObject);
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}

	}

	@Override
	public void saveIpV4(String address) throws BlackListServiceException {
		try {
			IpV4Address tempObject = new IpV4Address(address);
			blackListDao.saveIpV4(tempObject);
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}

	}

	@Override
	public void saveIpV6(String address) throws BlackListServiceException {
		try {
			IpV6Address tempObject = new IpV6Address(address);
			blackListDao.saveIpV6(tempObject);
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}

	}

	@Override
	public Collection<IpV4Address> loadIpV4List()
			throws BlackListServiceException {
		try {
			return blackListDao.loadAllIpV4List();
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}
	}

	@Override
	public Collection<IpV6Address> loadIpV6List()
			throws BlackListServiceException {
		try {
			return blackListDao.loadAllIpV6List();
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}
	}

	@Override
	public Collection<IpV4Address> loadIpV4ListByRange(int from, int count)
			throws BlackListServiceException {
		try {
			return blackListDao.loadIpV4ListByRange(from, count);
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}
	}

	@Override
	public Collection<IpV6Address> loadIpV6ListByRange(int from, int count)
			throws BlackListServiceException {
		try {
			return blackListDao.loadIpV6ListByRange(from, count);
		} catch (Exception e) {
			logger.error(e);
			throw new BlackListServiceException("Entity manager Exception", e);
		}
	}

}
