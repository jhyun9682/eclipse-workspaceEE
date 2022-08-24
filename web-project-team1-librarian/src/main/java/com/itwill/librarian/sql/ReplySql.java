package com.itwill.librarian.sql;

public class ReplySql {
	
	// 답변 작성
	public final static String REPLY_CREATE = "insert into REPLY(REPLY_NO, REPLY_CONTENT, QNA_NO, MEMBER_NO) values (REPLY_SEQ.nextval, ?, ?, ?)";
	
	public final static String REPLY_UPDATE = "update REPLY set REPLY_CONTENT=? where REPLY_NO=? and MEMBER_NO =?";
	
	public final static String REPLY_DELETE = "DELETE FROM REPLY WHERE REPLY_NO=?";


}
