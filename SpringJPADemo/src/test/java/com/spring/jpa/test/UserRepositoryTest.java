package com.spring.jpa.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.jpa.entity.UserEntity;
import com.spring.jpa.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring.xml" })
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	@Ignore
	public void test1() {
		assertNotNull("User repository not injected", userRepository);
	}

	@Test
	@Ignore
	public void save_test() {
		UserEntity entity = new UserEntity();
		entity.setName("user2");
		entity.setPassword("pass2");
		entity.setMobile("1234123412");
		entity = userRepository.save(entity);
		assertNotNull("Entity not saved", entity.getUserId());
	}

	@Test
	@Ignore
	public void sort_test() {
		List<UserEntity> sortedList = userRepository.findAllByOrderByUserIdDesc();
		System.out.println("*********Sorted list : " + sortedList + "**********");
		assertNotNull("Entity List null", sortedList);
	}

	@Test
	@Ignore
	public void findTop_test() {
		List<UserEntity> top3List = userRepository.findTop3ByOrderByUserIdDesc();
		System.out.println("*********Top3 list : " + top3List + "**********");
		assertNotNull("Entity List null", top3List);
	}

	@Test
	@Ignore
	public void findSinglePage_test() {
		Pageable pageable=new PageRequest(0, 2);
		//PageRequest request = PageRequest.of(0, 2);
		Page<UserEntity> page = userRepository.findAll(pageable);

		System.out.println("*********Page : " + page + "**********");
		page.forEach(System.out::println);

		assertNotNull("Entity List null", page);
	}
	
	@Test
	public void findAllPage_test() {
		long total_records=userRepository.count();
		int page_size=2;
		int total_pages=(int) (total_records/page_size);
		
		for(int i=0;i<total_pages;i++){
			Pageable pageable=new PageRequest(i, 2);
			List<UserEntity> list=userRepository.findAll(pageable).getContent();
			System.out.println("***Page no : "+(i+1)+"***");
			System.out.println(list);
			System.out.println("------------------------------------");
		}
		assertNotEquals("Pages unavailable", 0,total_pages);
	}

}
