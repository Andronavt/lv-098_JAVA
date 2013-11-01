package tc.lv.dao;

import tc.lv.domain.UserEntity;

public interface UserDao {
	public UserEntity getUserByName(String name);
	public void addAdminUser(String name,String password);
	public void addCustomerUser(String name,String password);
	
	
}
