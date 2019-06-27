package com.spring.jpa.demo;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.spring.jpa.model.UserModel;
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
			UserModel user = new UserModel();
			user.setMobile("1234567892");
			user.setName("user2");
			user.setPassword("pass2");

			Integer userId = userService.saveUser(user);
			LOGGER.debug("User Saved with id : " + userId);
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
