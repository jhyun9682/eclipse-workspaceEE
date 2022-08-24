package com.itwill.shop.dto;

import oracle.sql.CHAR;

/*
 * 이름         널?       유형            
---------- -------- ------------- 
U_ID       NOT NULL VARCHAR2(100) 
U_PASSWORD          VARCHAR2(100) 
U_NAME              VARCHAR2(100) 
U_BIRTH             VARCHAR2(100) 
U_GENDER            CHAR(10)      
U_PHONE             VARCHAR2(100) 
U_ADDRESS           VARCHAR2(200)
 */
public class User {
	private String u_id;
	private String u_password;
	private String u_name;
	private String u_birth;
	private String u_gender;
	private String u_phone;
	private String u_address;
	
	public User() {
	
	}
	

	public User(String u_id, String u_password, String u_name, String u_birth, String u_gender, String u_phone,
			String u_address) {
		super();
		this.u_id = u_id;
		this.u_password = u_password;
		this.u_name = u_name;
		this.u_birth = u_birth;
		this.u_gender = u_gender;
		this.u_phone = u_phone;
		this.u_address = u_address;
	}


	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	public String getU_password() {
		return u_password;
	}

	public void setU_password(String u_password) {
		this.u_password = u_password;
	}

	public String getU_name() {
		return u_name;
	}

	public void setU_name(String u_name) {
		this.u_name = u_name;
	}

	public String getU_birth() {
		return u_birth;
	}

	public void setU_birth(String u_birth) {
		this.u_birth = u_birth;
	}

	public String getU_gender() {
		return u_gender;
	}

	public void setU_gender(String u_gender) {
		this.u_gender = u_gender;
	}

	public String getU_phone() {
		return u_phone;
	}

	public void setU_phone(String u_phone) {
		this.u_phone = u_phone;
	}

	public String getU_address() {
		return u_address;
	}

	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	/*
	 * 패스워드 일치여부 확인(22.02.22.pm11:43 권하나 추가)
	 */
	public boolean isMatchPassword(String u_password) {
		boolean isMatch=false;
		if(this.u_password.equals(u_password)) {
			isMatch=true;
		}
		return isMatch;
	}

	@Override
	public String toString() {
		return "User [u_id=" + u_id + ", u_password=" + u_password + ", u_name=" + u_name + ", u_birth=" + u_birth
				+ ", u_gender=" + u_gender + ", u_phone=" + u_phone + ", u_address=" + u_address + "]";
	}
	
	

	}
	