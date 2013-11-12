package tc.lv.service;

import java.util.Date;
import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.BlackListDao;
import tc.lv.dao.IpV4AddressDao;
import tc.lv.dao.IpV6AddressDao;
import tc.lv.dao.SourceDao;
import tc.lv.dao.WhiteListDao;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.Source;
import tc.lv.exceptions.DBCreateSourceException;
import tc.lv.exceptions.DBException;
import tc.lv.exceptions.DBIllegalArgumentException;
import tc.lv.exceptions.DBIllegalStateException;
import tc.lv.exceptions.DBPersistanceException;

@Service
public class SourceServiceImpl implements SourceService {
    private static final Logger logger = Logger.getLogger("errorLog");
    @Autowired
    private SourceDao sourceDao;
    @Autowired
    private IpV4AddressDao ipV4AddressDao;
    @Autowired
    private IpV6AddressDao ipV6AddressDao;
    @Autowired
    private WhiteListDao whiteListDao;
    @Autowired
    private BlackListDao blackListDao;

    @Transactional
    public List<IpV4Address> getIpV4ListFromSource(int sourceId)
	    throws DBPersistanceException, DBIllegalArgumentException,
	    DBIllegalStateException, DBException {
	try {
	    return ipV4AddressDao.loadAllIpBySource(sourceId);
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e) {
	    logger.error(e);
	    throw new DBIllegalArgumentException(
		    "method getIpV4ListFromSource() has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e) {
	    logger.error(e);
	    throw new DBIllegalStateException(
		    "method getIpV4ListFromSource() has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e) {
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}
    }
    @Transactional
    public void addNewFeed(String dirname, String listType, double rank,
	    String sourceName) throws DBCreateSourceException,
	    DBPersistanceException, DBIllegalArgumentException,
	    DBIllegalStateException, DBException {
	try {
	    Source tempSource = new Source(sourceName, new Date(), rank,
		    dirname, listType);

	    sourceDao.create(tempSource);
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e) {
	    logger.error(e);
	    throw new DBIllegalArgumentException(
		    "method addNewFeed() has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e) {
	    logger.error(e);
	    throw new DBIllegalStateException(
		    "method addNewFeed() has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e) {
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}
    }

    @Transactional
    public List<Source> getListOfSourcess() throws DBPersistanceException,
	    DBIllegalArgumentException, DBIllegalStateException, DBException {
	try {
	    return sourceDao.loadAll();
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e) {
	    logger.error(e);
	    throw new DBIllegalArgumentException(
		    "method getListOfSourcess() has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e) {
	    logger.error(e);
	    throw new DBIllegalStateException(
		    "method getListOfSourcess() has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e) {
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}
    }

    @Transactional
    public void deleteFeed(String sourceName) throws DBPersistanceException,
	    DBIllegalArgumentException, DBIllegalStateException, DBException {
	try {
	    sourceDao.delete(sourceName);
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e) {
	    logger.error(e);
	    throw new DBIllegalArgumentException(
		    "method deleteFeed() has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e) {
	    logger.error(e);
	    throw new DBIllegalStateException(
		    "method deleteFeed() has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e) {
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}
    }
}
