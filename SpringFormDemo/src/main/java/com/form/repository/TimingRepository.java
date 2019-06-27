package com.form.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.form.entity.TimingEntity;
@org.springframework.stereotype.Repository
public interface TimingRepository extends Repository<TimingEntity, Integer> {
	List<TimingEntity> findAll();
}
