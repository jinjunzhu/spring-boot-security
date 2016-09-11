package service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import domain.MyUser;
import domain.UserRole;
import repository.UserRoleRepository;

@Service
public class UserRoleService {
	
	@Resource
	private UserRoleRepository userRoleRepository;
	
	public List<UserRole> getRoleByUser(MyUser user){
		return userRoleRepository.getRoleByUser(user.getId());
	}

}
