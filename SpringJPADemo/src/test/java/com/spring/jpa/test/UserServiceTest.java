package com.spring.jpa.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.jpa.exception.EmptyListException;
import com.spring.jpa.model.User;
import com.spring.jpa.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring.xml" })
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Test(expected = EmptyListException.class)
	@Ignore
	public void getAllUser1_Test() {
		List<User> userList = userService.getAllUsers();
		assertFalse("Users not available", userList.isEmpty());
	}

	@Test
	@Ignore
	public void saveUser_Test() {
		User user = new User();
		user.setName("user1");
		user.setPassword("pass1");
		user.setMobile("1234567890");
		Integer userId = userService.saveUser(user);
		assertTrue("Save error", userId > 0);
	}
	
	@Test
	public void showAllUser_Test() {
		List<User> userList = userService.getAllUsers();
		System.out.println("*****Sorted by Id desc : "+userList+"*****************");
		assertNotNull("List Object not available", userList);
		assertNotEquals("Records not available", 0, userList.size());
	}
	
	@Test
	@Ignore
	public void showAllUserByName_Test() {
		List<User> userList = userService.getAllUsersByName("user1");
		assertNotNull("List Object not available", userList);
		assertNotEquals("Records not available", 0, userList.size());
	}
	
	@Test
	@Ignore
	public void findAllUserByName_Test() {
		List<User> userList = userService.getAllUsersByName("USER2");
		assertNotNull("List Object not available", userList);
		assertNotEquals("Records not available", 0, userList.size());
	}
}
