package tc.lv.service;

import java.util.Collection;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.WhiteListDao;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.exceptions.DBException;
import tc.lv.exceptions.DBIllegalArgumentException;
import tc.lv.exceptions.DBIllegalStateException;
import tc.lv.exceptions.DBPersistanceException;
import tc.lv.exceptions.WhiteListServiceException;

@Service
public class WhiteListServiceImpl implements WhiteListService {
	private static final Logger logger = Logger.getLogger("errorLog");
	@Autowired
	private WhiteListDao whiteListDao;

	@Transactional
	public void deleteIpV4(String address) throws WhiteListServiceException {
		try {
			IpV4Address tempIpV4 = new IpV4Address(address);
			whiteListDao.deleteIpV4(tempIpV4);
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

	@Transactional
	public void deleteIpV6(String address) throws WhiteListServiceException {
		try {
			IpV6Address tempIpV6 = new IpV6Address(address);
			whiteListDao.deleteIpV6(tempIpV6);
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

	@Transactional
	public void saveIpV4(String address) throws WhiteListServiceException {
		try {
			IpV4Address tempIpV4 = new IpV4Address(address);
			whiteListDao.saveIpV4(tempIpV4);
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

	@Transactional
	public void saveIpV6(String address) throws WhiteListServiceException {
		try {
			IpV6Address tempIpV6 = new IpV6Address(address);
			whiteListDao.saveIpV6(tempIpV6);
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

	@Transactional
	public Collection<IpV4Address> loadIpV4List()
			throws WhiteListServiceException {
		try {
			return whiteListDao.loadAllIpV4List();
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

	@Transactional
	public Collection<IpV6Address> loadIpV6List()
			throws WhiteListServiceException {
		try {
			return whiteListDao.loadAllIpV6List();
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

	@Transactional
	public Collection<IpV4Address> loadIpV4ListByRange(int from, int count)
			throws WhiteListServiceException {
		try {
			return whiteListDao.loadIpV4ListByRange(from, count);
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

	@Transactional
	public Collection<IpV6Address> loadIpV6ListByRange(int from, int count)
			throws WhiteListServiceException {
		try {
			return whiteListDao.loadIpV6ListByRange(from, count);
		} catch (Exception e) {
			logger.error(e);
			throw new WhiteListServiceException("Entity manager Exception", e);
		}
	}

}
