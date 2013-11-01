package tc.lv.dao;

import tc.lv.domain.UserE;

public interface UserDao {
	public UserE getUserByName(String name);
	public void addAdminUser(String name,String password);
	public void addCustomerUser(String name,String password);
	
	
}
