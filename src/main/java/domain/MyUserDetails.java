package domain;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<UserRole> roles;
	private MyUser user;
	
	public MyUserDetails(MyUser user,List<UserRole> roles){
		this.roles = roles;
		this.user = user;
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (roles == null || roles.size() < 1) {
			return AuthorityUtils.commaSeparatedStringToAuthorityList("");
		}
		StringBuilder commaBuilder = new StringBuilder();
		for (UserRole role : roles) {
			commaBuilder.append(role.getRole()).append(",");
		}
		String authorities = commaBuilder.substring(0, commaBuilder.length() - 1);
		return AuthorityUtils.commaSeparatedStringToAuthorityList(authorities);
	}

	public String getUsername() {
		return user.getUserName();
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

	public String getPassword() {
		return user.getPassword();
	}

	public boolean isEnabled() {
		return true;
	}
}
