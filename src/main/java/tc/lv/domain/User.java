package tc.lv.domain;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class User implements UserDetails {
    private static final long serialVersionUID = 8266525488057072269L;
    private String username;
    private String password;
    private Collection<GrantedAuthority> authorities;

    public User(String username, String password, String roles) {
	super();
	this.username = username;
	this.password = password;
	this.setRoles(roles);
    }

    public void setRoles(String roles) {
	this.authorities = new HashSet<GrantedAuthority>();
	for (final String role : roles.split(",")) {
	    if (role != null && !"".equals(role.trim())) {
		GrantedAuthority grandAuthority = new GrantedAuthority() {
		    private static final long serialVersionUID = 3958183417696804555L;

		    public String getAuthority() {
			return role.trim();
		    }
		};
		this.authorities.add(grandAuthority);
	    }
	}
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
	return this.authorities;
    }

    public String getPassword() {
	return password;
    }

    public String getUsername() {
	return username;
    }

    public boolean isAccountNonExpired() {
	return true;
    }

    public boolean isAccountNonLocked() {
	return true;
    }

    public boolean isCredentialsNonExpired() {
	return true;
    }

    public boolean isEnabled() {
	int a=1;
	int d;
	d= a==0 ?(a==1?0:1):5;
	
	return true;
    }
}
