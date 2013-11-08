package tc.lv.dao;

import tc.lv.domain.UserEntity;

public interface UserDao {

	UserEntity loadByName(String name);

	void createAdminUser(String username, String firstname, String lastname,
			String email, String password);

	void createCustomerUser(String username, String firstname, String lastname,
			String email, String password);

}
