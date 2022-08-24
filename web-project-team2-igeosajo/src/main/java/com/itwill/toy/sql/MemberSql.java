package com.itwill.toy.sql;

public class MemberSql {
		/*
		M_ID       NOT NULL VARCHAR2(50) 
		M_PASSWORD          VARCHAR2(50) 
		M_NAME              VARCHAR2(50) 
		M_EMAIL             VARCHAR2(50)
		M_BIRTH             VARCHAR2(20) 
		M_GENDER            VARCHAR2(1) 
		M_ADDRESS           VARCHAR2(50)     
		M_PHONE             VARCHAR2(20) 
		M_POINT             NUMBER(10)
		 */	
		   
		//회원 가입
		public static final String  MEMBER_INSERT =
				"insert into member(m_id,m_password,m_name,m_email,m_birth,m_gender,m_address,m_phone,m_point) values (?,?,?,?,?,?,?,?,?)";
		//회원 정보
		public static final String MEMBER_SELECT_BY_ID =
				"select * from member where m_id=?";
		//회원 전체선택
		public static final String MEMBER_SELECT_ALL = 
				"select m_id,m_password,m_name,m_email,m_birth,m_gender,m_address,m_phone,m_point from member";
		//회원 삭제
		public static final String MEMBER_REMOVE =
				"delete from member where m_id=?";
		//회원 비밀번호 수정
		public static final String MEMBER_UPDATE_PASSWORD =
				"update member set m_password=? where m_id=?";
		//회원 정보 수정
		public static final String MEMBER_UPDATE_ALL =
				"update member set m_password=?,m_name = ?, m_email = ?, m_address=?, m_phone=? where m_id=?";
		//회원 아이디 존재 확인
		public static final String MEMBER_SELECT_BY_ID_COUNT =
				"select count(*) cnt from member where m_id = ?";
		//회원 적립금 수정
		public static final String MEMBER_UPDATE_POINT =
		"update member m set m.m_point = ? where m_id = ?";
	
}
