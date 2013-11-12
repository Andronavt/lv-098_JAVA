package tc.lv.service;

import java.util.List;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.DownloaderDao;
import tc.lv.dao.SourceDao;
import tc.lv.exceptions.DBException;
import tc.lv.exceptions.DBIllegalArgumentException;
import tc.lv.exceptions.DBIllegalStateException;
import tc.lv.exceptions.DBPersistanceException;
import tc.lv.utils.ParserResults;

@Service
public class ParserResultServiceImpl implements ParserResultService {
    private static final Logger logger = Logger.getLogger("errorLog");
    @Autowired
    private SourceDao sourceDao;
    @Autowired
    private DownloaderDao downloaderDao;

    // Update source in DataBAse
    @Transactional
    @Override
    public void save(ParserResults result) throws DBPersistanceException,
	    DBIllegalArgumentException, DBIllegalStateException, DBException {
	try {
	    downloaderDao.save(result);
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

    @Transactional
    @Override
    public void saveAllSources(List<ParserResults> resultList)
	    throws DBPersistanceException, DBIllegalArgumentException,
	    DBIllegalStateException, DBException {
	for (ParserResults result : resultList) {
	    this.save(result);
	}
    }
}
