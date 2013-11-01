package tc.lv.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.Role;
import tc.lv.domain.UserE;

@SuppressWarnings("deprecation")
@Service("assembler")
public class Assembler {

    @Transactional(readOnly = true)
    User buildUserFromUserEntity(UserE userEntity) {
	String username = userEntity.getUsername();
	String password = userEntity.getPassword();
	boolean enabled = true;
	boolean accountNonExpired = true;
	boolean credentialsNonExpired = true;
	boolean accountNonLocked = true;
	// boolean enabled = userEntity.isActive();
	// boolean accountNonExpired = userEntity.isActive();
	// boolean credentialsNonExpired = userEntity.isActive();
	// boolean accountNonLocked = userEntity.isActive();

	Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	for (Role role : userEntity.getRoleSet()) {
	    authorities.add(new GrantedAuthorityImpl(role.getRole()));
	}
	User user = new User(username, password, enabled, accountNonExpired,
		credentialsNonExpired, accountNonLocked, authorities);
	return user;
    }
}
