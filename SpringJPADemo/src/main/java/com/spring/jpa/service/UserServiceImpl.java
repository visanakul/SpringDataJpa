package com.spring.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jpa.entity.UserEntity;
import com.spring.jpa.exception.EmptyListException;
import com.spring.jpa.exception.NullListException;
import com.spring.jpa.exception.UserSaveException;
import com.spring.jpa.model.UserModel;
import com.spring.jpa.repository.UserRepository;
import com.spring.jpa.util.DeepCopyBeanUtils;

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
	public List<UserModel> getAllUsers() {
		LOGGER.info("getAllUsers start");
		List<UserEntity> entities=userRepository.findAll(sortByIdDesc());
		if(entities==null){
			throw new NullListException("List is null...");
		}
		if(entities.size()==0){
			throw new EmptyListException("List is empty...");
		}
		List<UserModel> userModels=new ArrayList<>(entities.size());
		for(UserEntity userEntity:entities){
			UserModel userModel=new UserModel();
			DeepCopyBeanUtils.copyBean(userEntity, userModel);
			
			LOGGER.info("***"+userModel+"***");
			userModels.add(userModel);
		}
		LOGGER.info("getAllUsers end");
		return userModels;
	}
	@Override
	public List<UserModel> getAllUsersByName(String searchName) {
		LOGGER.info("getAllUsersByName start");
		List<UserEntity> entities=userRepository.findByNameContainingIgnoreCase(searchName);
		if(entities==null){
			throw new NullListException("List is null...");
		}
		if(entities.size()==0){
			throw new EmptyListException("List is empty...");
		}
		List<UserModel> userModels=new ArrayList<>(entities.size());
		for(UserEntity userEntity:entities){
			UserModel userModel=new UserModel();
			DeepCopyBeanUtils.copyBean(userEntity, userModel);
			
			LOGGER.info("***"+userModel+"***");
			userModels.add(userModel);
		}
		LOGGER.info("getAllUsersByName end");
		return userModels;
	}
	@Override
	public Integer saveUser(UserModel userModel) {
		LOGGER.info("saveUser start");
		LOGGER.debug("User : "+userModel);
		
		UserEntity userEntity=new UserEntity();
		DeepCopyBeanUtils.copyBean( userModel,userEntity);
		
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
