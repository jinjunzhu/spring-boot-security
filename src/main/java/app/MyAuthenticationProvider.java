package app;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import service.UserService;
import domain.MyUser;
import domain.MyUserDetails;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider{

	@Autowired
    private UserService userService;

    /**
     * 自定义验证方式
     */
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        MyUser myUser = userService.findByName(username);
        MyUserDetails user = (MyUserDetails) userService.loadUserByUsername(myUser);
        if(user == null){
            throw new BadCredentialsException("the user is not exist!");
        }

        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("password wrong!");
        }

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }
    
    public boolean supports(Class<?> arg0) {
        return true;
    }
}
