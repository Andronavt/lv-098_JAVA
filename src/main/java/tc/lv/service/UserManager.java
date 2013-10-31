package tc.lv.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tc.lv.dao.UserDaoImpl;
import tc.lv.domain.UserSecurity;


@Service
public class UserManager {
	@Autowired
	private HashMap<String, UserSecurity> users;
	@Autowired
	private UserDaoImpl userDao = new UserDaoImpl();

	public UserManager() {
//		users = new HashMap<String, UserSecurity>();
//		users.put("john", new UserSecurity("john", "1", "ROLE_USER"));
//		users.put("bob", new UserSecurity("bob", "2", "ROLE_USER, ROLE_ADMIN"));
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
		//UserDaoImpl userDao = new UserDaoImpl();
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!2");
		users = (HashMap<String, UserSecurity>) userDao.getUserMap();
	}
	
	public UserSecurity getUser(String username) throws UsernameNotFoundException{
		if( !users.containsKey( username ) ){
			throw new UsernameNotFoundException( username + " not found" );
		}
		
		return users.get( username );		
	}
}
