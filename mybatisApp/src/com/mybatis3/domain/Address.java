package com.mybatis3.domain;

import java.util.List;

public class Address 
{
	/*
	이름      널?       유형           
	------- -------- ------------ 
	ADDR_ID NOT NULL NUMBER(11)   
	STREET  NOT NULL VARCHAR2(50) 
	CITY    NOT NULL VARCHAR2(50) 
	STATE   NOT NULL VARCHAR2(50) 
	ZIP              VARCHAR2(10) 
	COUNTRY NOT NULL VARCHAR2(50)
	 */
	private Integer addrId;
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	private List<Student> studentList; 
	
	
	
}
