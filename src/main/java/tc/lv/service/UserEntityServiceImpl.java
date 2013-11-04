package tc.lv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.UserDao;

@Service
public class UserEntityServiceImpl implements UserEntityService {

	@Autowired
	private UserDao userDao;

	@Transactional
<<<<<<< HEAD
=======
	public void addAdminUser(String username, String firstname,
			String lastname, String email, String password) {
		// TODO Auto-generated method stub

	}

	@Transactional
>>>>>>> master
	public void addCustomerUser(String username, String firstname,
			String lastname, String email, String password) {
		userDao.addCustomerUser(username, firstname, lastname, email, password);
	}

}
