package com.spring.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jpa.entity.UserEntity;
import com.spring.jpa.exception.EmptyListException;
import com.spring.jpa.exception.NullListException;
import com.spring.jpa.exception.UserSaveException;
import com.spring.jpa.model.User;
import com.spring.jpa.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getSimpleName());

	public UserServiceImpl() {
		LOGGER.info("*****UserServiceImpl*****");
	}
	
	@Autowired(required=true)
	private UserRepository userRepository;
	
	@Override
	public List<User> getAllUsers() {
		LOGGER.info("getAllUsers start");
		List<UserEntity> entities=userRepository.findAll(sortByIdDesc());
		if(entities==null){
			throw new NullListException("List is null...");
		}
		if(entities.size()==0){
			throw new EmptyListException("List is empty...");
		}
		List<User> models=new ArrayList<>(entities.size());
		for(UserEntity entity:entities){
			User model=new User();
			BeanUtils.copyProperties(entity, model);
			models.add(model);
		}
		LOGGER.info("getAllUsers end");
		return models;
	}
	@Override
	public List<User> getAllUsersByName(String searchName) {
		LOGGER.info("getAllUsersByName start");
		List<UserEntity> entities=userRepository.findByNameContainingIgnoreCase(searchName);
		if(entities==null){
			throw new NullListException("List is null...");
		}
		if(entities.size()==0){
			throw new EmptyListException("List is empty...");
		}
		List<User> models=new ArrayList<>(entities.size());
		for(UserEntity entity:entities){
			User model=new User();
			BeanUtils.copyProperties(entity, model);
			models.add(model);
		}
		LOGGER.info("getAllUsersByName end");
		return models;
	}
	@Override
	public Integer saveUser(User user) {
		LOGGER.info("saveUser start");
		LOGGER.debug("User : "+user);
		UserEntity userEntity=new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		userEntity =userRepository.save(userEntity);
		if(userEntity.getUserId()==null){
			throw new UserSaveException("Record not saved...");
		}
		LOGGER.debug("UserEntity : "+userEntity);
		LOGGER.info("saveUser end");
		return userEntity.getUserId();
	}

	private Sort sortByIdDesc(){
		return new Sort(Sort.Direction.DESC,"userId");
	}
}
