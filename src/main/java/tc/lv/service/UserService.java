package tc.lv.service;

import tc.lv.exceptions.UserEntityServiceException;

public interface UserService {

    public boolean makeUserAdminByName(String username) throws UserEntityServiceException;

    public boolean createUser(String username, String firstname, String lastname, String email, String password)
            throws UserEntityServiceException;
}
