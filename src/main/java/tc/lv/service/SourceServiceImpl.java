package tc.lv.service;

import java.util.List;

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

@Service
public class SourceServiceImpl implements SourceService {

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
	public List<IpV4Address> getIpV4ListFromSource(int sourceId) {
		return ipV4AddressDao.loadAll(sourceId);
	}

	@Transactional
	public void setIpV4Address(String ip, int sourceId) {
	    ipV4AddressDao..setIpV4Address(ip, sourceId);
	}

	@Transactional
	public void setIpV6Address(String ip, int sourceId) {
		sourceDao.setIpV6Address(ip, sourceId);
	}

	@Transactional
	public void addNewFeed( String typeofList, String rank,
			String sourceName, String url) {
		sourceDao.creat(sourceName, url, sourceDateAdded, rank, dirname, listType, updated, parser, ipSet);
	}

	@Transactional
	public List<Source> getListOfSourcess() {
		return sourceDao.loadAll();
	}

	@Transactional
	public void deleteFeed(String sourceName) {
		sourceDao.delete(sourceName);
	}
}
