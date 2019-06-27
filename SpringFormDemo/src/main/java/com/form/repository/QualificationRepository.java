package com.form.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.form.entity.QualificationEntity;

@org.springframework.stereotype.Repository
public interface QualificationRepository extends Repository<QualificationEntity, Integer> {
	List<QualificationEntity> findAll();
}
