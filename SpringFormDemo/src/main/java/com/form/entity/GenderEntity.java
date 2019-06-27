package com.form.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="GENDER_MASTER")
public class GenderEntity {
	@Id
	private Integer genderId;
	private String genderType;
}
