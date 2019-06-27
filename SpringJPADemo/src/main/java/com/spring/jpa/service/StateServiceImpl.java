package com.spring.jpa.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.jpa.entity.StateEntity;
import com.spring.jpa.model.StateModel;
import com.spring.jpa.repository.StateRepository;

@Service
@Transactional
public class StateServiceImpl implements StateService {

	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getSimpleName());

	@Autowired
	private StateRepository stateRepository;

	public StateServiceImpl() {
		LOGGER.info("***StateServiceImpl***");
	}

	@Override
	public List<StateModel> getAllStates() {
		List<StateEntity> stateEntities = stateRepository.findAll();
		List<StateModel> stateModels = new ArrayList<>(stateEntities.size());
		LOGGER.debug("***State List " + stateModels + "***");
		return stateModels;
	}

	@Override
	public StateModel getStateById(Integer stateId) {
		StateEntity stateEntity=stateRepository.findByStateId(stateId);
		StateModel stateModel=new StateModel();
		BeanUtils.copyProperties(stateEntity, stateModel);
		return stateModel;
	}

}
