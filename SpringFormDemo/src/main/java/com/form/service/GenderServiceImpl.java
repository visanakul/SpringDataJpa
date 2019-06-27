package com.form.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.form.entity.GenderEntity;
import com.form.model.GenderModel;
import com.form.repository.GenderRepository;

@Service
public class GenderServiceImpl implements GenderService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GenderServiceImpl.class);
	@Autowired(required = true)
	private GenderRepository genderRepository;

	public GenderServiceImpl() {
		LOGGER.info("***GenderServiceImpl***");
	}

	public List<GenderModel> getAllGenders() {
		LOGGER.info("***getAllGenders start***");
		List<GenderEntity> genderEntities = genderRepository.findAll();
		if (genderEntities == null || genderEntities.isEmpty()) {
			LOGGER.warn("***Gender list empty***");
			throw new RuntimeException("Gender list empty");
		}
		List<GenderModel> genderModels=new ArrayList<GenderModel>(genderEntities.size());
		for(GenderEntity genderEntity:genderEntities){
			GenderModel genderModel=new GenderModel();
			BeanUtils.copyProperties(genderEntity, genderModel);
			genderModels.add(genderModel);
		}
		LOGGER.info("***getAllGenders end***");
		return genderModels;
	}


	
}
