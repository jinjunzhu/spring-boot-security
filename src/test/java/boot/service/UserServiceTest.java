package boot.service;

import javax.annotation.Resource;

import boot.support.AbstractSpringbootTest;
import org.junit.Test;

import domain.MyUser;
import service.UserService;


public class UserServiceTest extends AbstractSpringbootTest {
	
	@Resource
	private UserService userService;
	
	@Test
	public void testFindUserByName(){
		MyUser myUser =  userService.findByName("user");
		System.out.println(myUser.getPassword());
	}

}
