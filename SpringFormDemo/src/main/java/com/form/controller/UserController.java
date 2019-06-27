//https://www.codejava.net/frameworks/spring/spring-mvc-spring-data-jpa-hibernate-crud-example
package com.form.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping({"/","/showUserForm.htm"})
	public String showUserForm() {
		return "register";
	}
}
