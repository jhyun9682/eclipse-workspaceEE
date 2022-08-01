package com.itwill.librarian.sql;

public class HopeBookSql {
	/**
	 * @author 양태훈
	 * @param hopeNo int
	 * @param memberNo int
	 * @param bookTitle String
	 * @param bookPublisher String
	 * @param bookAuthor String
	 * @return 영향 받은 행 개수
	 */
	//HOPE_BOOK 리스트
	public final static String HOPE_BOOK_LIST = "SELECT * FROM HOPE_BOOK WHERE MEMBER_NO = ?";
	//HOPE_BOOK 상세
	public final static String HOPE_BOOK_LIST_TITLE = "SELECT * FROM HOPE_BOOK WHERE BOOK_TITLE = ?";
	//HOPE_BOOK 생성
	public final static String HOPE_BOOK = "INSERT INTO HOPE_BOOK(HOPE_NO, MEMBER_NO, BOOK_TITLE, "
										 + "BOOK_PUBLISHER, BOOK_AUTHOR)"+ 
										   "VALUES (HOPE_BOOK_SEQ.nextval, ?, ?, ?, ?)";
	//HOPE_BOOK 전체 게시물 수
	public final static String HOPE_BOOK_COUNT = "SELECT COUNT(*) FROM HOPE_BOOK";

}
