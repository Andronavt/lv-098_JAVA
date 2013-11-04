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
	public void deleteIpV4FromWL(String address) {
		whiteListDao.deleteIpV4FromWL(address);
	}

	@Transactional
	public void deleteIpV6FromWL(String address) {
		whiteListDao.deleteIpV6FromWL(address);
	}

	@Transactional
	public void addIpV4ToWL(String address) {
		whiteListDao.addIpV4toWL(address);
	}

	@Transactional
	public void addIpV6ToWL(String address) {
		whiteListDao.addIpV6toWL(address);
	}

	@Transactional
	public Collection<IpV4Address> getIpV4ListFromWL() {
		return whiteListDao.getIpV4ListFromWL();
	}

	@Transactional
	public Collection<IpV6Address> getIpV6ListFromWL() {
		return whiteListDao.getIpV6ListFromWL();
	}

}
