package tc.lv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.UserDao;
import tc.lv.domain.UserEntity;
import tc.lv.exceptions.DBCreateUserException;

@Service
public class UserEntityServiceImpl implements UserEntityService {

	@Autowired
	private UserDao userDao;

	

	@Transactional
	public void addCustomerUser(String username, String firstname,
			String lastname, String email, String password) throws DBCreateUserException {
		UserEntity tempUser = new UserEntity(username, firstname, lastname, email, password);
		userDao.createUser(tempUser);
	}



	@Override
	public void makeUserAdmin(String username) {
		UserEntity tempUser = userDao.loadByName(username);
		userDao.makeUserAdmin(tempUser);
	}

}
