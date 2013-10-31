package tc.lv.service;

import java.util.HashMap;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tc.lv.domain.UserSecurity;


@Service
public class UserManager {
	private HashMap<String, UserSecurity> users;

	public UserManager() {
		users = new HashMap<String, UserSecurity>();
		users.put("john", new UserSecurity("john", "1", "ROLE_USER"));
		users.put("bob", new UserSecurity("bob", "2", "ROLE_USER, ROLE_ADMIN"));
	}
	
	public UserSecurity getUser(String username) throws UsernameNotFoundException{
		if( !users.containsKey( username ) ){
			throw new UsernameNotFoundException( username + " not found" );
		}
		
		return users.get( username );		
	}
}
