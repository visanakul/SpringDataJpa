package com.form.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USER_MASTER")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_id_generator")
	@SequenceGenerator(name = "user_id_generator", sequenceName = "user_id_seq",initialValue=1)
	private Integer userId;
	private String fname;
	private String lname;
	@OneToOne
	@PrimaryKeyJoinColumn
	private GenderEntity genderEntity;
	@OneToOne
	@PrimaryKeyJoinColumn
	private QualificationEntity qualificationEntity;
	@OneToOne
	@PrimaryKeyJoinColumn
	private TimingEntity timingEntity;
}
