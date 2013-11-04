package tc.lv.service;

public interface UserEntityService {

	public void addAdminUser(String username, String firstname,
			String lastname, String email, String password);

	public void addCustomerUser(String username, String firstname,
			String lastname, String email, String password);
}
