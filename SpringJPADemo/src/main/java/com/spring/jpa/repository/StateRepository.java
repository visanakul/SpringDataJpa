package com.spring.jpa.repository;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.spring.jpa.entity.StateEntity;
@org.springframework.stereotype.Repository
public interface StateRepository extends Repository<StateEntity,Integer>{
	List<StateEntity> findAll();
	StateEntity findByStateId(Integer stateId);
}
