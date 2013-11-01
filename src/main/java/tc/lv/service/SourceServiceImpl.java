package tc.lv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.SourceDao;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.Source;

@Service
public class SourceServiceImpl implements SourceService {

	@Autowired
	private SourceDao sourceDao;

	@Transactional
	public List<IpV4Address> getIpV4ListFromSource(int sourceId) {
		return sourceDao.getIpV4ListFromSource(sourceId);
	}

	@Transactional
	public void setIpV4Address(String ip, int sourceId) {
		sourceDao.setIpV4Address(ip, sourceId);
	}

	@Transactional
	public void setIpV6Address(String ip, int sourceId) {
		sourceDao.setIpV4Address(ip, sourceId);
	}

	@Transactional
	public void addNewFeed(String adaptor, String typeofList, String rank,
			String sourceName, String url) {
		sourceDao.addNewFeed(adaptor, typeofList, rank, sourceName, url);
	}

	@Transactional
	public List<Source> getListOfSourcess() {
		return sourceDao.getListOfSources();
	}

	@Transactional
	public void deleteFeed(String sourceName) {
		sourceDao.deleteFeed(sourceName);
	}
}
