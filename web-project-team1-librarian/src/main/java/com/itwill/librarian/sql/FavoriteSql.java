package com.itwill.librarian.sql;

public class FavoriteSql {

	/**
	 * @param 
	 * ?, ? int 1개, String 1개 
	 * @return
	 * MEMBER_NO (int),
	 * BOOK_NO	(String)
	 */
	public final static String FAVORITE_INSERT = "INSERT INTO favorite(member_no, book_no) VALUES (?, ?)";
	
	/**
	 * @param 
	 * ? int 1개
	 * @return
	 * MEMBER_NO (int)
	 */
	public final static String FAVORITE_LIST = "select MEMBER_NO, B.BOOK_NO, BOOK_TITLE, BOOK_AUTHOR, BOOK_CATEGORY, BOOK_HOLDINGS, BOOK_LOAN, BOOK_RESERVATION, BOOK_IMAGE_URL  from FAVORITE F join BOOK B on F.BOOK_NO = B.BOOK_NO where F.MEMBER_NO = ?";
	
	/**
	 * @param 
	 * ? String 1개 
	 * @return
	 * MEMBER_NO (int)
	 * BOOK_NO	(String)
	 */
	public final static String FAVORITE_DELETE = "DELETE FROM FAVORITE WHERE MEMBER_NO=? AND BOOK_NO=?";
	
	/**
	 * @param 
	 * ? String 1개 
	 * @return
	 * MEMBER_NO (int)
	 */
	public final static String FAVORITE_DELETEAll = "DELETE FROM FAVORITE WHERE MEMBER_NO=?";
	
	/**
	 * @return
	 * MEMBER_NO (int)
	 */
	public final static String FAVORITE_COUNT = "SELECT COUNT(*) favorCount FROM favorite where member_no=?";
	
	
}
