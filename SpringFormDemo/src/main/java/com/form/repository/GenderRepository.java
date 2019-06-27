package com.form.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.form.entity.GenderEntity;

@org.springframework.stereotype.Repository
public interface GenderRepository extends Repository<GenderEntity, Integer> {
	List<GenderEntity> findAll();
}
