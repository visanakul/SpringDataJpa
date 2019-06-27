package com.spring.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="JPA_STATE_MASTER")
public class StateEntity {
	@Id
	private Integer stateId;
	private String stateName;
}
