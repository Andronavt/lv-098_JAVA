package tc.lv.service;

import tc.lv.exceptions.UserEntityServiceException;

public interface UserEntityService {

    public void makeUserAdmin(String username)
	    throws UserEntityServiceException;

    public void createUser(String username, String firstname, String lastname,
	    String email, String password) throws UserEntityServiceException;
}
