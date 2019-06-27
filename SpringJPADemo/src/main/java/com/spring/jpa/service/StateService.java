package com.spring.jpa.service;

import java.util.List;

import com.spring.jpa.model.StateModel;

public interface StateService {
	List<StateModel> getAllStates();
	StateModel getStateById(Integer stateId);
}
