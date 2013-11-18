package tc.lv.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.DownloaderDao;
import tc.lv.exceptions.ParserResultServiceException;
import tc.lv.utils.ParserResults;

@Service
public class ParserResultServiceImpl implements ParserResultService {

    private static final Logger LOGGER = Logger.getLogger(ParserResultServiceImpl.class);

    @Autowired
    private DownloaderDao downloaderDao;

    // Update source in DataBAse
    @Transactional
    @Override
    public void save(ParserResults result) throws ParserResultServiceException {

        LOGGER.info("Start updating Data Base");
        try {
            downloaderDao.save(result);
            LOGGER.info("Finish updating Data Base");

        } catch (Exception e) {
            LOGGER.error(e);
            throw new ParserResultServiceException("Could not save results of parser", e);
        }
    }

    @Transactional
    @Override
    public void saveAllSources(List<ParserResults> resultList) throws ParserResultServiceException {

        try {

            for (ParserResults result : resultList) {
                this.save(result);
            }

        } catch (Exception e) {
            LOGGER.error(e);
            throw new ParserResultServiceException("Could not save results of all sources", e);
        }
    }
}
