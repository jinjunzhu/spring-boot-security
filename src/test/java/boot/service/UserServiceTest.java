package boot.service;

import javax.annotation.Resource;

import org.junit.Test;

import boot.support.SpringTxTestCase;
import domain.MyUser;
import service.UserService;


public class UserServiceTest extends SpringTxTestCase{
	
	@Resource
	private UserService userService;
	
	@Test
	public void testFindUserByName(){
		MyUser myUser =  userService.findByName("user");
		System.out.println(myUser.getPassword());
	}

}
