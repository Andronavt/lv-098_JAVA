package tc.lv.dao;

import tc.lv.domain.User;

public interface UserDao {
	public User getUserByName(String name);
	public void addAdminUser(String name,String password);
	public void addCustomerUser(String name,String password);
	
	
}
