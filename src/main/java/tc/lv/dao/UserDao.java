package tc.lv.dao;

import tc.lv.domain.UserDB;

public interface UserDao {
	public UserDB getUserByName(String name);
	public void addAdminUser(String name,String password);
	public void addCustomerUser(String name,String password);
	
	
}
