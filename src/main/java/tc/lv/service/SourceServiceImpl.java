package tc.lv.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.IpV4AddressDao;
import tc.lv.dao.IpV6AddressDao;
import tc.lv.dao.SourceDao;
import tc.lv.domain.Source;
import tc.lv.exceptions.SourceServiseException;

@Service
public class SourceServiceImpl implements SourceService {
	private static final Logger logger = Logger.getLogger("errorLog");
	@Autowired
	private SourceDao sourceDao;
	@Autowired
	private IpV4AddressDao ipV4AddressDao;
	@Autowired
	private IpV6AddressDao ipV6AddressDao;

	@Transactional
	@Override
	public void addNewFeed(String parser, String sourceName, String url,
			String listType, Double rank) throws SourceServiseException {
		try {
			Source tempSource = new Source(parser, sourceName, url, listType,
					rank);
			sourceDao.save(tempSource);
		} catch (Exception e) {
			logger.error(e);
			throw new SourceServiseException("Entity manager Exception", e);
		}
	}

	@Transactional
	@Override
	public List<Source> getListOfSourcess() throws SourceServiseException {
		try {
			return sourceDao.getAll();
		} catch (Exception e) {
			logger.error(e);
			throw new SourceServiseException("Entity manager Exception", e);
		}
	}

	@Transactional
	@Override
	public void deleteFeed(String sourceName) throws SourceServiseException {
		try {
			Source source = sourceDao.findByName(sourceName);
			sourceDao.delete(source);
		} catch (Exception e) {
			logger.error(e);
			throw new SourceServiseException("Entity manager Exception", e);
		}
	}
}
