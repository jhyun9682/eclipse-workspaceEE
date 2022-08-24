package com.itwill.toy.domain;

public class Member {
	private String m_id;
	private String m_password;
	private String m_name;
	private String m_email;
	private String m_birth;
	private String m_gender;
	private String m_address;
	private String m_phone;
	private int m_point;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}

	public Member(String m_id, String m_password, String m_name, String m_email, String m_birth, String m_gender,
			String m_address, String m_phone, int m_point) {
		super();
		this.m_id = m_id;
		this.m_password = m_password;
		this.m_name = m_name;
		this.m_email = m_email;
		this.m_birth = m_birth;
		this.m_gender = m_gender;
		this.m_address = m_address;
		this.m_phone = m_phone;
		this.m_point = m_point;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_password() {
		return m_password;
	}

	public void setM_password(String m_password) {
		this.m_password = m_password;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_email() {
		return m_email;
	}

	public void setM_email(String m_email) {
		this.m_email = m_email;
	}

	public String getM_birth() {
		return m_birth;
	}

	public void setM_birth(String m_birth) {
		this.m_birth = m_birth;
	}

	public String getM_gender() {
		return m_gender;
	}

	public void setM_gender(String m_gender) {
		this.m_gender = m_gender;
	}

	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public String getM_phone() {
		return m_phone;
	}

	public void setM_phone(String m_phone) {
		this.m_phone = m_phone;
	}

	public int getM_point() {
		return m_point;
	}

	public void setM_point(int m_point) {
		this.m_point = m_point;
	}

	@Override
	public String toString() {
		return "Member [m_id=" + m_id + ", m_password=" + m_password + ", m_name=" + m_name + ", m_email=" + m_email
				+ ", m_birth=" + m_birth + ", m_gender=" + m_gender + ", m_address=" + m_address + ", m_phone="
				+ m_phone + ", m_point=" + m_point + "]";
	}
	
	

}
