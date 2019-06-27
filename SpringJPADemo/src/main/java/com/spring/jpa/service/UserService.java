package com.spring.jpa.service;

import java.util.List;

import com.spring.jpa.model.UserModel;

public interface UserService {
	List<UserModel> getAllUsers();
	List<UserModel> getAllUsersByName(String searchName) ;
	Integer saveUser(UserModel user);
}
