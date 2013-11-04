package tc.lv.dao;

import tc.lv.domain.UserEntity;

public interface UserDao {
	public UserEntity getUserByName(String name);

<<<<<<< HEAD
	public void addAdminUser(String name, String password);
=======
	public void addAdminUser(String username, String firstname,
			String lastname, String email, String password);
>>>>>>> master

	public void addCustomerUser(String username, String firstname,
			String lastname, String email, String password);

}
