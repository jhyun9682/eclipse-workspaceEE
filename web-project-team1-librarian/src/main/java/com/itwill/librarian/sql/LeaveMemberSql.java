package com.itwill.librarian.sql;

public class LeaveMemberSql {
	
	public final static String MEMBER_DELETE = "DELETE FROM MEMBER WHERE MEMBER_NO=?";
	public final static String LEAVE_MEMBER_INSERT = "INSERT INTO LEAVE_MEMBER VALUES(LEAVE_MEMBER_SEQ.nextval, ?, ?, SYSDATE)";
	public final static String LEAVE_MEMBER_LIST = "SELECT * FROM LEAVE_MEMBER";
	
}
