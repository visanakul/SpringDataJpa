create table GENDER_MASTER(genderId number(1) primary key,genderType varchar(6) unique);
insert all
	into GENDER_MASTER values(1,'Male')
	into GENDER_MASTER values(2,'Female')
select * from dual;

create table QUALIFICATION_MASTER(qualificationId number(1) primary key,qualificationType varchar(20) unique);
insert all
	into QUALIFICATION_MASTER values(1,'Post Graduation')
	into QUALIFICATION_MASTER values(2,'Graduation')
	into QUALIFICATION_MASTER values(3,'Under Graduation')
select * from dual;

create table TIMIMG_MASTER(timingId number(1) primary key,timimg varchar(20) unique);
insert all
	into TIMIMG_MASTER values(1,'Morning')
	into TIMIMG_MASTER values(2,'Afternoon')
	into TIMIMG_MASTER values(3,'Evening')
select * from dual;