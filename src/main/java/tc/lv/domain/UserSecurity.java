package tc.lv.domain;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSecurity implements UserDetails {
    private static final long serialVersionUID = 8266525488057072269L;
    private String username;
    private String password;
    private Collection<GrantedAuthority> authorities;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean credentialsNonExpired;
    private boolean accountNonLocked;

    public UserSecurity(String username, String password, boolean enabled,
	    boolean accountNonExpired, boolean credentialsNonExpired,
	    boolean accountNonLocked, Collection<GrantedAuthority> authorities) {
	super();
	this.username = username;
	this.password = password;
	this.authorities = authorities;
	this.enabled = enabled;
	this.accountNonExpired = accountNonExpired;
	this.accountNonLocked = accountNonLocked;
	this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setAuthorities(Collection<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public void setRoles(String roles) {
	// this.authorities = new HashSet<GrantedAuthority>();
	// for (final String role : roles.split(",")) {
	// if (role != null && !"".equals(role.trim())) {
	// GrantedAuthority grandAuthority = new GrantedAuthority() {
	// private static final long serialVersionUID = 3958183417696804555L;
	//
	// public String getAuthority() {
	// return role.trim();
	// }
	// };
	// this.authorities.add(grandAuthority);
	// }
	// }
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
	return true;
    }
}
