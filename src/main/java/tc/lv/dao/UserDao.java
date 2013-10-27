package tc.lv.dao;

import tc.lv.domain.User;

public interface UserDao {
	User getUserByName(String name);
	boolean addAdminUser(String name,String password);
	boolean addCustomerUser(String name,String password);
	
	
}
