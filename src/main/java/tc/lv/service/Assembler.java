package tc.lv.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.Role;
import tc.lv.domain.User;
import tc.lv.domain.UserSecurity;

@SuppressWarnings("deprecation")
@Service("assembler")
public class Assembler {

  @Transactional(readOnly = true)
  UserSecurity buildUserFromUserEntity(User userEntity) {
    String username = userEntity.getUsername();
    String password = userEntity.getPassword();
//    boolean enabled = userEntity.isActive();
//    boolean accountNonExpired = userEntity.isActive();
//    boolean credentialsNonExpired = userEntity.isActive();
//    boolean accountNonLocked = userEntity.isActive();

    Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    for (Role role : userEntity.getRoleSet()) {
      authorities.add(new GrantedAuthorityImpl(role.getRole()));
    }
    UserSecurity user = new UserSecurity(username, password, authorities);
    
    return user;
  }
}
