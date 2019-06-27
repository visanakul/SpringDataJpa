package com.spring.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.jpa.entity.UserEntity;
@Component
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	List<UserEntity> findByNameContainingIgnoreCase(String searchName);
	List<UserEntity> findAllByOrderByUserIdDesc();
	List<UserEntity> findTop3ByOrderByUserIdDesc();
}
