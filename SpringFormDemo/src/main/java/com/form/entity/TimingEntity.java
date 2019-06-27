package com.form.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TIMIMG_MASTER")
public class TimingEntity {
	@Id
	private Integer timingId;
	private String timimg;
}
