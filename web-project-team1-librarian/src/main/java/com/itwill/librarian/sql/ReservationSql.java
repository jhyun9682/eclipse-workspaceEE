package com.itwill.librarian.sql;

public class ReservationSql {

	/**
	 * @return
	 * MEMBER_NO (int), 
	 * BOOK_NO (String), 
	 * RESERVATION_REG_DATE(Date)
	 */
	public final static String RESERVATION_INSERT = "INSERT INTO RESERVATION(MEMBER_NO, BOOK_NO, RESERVATION_REG_DATE) VALUES(?, ?, ?)";
	
	/**
	 * @return
	 * MEMBER_NO (int)
	 */
	public final static String RESERVATION_LIST = "SELECT member_no, R.BOOK_NO, RESERVATION_REG_DATE, B.BOOK_TITLE, B.BOOK_AUTHOR, B.BOOK_PUBLISHER, B.BOOK_CATEGORY, B.BOOK_INFO, B.BOOK_INDEX, B.BOOK_IMAGE_URL FROM RESERVATION R JOIN BOOK B ON B.BOOK_NO = R.BOOK_NO WHERE MEMBER_NO = ?";
	
	/**
	 * @return
	 * MEMBER_NO (int), 
	 * BOOK_NO (String)
	 */
	public final static String RESERVATION_DELETE ="DELETE FROM reservation WHERE member_no=? AND book_no=?";
	
	/**
	 * @return
	 * MEMBER_NO (int)
	 */
	public final static String RESERVATION_DELETEALL ="DELETE FROM reservation WHERE member_no=?";
	
	/**
	 * @return
	 * MEMBER_NO (int)
	 */
	public final static String RESERVATION_COUNT ="SELECT COUNT(*) reserCount FROM reservation where member_no=?";
	
	/**
	 * @return
	 * MEMBER_NO (int)
	 * BOOK_NO (String)
	 */
	public final static String RESERVATION_GET_RESERVATION ="SELECT * from reservation WHERE member_no=? and book_no=?";
	
	
}
