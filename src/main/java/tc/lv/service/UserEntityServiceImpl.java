package tc.lv.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.UserDao;
import tc.lv.domain.Role;
import tc.lv.domain.UserEntity;
import tc.lv.exceptions.UserEntityServiceException;

@Service
public class UserEntityServiceImpl implements UserEntityService {
    private static final Logger logger = Logger
	    .getLogger(UserEntityServiceImpl.class);

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void createUser(String username, String firstname, String lastname,
	    String email, String password) throws UserEntityServiceException {
	try {
	    UserEntity tempUser = new UserEntity(username, firstname, lastname,
		    email, password);
	    if (userDao.findByName(username) == null) {
		Role role = userDao.findRoleByName("ROLE_USER");
		tempUser.addRoleToUser(role);
		userDao.save(tempUser);
	    } else {
		throw new UserEntityServiceException("Current user exist!");
	    }

	} catch (Exception e) {
	    logger.error(e);
	    throw new UserEntityServiceException("Entity manager Exception", e);
	}

    }

    @Transactional
    @Override
    public void makeUserAdmin(String username)
	    throws UserEntityServiceException {
	UserEntity user = userDao.findByName(username);
	try {
	    if (user != null) {
		Role role = userDao.findRoleByName("ROLE_ADMIN");
		user.addRoleToUser(role);
		userDao.save(user);
	    } else {
		throw new UserEntityServiceException("Current user not exist!");
	    }
	} catch (Exception e) {
	    logger.error(e);
	    throw new UserEntityServiceException("Entity manager Exception", e);
	}
    }
}
