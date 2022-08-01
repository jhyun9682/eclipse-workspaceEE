package com.itwill.librarian.sql;

public class FaqSql {
	//FAQ 리스트
	public final static String FAQ_LIST = "select * from faq";
	//fAQ 상세
	public final static String FAQ_LIST_NO = "select * from faq where faq_no = ?";
	public final static String FAQ_COUNT = "SELECT COUNT(*) FROM FAQ";
}