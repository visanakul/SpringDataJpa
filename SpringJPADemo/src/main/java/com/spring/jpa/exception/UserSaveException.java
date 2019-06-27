package com.spring.jpa.exception;

import org.apache.log4j.Logger;

import com.spring.jpa.service.UserServiceImpl;

public class UserSaveException extends RuntimeException {
	/**
	 * Default serial version
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getSimpleName());

	public UserSaveException(String errorMessage) {
		super(errorMessage);
		LOGGER.info("EmptyListException");
		
	}
}
