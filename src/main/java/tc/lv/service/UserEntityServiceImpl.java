package tc.lv.service;

import javax.persistence.PersistenceException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.dao.UserDao;
import tc.lv.domain.UserEntity;
import tc.lv.exceptions.DBCreateUserException;
import tc.lv.exceptions.DBException;
import tc.lv.exceptions.DBIllegalArgumentException;
import tc.lv.exceptions.DBIllegalStateException;
import tc.lv.exceptions.DBPersistanceException;

@Service
public class UserEntityServiceImpl implements UserEntityService {
    private static final Logger logger = Logger.getLogger("errorLog");
    @Autowired
    private UserDao userDao;

    @Transactional
    public void createUser(String username, String firstname, String lastname,
	    String email, String password) throws DBCreateUserException,
	    DBPersistanceException, DBIllegalArgumentException,
	    DBIllegalStateException, DBException {
	try {
	    UserEntity tempUser = new UserEntity(username, firstname, lastname,
		    email, password);
	    userDao.createUser(tempUser);
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e) {
	    logger.error(e);
	    throw new DBIllegalArgumentException(
		    "method createUser() has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e) {
	    logger.error(e);
	    throw new DBIllegalStateException(
		    "method createUser() has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e) {
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}
    }

    @Override
    public void makeUserAdmin(String username) throws DBPersistanceException,
	    DBIllegalArgumentException, DBIllegalStateException, DBException {
	try {
	    UserEntity tempUser = userDao.loadByName(username);
	    userDao.makeUserAdmin(tempUser);
	} catch (PersistenceException e) {
	    logger.error(e);
	    throw new DBPersistanceException("Entity manager Exception");
	} catch (IllegalArgumentException e) {
	    logger.error(e);
	    throw new DBIllegalArgumentException(
		    "method makeUserAdmin() has been passed an illegal or inappropriate argument.");
	} catch (IllegalStateException e) {
	    logger.error(e);
	    throw new DBIllegalStateException(
		    "method makeUserAdmin() has been passed an illegal or inappropriate argument.");
	} catch (RuntimeException e) {
	    logger.error(e);
	    throw new DBException("Data Base Exception");
	}
    }

}
