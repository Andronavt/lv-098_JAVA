package tc.lv.dao;

import tc.lv.domain.UserEntity;

public interface UserDao {
	public UserEntity getUserByName(String name);

	public void addAdminUser(String username, String firstname,
			String lastname, String email, String password);

	public void addCustomerUser(String username, String firstname,
			String lastname, String email, String password);

}
