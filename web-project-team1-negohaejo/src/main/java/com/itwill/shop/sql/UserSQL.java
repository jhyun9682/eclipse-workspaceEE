package com.itwill.shop.sql;

public class UserSQL {
	/*
	 * 유저 생성(회원가입)
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
	//회원가입
	public static final String  USER_INSERT=
			"insert into userinfo(U_ID,U_PASSWORD,U_NAME,U_BIRTH,U_GENDER,U_PHONE,U_ADDRESS) values (?,?,?,?,?,?,?)";
	//회원 정보
	public static final String USER_SELECT_BY_ID=
			"select * from userinfo where u_id=?";
	//회원삭제
	public static final String USER_REMOVE=
			"delete from userinfo where u_id=?";
	//회원비밀번호변경
	public static final String USER_UPDATE_PASSWORD=
			"update userinfo set u_password=? where u_id=?";
	//회원 정보 변경
	public static final String USER_UPDATE_ALL=
			"update userinfo set u_name=?, u_birth=?, u_gender=?, u_phone=?, u_address=? where u_id=?"; 
	
	public final static String USER_SELECT_BY_ID_COUNT=
			"select count(*) cnt from userinfo where u_id=?";
	public final static String USER_SELECT_ALL=
			"select u_id,u_password,u_name,u_birth,u_gender,u_phone,u_address from userinfo";
}
