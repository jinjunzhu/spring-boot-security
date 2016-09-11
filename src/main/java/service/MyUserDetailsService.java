package service;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import domain.MyUser;
import domain.MyUserDetails;
import domain.UserRole;

@Service
public class MyUserDetailsService implements UserDetailsService{

    private UserService userService;

    private UserRoleService userRoleService;

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	MyUser user;
        try {
            user = userService.findByName(userName);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user select fail");
        }
        if(user == null){
            throw new UsernameNotFoundException("no user found");
        } else {
            try {
                List<UserRole> roles = userRoleService.getRoleByUser(user);
                return new MyUserDetails(user,roles);
            } catch (Exception e) {
                throw new UsernameNotFoundException("user role select fail");
            }
        }
    }
}
