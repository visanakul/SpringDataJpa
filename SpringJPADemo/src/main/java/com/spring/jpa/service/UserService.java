package com.spring.jpa.service;

import java.util.List;

import com.spring.jpa.model.User;

public interface UserService {
	List<User> getAllUsers();
	List<User> getAllUsersByName(String searchName) ;
	Integer saveUser(User user);
}
