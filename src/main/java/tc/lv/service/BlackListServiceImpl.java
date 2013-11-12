package tc.lv.service;

import java.util.Collection;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import tc.lv.dao.BlackListDao;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;
import tc.lv.exceptions.DBException;
import tc.lv.exceptions.DBIllegalArgumentException;
import tc.lv.exceptions.DBIllegalStateException;
import tc.lv.exceptions.DBPersistanceException;

public class BlackListServiceImpl implements BlackListService {
    private static final Logger logger = Logger.getLogger("errorLog");
    @Autowired
    private BlackListDao blackListDao;

    @Override
    public void deleteIpV4(String address) throws DBPersistanceException,
	    DBIllegalArgumentException, DBIllegalStateException, DBException {
	try {
	    blackListDao.deleteIpV4(address);
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e) {
	    logger.error(e);
	    throw new DBIllegalArgumentException(
		    "method deleteIpV4 has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e) {
	    logger.error(e);
	    throw new DBIllegalStateException(
		    "method deleteIpV4 has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e) {
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}

    }

    @Override
    public void deleteIpV6(String address) throws DBPersistanceException,
	    DBIllegalArgumentException, DBIllegalStateException, DBException {
	try {
	    blackListDao.deleteIpV6(address);
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e) {
	    logger.error(e);
	    throw new DBIllegalArgumentException(
		    "method deleteIpV6 has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e) {
	    logger.error(e);
	    throw new DBIllegalStateException(
		    "method deleteIpV6 has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e) {
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}

    }

    @Override
    public void saveIpV4(String address) throws DBPersistanceException,
	    DBIllegalArgumentException, DBIllegalStateException, DBException {
	try {
	    blackListDao.saveIpV4(address);
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e) {
	    logger.error(e);
	    throw new DBIllegalArgumentException(
		    "method saveIpV4 has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e) {
	    logger.error(e);
	    throw new DBIllegalStateException(
		    "method saveIpV4 has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e) {
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}

    }

    @Override
    public void saveIpV6(String address) throws DBPersistanceException,
	    DBIllegalArgumentException, DBIllegalStateException, DBException {
	try {
	    blackListDao.saveIpV6(address);
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e) {
	    logger.error(e);
	    throw new DBIllegalArgumentException(
		    "method saveIpV6 has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e) {
	    logger.error(e);
	    throw new DBIllegalStateException(
		    "method saveIpV6 has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e) {
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}

    }

    @Override
    public Collection<IpV4Address> loadIpV4List()
	    throws DBPersistanceException, DBIllegalArgumentException,
	    DBIllegalStateException, DBException {
	try {
	    return blackListDao.loadAllIpV4List();
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e) {
	    logger.error(e);
	    throw new DBIllegalArgumentException(
		    "method loadIpV4List has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e) {
	    logger.error(e);
	    throw new DBIllegalStateException(
		    "method loadIpV4List has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e) {
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}
    }

    @Override
    public Collection<IpV6Address> loadIpV6List()
	    throws DBPersistanceException, DBIllegalArgumentException,
	    DBIllegalStateException, DBException {
	try {
	    return blackListDao.loadAllIpV6List();
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e) {
	    logger.error(e);
	    throw new DBIllegalArgumentException(
		    "method loadIpV6List has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e) {
	    logger.error(e);
	    throw new DBIllegalStateException(
		    "method loadIpV6List has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e) {
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}
    }

    @Override
    public Collection<IpV4Address> loadIpV4ListByRange(int from, int count)
	    throws DBPersistanceException, DBIllegalArgumentException,
	    DBIllegalStateException, DBException {
	try {
	    return blackListDao.loadIpV4ListByRange(from, count);
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e) {
	    logger.error(e);
	    throw new DBIllegalArgumentException(
		    "method loadIpV4ListByRange has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e) {
	    logger.error(e);
	    throw new DBIllegalStateException(
		    "method loadIpV4ListByRange has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e) {
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}
    }

    @Override
    public Collection<IpV6Address> loadIpV6ListByRange(int from, int count)
	    throws DBPersistanceException, DBIllegalArgumentException,
	    DBIllegalStateException, DBException {
	try {
	    return blackListDao.loadIpV6ListByRange(from, count);
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e) {
	    logger.error(e);
	    throw new DBIllegalArgumentException(
		    "method loadIpV6ListByRange has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e) {
	    logger.error(e);
	    throw new DBIllegalStateException(
		    "method loadIpV6ListByRange has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e) {
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}
    }

}
