package tc.lv.service;

import tc.lv.exceptions.UserEntityServiceException;

public interface UserEntityService {

    public boolean makeUserAdmin(String username)
	    throws UserEntityServiceException;

    public boolean createUser(String username, String firstname,
	    String lastname, String email, String password)
	    throws UserEntityServiceException;
}
