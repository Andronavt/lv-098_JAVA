package tc.lv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.SourceDao;
import tc.lv.domain.IpV4Address;

@Repository
public class SourceServiceImpl implements SourceService {

	@Autowired
	private SourceDao sourceDao;

	@Transactional
	public List<IpV4Address> getIpV4ListFromSource(int sourceId) {
		return sourceDao.getIpV4ListFromSource(sourceId);
	}

}
