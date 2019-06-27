package com.spring.jpa.util;

import org.springframework.beans.BeanUtils;

import com.spring.jpa.entity.StateEntity;
import com.spring.jpa.entity.UserEntity;
import com.spring.jpa.model.StateModel;
import com.spring.jpa.model.UserModel;

public class DeepCopyBeanUtils {
	public static void copyBean(UserModel userModel, UserEntity userEntity) {

		StateEntity stateEntity = new StateEntity();
		BeanUtils.copyProperties(userModel.getState(), stateEntity);
		userEntity.setState(stateEntity);

		BeanUtils.copyProperties(userModel, userEntity);
		System.out.println("Copied UserEntity : " + userEntity);
	}
	public static void copyBean(UserEntity userEntity,UserModel userModel) {

		StateModel stateModel = new StateModel();
		BeanUtils.copyProperties(userEntity.getState(), stateModel);
		userModel.setState(stateModel);

		BeanUtils.copyProperties(userEntity, userModel);
		System.out.println("Copied UserModel : " + userModel);
	}
}
