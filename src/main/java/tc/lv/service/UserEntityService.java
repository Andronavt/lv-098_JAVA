package tc.lv.service;

import tc.lv.exceptions.DBCreateUserException;

public interface UserEntityService {

	public void makeUserAdmin(String username);

	public void addCustomerUser(String username, String firstname,
			String lastname, String email, String password) throws DBCreateUserException;
}
