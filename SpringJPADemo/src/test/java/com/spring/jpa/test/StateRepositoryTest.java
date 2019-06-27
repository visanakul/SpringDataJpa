package com.spring.jpa.test;

import java.util.List;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.jpa.entity.StateEntity;
import com.spring.jpa.repository.StateRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring.xml" })
public class StateRepositoryTest {

	@Autowired
	private StateRepository stateRepository;

	@Test
	public void getAllStates() {
		List<StateEntity> stateEntities = stateRepository.findAll();
		System.out.println("*****State List : " + stateEntities + "***");
		assertNotEquals("List empty", 0,stateEntities.size());
	}

}
