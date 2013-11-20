package tc.lv.service.implementation;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpAddressDao;
import tc.lv.dao.SourceDao;
import tc.lv.domain.Source;
import tc.lv.exceptions.SourceServiseException;
import tc.lv.service.SourceService;

@Service
public class SourceServiceImpl implements SourceService {

    private static final Logger LOGGER = Logger.getLogger(SourceServiceImpl.class);

    @Autowired
    private SourceDao sourceDao;

    @Autowired
    private IpAddressDao ipAddressDao;

    @Transactional
    @Override
    public boolean addNewFeed(String parser, String sourceName, String url, String listType, Double rank)
            throws SourceServiseException {
        try {
            if (sourceDao.findByName(sourceName) == null) {
                Source tempSource = new Source(parser, sourceName, url, listType, rank);
                sourceDao.save(tempSource);
                return true;
            }
            return false;

        } catch (Exception e) {
            LOGGER.error(e);
            throw new SourceServiseException("Problem in adding new feed", e);
        }
    }

    @Transactional()
    @Override
    public List<Source> getListOfSourcess() throws SourceServiseException {
        try {
            return sourceDao.findAll();

        } catch (Exception e) {
            LOGGER.error(e);
            throw new SourceServiseException("Could not get list of sources", e);
        }
    }

    @Transactional()
    @Override
    public boolean deleteFeedByName(String sourceName) throws SourceServiseException {
        try {
            if (sourceDao.findByName(sourceName) != null) {
                Source source = sourceDao.findByName(sourceName);
                sourceDao.delete(source);
                return true;
            }
            return false;

        } catch (Exception e) {
            LOGGER.error(e);
            throw new SourceServiseException("Could not delete feed", e);
        }
    }
}
