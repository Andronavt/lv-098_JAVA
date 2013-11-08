package tc.lv.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.Role;
import tc.lv.domain.UserEntity;


@Service("assembler")
public class Assembler {

	@SuppressWarnings("deprecation")
	@Transactional(readOnly = true)
	User buildUserFromUserEntity(UserEntity userEntity) {
		String username = userEntity.getUsername();
		String password = userEntity.getPassword();
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : userEntity.getRoleSet()) {
			authorities.add(new GrantedAuthorityImpl(role.getRole()));
		}
		User user = new User(username, password, authorities);		
		return user;
	}
}
