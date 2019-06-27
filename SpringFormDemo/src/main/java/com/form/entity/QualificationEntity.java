package com.form.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="QUALIFICATION_MASTER")
public class QualificationEntity {
	@Id
	private Integer qualificationId;
	private String qualificationType;
}
