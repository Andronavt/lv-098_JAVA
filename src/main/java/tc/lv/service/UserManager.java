package tc.lv.service;

import java.util.HashMap;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import tc.lv.domain.User;


@Service
public class UserManager {
	private HashMap<String, User> users;

	public UserManager() {
		users = new HashMap<String, User>();
		users.put("john", new User("john", "1", "ROLE_USER"));
		users.put("bob", new User("bob", "2", "ROLE_USER, ROLE_ADMIN"));
	}
	
	public User getUser(String username) throws UsernameNotFoundException{
		if( !users.containsKey( username ) ){
			throw new UsernameNotFoundException( username + " not found" );
		}
		
		return users.get( username );		
	}
}
