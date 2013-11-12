package tc.lv.service;

import tc.lv.exceptions.DBCreateUserException;
import tc.lv.exceptions.DBException;
import tc.lv.exceptions.DBIllegalArgumentException;
import tc.lv.exceptions.DBIllegalStateException;
import tc.lv.exceptions.DBPersistanceException;

public interface UserEntityService {

    public void makeUserAdmin(String username) throws DBPersistanceException,
	    DBIllegalArgumentException, DBIllegalStateException, DBException;

    public void createUser(String username, String firstname, String lastname,
	    String email, String password) throws DBCreateUserException,
	    DBPersistanceException, DBIllegalArgumentException,
	    DBIllegalStateException, DBException;
}
