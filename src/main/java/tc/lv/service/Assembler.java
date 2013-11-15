package tc.lv.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.Role;

@SuppressWarnings("deprecation")
@Service("assembler")
public class Assembler {

	@Transactional(readOnly = true)
	org.springframework.security.core.userdetails.User buildUserFromUserEntity(tc.lv.domain.User userEntity) {

		String username = userEntity.getUsername();
		String password = userEntity.getPassword();

		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

		for (Role role : userEntity.getRoleSet()) {
			authorities.add(new GrantedAuthorityImpl(role.getRole()));
		}

		org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(username, password, authorities);

		return user;
	}
}
