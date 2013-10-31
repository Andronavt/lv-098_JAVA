package tc.lv.domain;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserSecurity implements UserDetails {
	private static final long serialVersionUID = 8266525488057072269L;
	private User user;
	private String username;
	private String password;
	static Role grandAuthRole;
	private Collection<GrantedAuthority> authorities;

	public UserSecurity(User inputUser) {
		super();
		user = inputUser;
		this.username = inputUser.getUsername();
		this.password = inputUser.getPassword();
		this.setRoles(inputUser.getRoleSet());
	}

	public void setRoles(Set<Role> set) {
		this.authorities = new HashSet<GrantedAuthority>();
		for ( Role tempRole : set) {
			grandAuthRole = tempRole;

			GrantedAuthority grandAuthority = new GrantedAuthority() {
				private static final long serialVersionUID = 3958183417696804555L;

				public String getAuthority() {
					return grandAuthRole.getRole();
				}
			};
			this.authorities.add(grandAuthority);

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
		return true;
	}
}
