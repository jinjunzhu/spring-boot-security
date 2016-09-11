package service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import repository.UserRepository;
import repository.UserRoleRepository;
import domain.MyUser;
import domain.MyUserDetails;

@Service
public class UserService {
	
	@Resource
	private UserRepository userRepository;
	
	@Resource
	private UserRoleRepository userRoleRepository;
	
	public MyUser findByName(String username){
		return userRepository.findByName(username);
	}
	
	public MyUserDetails loadUserByUsername(MyUser user){
		return new MyUserDetails(userRepository.findByName(user.getUserName()), userRoleRepository.getRoleByUser(user.getId()));
	}
	
	

}
