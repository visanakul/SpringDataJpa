package com.spring.jpa.demo;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jpa.model.StateModel;
import com.spring.jpa.model.UserModel;
import com.spring.jpa.service.StateService;
import com.spring.jpa.service.UserService;

public class SpringJPADemo {
	private static final Logger LOGGER = Logger.getLogger(SpringJPADemo.class.getSimpleName());

	public SpringJPADemo() {
		LOGGER.info("*****SpringJPADemo*****");
	}

	public static void main(String[] args) {
		// BasicConfigurator.configure();
		LOGGER.info("Main started...");

		ClassPathXmlApplicationContext context = null;

		try {
			context = new ClassPathXmlApplicationContext("spring.xml");
			LOGGER.debug("Context : " + context);

			UserService userService = context.getBean(UserService.class);
			StateService stateService = context.getBean(StateService.class);
			
			//Insert record
			UserModel user = new UserModel();
			user.setMobile("1234567898");
			user.setName("user8");
			user.setPassword("pass8");

			StateModel stateModel=stateService.getStateById(3);
			user.setState(stateModel);
			
			Integer userId = userService.saveUser(user);
			LOGGER.debug("User Saved with id : " + userId);
			
			//SHow all records
			List<UserModel> userModels=userService.getAllUsers();
			LOGGER.debug("User List : " + userModels);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (context != null) {
				LOGGER.info("Context closed...");
				context.close();
			}
		}
	}

}
