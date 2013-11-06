package tc.lv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.SourceDao;
import tc.lv.domain.Source;
import tc.lv.utils.Parser;

@Service
public class SourceDownloaderServiceImpl implements SourceDownloaderService {
	
	@Autowired
	private SourceDao sourceDao;
	
	@Transactional
	@Override
	public Source loadSourceByName(String sourceName) {
		return sourceDao.loadSourceByName(sourceName);
		
	}
	@Transactional
	@Override
	public void updateSource(Parser parser) {
		sourceDao.updateSourceIpList(parser);
	}
}
