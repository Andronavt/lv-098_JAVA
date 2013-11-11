package tc.lv.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.WhiteListDao;
import tc.lv.domain.IpV4Address;
import tc.lv.domain.IpV6Address;

@Service
public class WhiteListServiceImpl implements WhiteListService {

	@Autowired
	private WhiteListDao whiteListDao;

	@Transactional
	public void deleteIpV4(String address) {
		whiteListDao.deleteIpV4(address);
	}

	@Transactional
	public void deleteIpV6(String address) {
		whiteListDao.deleteIpV6(address);
	}

	@Transactional
	public void saveIpV4(String address) {
		whiteListDao.saveIpV4(address);
	}

	@Transactional
	public void saveIpV6(String address) {
		whiteListDao.saveIpV6(address);
	}

	@Transactional
	public Collection<IpV4Address> loadIpV4List(int from, int count) {
		return whiteListDao.loadIpV4List(from, count);
	}

	@Transactional
	public Collection<IpV6Address> loadIpV6List(int from, int count) {
		return whiteListDao.loadIpV6List(from, count);
	}

}
