package com.spring.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="JPA_USER_TABLE")
public class UserEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="user_id_gen")
	@SequenceGenerator(name="user_id_gen",sequenceName="user_id_seq",initialValue=1,allocationSize=1)
	private Integer userId;
	private String password;
	private String name; 
	private String mobile;
	@OneToOne
	private StateEntity state;
}
