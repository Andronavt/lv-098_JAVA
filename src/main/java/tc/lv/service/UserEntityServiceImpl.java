package tc.lv.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.UserDao;
import tc.lv.domain.UserEntity;
import tc.lv.exceptions.UserEntityServiceException;

@Service
public class UserEntityServiceImpl implements UserEntityService {
    private static final Logger logger = Logger.getLogger("errorLog");
    
    @Autowired
    private UserDao userDao;

    @Transactional
    public void createUser(String username, String firstname, String lastname,
	    String email, String password) throws UserEntityServiceException {
	try {
	    UserEntity tempUser = new UserEntity(username, firstname, lastname,
		    email, password);
	    userDao.createUser(tempUser);
	} catch (Exception e) {
	    logger.error(e);
	    throw new UserEntityServiceException("Entity manager Exception", e);
	}

    }

    @Override
    public void makeUserAdmin(String username)
	    throws UserEntityServiceException {
	try {
	    UserEntity tempUser = userDao.loadByName(username);
	    userDao.makeUserAdmin(tempUser);
	} catch (Exception e) {
	    logger.error(e);
	    throw new UserEntityServiceException("Entity manager Exception", e);
	}
    }

}
