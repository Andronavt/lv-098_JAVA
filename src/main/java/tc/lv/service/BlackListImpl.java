package tc.lv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.BlackListDao;

@Service
public class BlackListImpl implements BlackListService {
	@Autowired
	private BlackListDao blackListDao;

	@Transactional
	public void deleteIpV4FromBL(String address) {
		blackListDao.deleteIpV4FromBL(address);
	}

	@Override
	public void deleteIpV6FromBL(String address) {
		blackListDao.deleteIpV6FromBL(address);
	}

}
