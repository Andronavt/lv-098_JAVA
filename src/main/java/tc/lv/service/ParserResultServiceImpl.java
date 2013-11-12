package tc.lv.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.DownloaderDao;
import tc.lv.dao.SourceDao;
import tc.lv.exceptions.ParserResultServiceException;
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
	public void save(ParserResults result) throws ParserResultServiceException {
		try {
			downloaderDao.save(result);
		} catch (Exception e) {
			logger.error(e);
			throw new ParserResultServiceException("Entity manager Exception",
					e);
		}
	}

	@Transactional
	@Override
	public void saveAllSources(List<ParserResults> resultList)
			throws ParserResultServiceException {
		try {
			for (ParserResults result : resultList) {
				this.save(result);
			}
		} catch (Exception e) {
			logger.error(e);
			throw new ParserResultServiceException("Entity manager Exception",
					e);
		}
	}
}
