package com.spring.jpa.model;

import lombok.Data;

@Data
public class User {
	private Integer userId;
	private String password;
	private String name;
	private String mobile;
}
