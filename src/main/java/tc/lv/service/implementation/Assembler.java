package tc.lv.service.implementation;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tc.lv.domain.Role;

@Service("assembler")
public class Assembler {

    @Transactional(readOnly = true)
    User buildUserFromUserEntity(tc.lv.domain.User userEntity) {

        String username = userEntity.getUsername();
        String password = userEntity.getPassword();

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();

        for (Role role : userEntity.getRoleSet()) {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        }

        User user = new User(username, password, authorities);

        return user;
    }
}
