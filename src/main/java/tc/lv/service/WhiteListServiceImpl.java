package tc.lv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.WhiteListDao;

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

}
