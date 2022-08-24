package com.mybatis3.dao.jdbc;

public class StudentSQL {
	public static final String SELECT_STUDENT_LIST =
			"select * from students";
	public static final String SELECT_STUDENT_BY_STUD_ID =
			"select * from students where stud_id=?";
	public static final String INSERT_STUDENT = 
			"INSERT INTO STUDENTS(STUD_ID,NAME,EMAIL,DOB) VALUES(STUDENTS_STUD_ID_SEQ.nextval,?,?,?)";
	public static final String UPDATE_STUDENT = 
			"UPDATE STUDENTS SET NAME=?,EMAIL=?,DOB=? WHERE STUD_ID=?";
}
