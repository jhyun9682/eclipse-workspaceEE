package com.itwill.librarian.sql;

public class BookSql {

	/*
	 * 전체 속성 리스트
	 * String BOOK_NO
	 * String BOOK_TITLE
	 * String BOOK_AUTHOR
	 * String BOOK_INFO
	 * String BOOK_CATEGORY
	 * String BOOK_IMAGE_URL
	 * String BOOK_INDEX
	 * String BOOK_PUBLISHER
	 * Date BOOK_YOP
	 * int BOOK_HOLDINGS
	 * int BOOK_LOAN
	 * int BOOK_RESERVATION
	 */
	
	/**
	 * 책 전체 리스트와 각 전체 속성을 조회
	 * @return Book
	 */
	public final static String BOOK_LIST = "select book_no, book_title, book_category, book_author, book_publisher, book_yop, book_info, book_index, book_image_url, book_holdings, book_loan, book_reservation from book";
	
	
	public final static String BOOK_LIST_PAGE = "select * from (select rownum idx, s.* from (select * from book order by BOOK_TITLE) s) where idx >= ? and idx <= ?";
	
	/**
	 * 책 번호로 조회
	 * @param String BOOK_NO
	 * @return Book
	 */
	public final static String BOOK_SEARCH_NO = "select * from book where book_no = ?";

	/**
	 * 통합 검색 (제목, 저자, 출판사)
	 * 하나의 검색어로 제목, 저자, 출판사 모두 조회
	 * @param String 검색어
	 * @return Book
	 */
	public final static String BOOK_SEARCH_ALL = 
			"select * from book where BOOK_TITLE like ? or BOOK_AUTHOR like ? or BOOK_PUBLISHER like ?"; 
	
	public final static String BOOK_SEARCH_ALL_LIST = "select * from (select rownum idx, s.* from (select * from book where BOOK_TITLE like ? or BOOK_AUTHOR like ? or BOOK_PUBLISHER like ? order by BOOK_TITLE) s) where idx >= ? and idx <= ?"; 

	/**
	 * 제목 검색
	 * @param String BOOK_TITLE
	 * @return Book
	 */
	public final static String BOOK_SEARCH_TITLE = "select * from book where BOOK_TITLE like ?"; 
	
	public final static String BOOK_SEARCH_TITLE_LIST = "select * from (select rownum idx, s.* from (select * from book where BOOK_TITLE like ? order by BOOK_TITLE) s) where idx >= ? and idx <= ?"; 
	/**
	 * 저자 검색
	 * @param String BOOK_AUTHOR
	 * @return Book
	 */
	public final static String BOOK_SEARCH_AUTHOR = "select * from book where BOOK_AUTHOR like ?"; 
	
	public final static String BOOK_SEARCH_AUTHOR_LIST = "select * from (select rownum idx, s.* from (select * from book where BOOK_AUTHOR like ? order by BOOK_TITLE) s) where idx >= ? and idx <= ?"; 
	/**
	 * 출판사 검색
	 * @param String BOOK_PUBLISHER
	 * @return Book
	 */
	public final static String BOOK_SEARCH_PUBLISHER = "select * from book where BOOK_PUBLISHER like ?"; 
	
	public final static String BOOK_SEARCH_PUBLISHER_LIST = "select * from (select rownum idx, s.* from (select * from book where BOOK_PUBLISHER like ? order by BOOK_TITLE) s) where idx >= ? and idx <= ?"; 
	/**
	 * 카테고리 검색
	 * @param String BOOK_CATEGORY
	 * @return Book
	 */
	public final static String BOOK_SEARCH_CATEGORY = "select * from book where BOOK_CATEGORY like ?"; 
	
	public final static String BOOK_SEARCH_CATEGORY_LIST = "select * from (select rownum idx, s.* from (select * from book where BOOK_CATEGORY like ? order by BOOK_TITLE) s) where idx >= ? and idx <= ?"; 
	/**
	 * 책 추가 (대출 수와 예약 수는 기본값 이용)
	 * @param String BOOK_NO
	 * @param String BOOK_TITLE
	 * @param String BOOK_AUTHOR
	 * @param String BOOK_INFO
	 * @param String BOOK_CATEGORY
	 * @param String BOOK_IMAGE_URL
	 * @param String BOOK_INDEX
	 * @param String BOOK_PUBLISHER
	 * @param Date BOOK_YOP
	 * @param String BOOK_HOLDINGS
	 */
	public final static String BOOK_INSERT = "insert into BOOK(BOOK_NO, BOOK_TITLE, BOOK_AUTHOR, BOOK_INFO, BOOK_CATEGORY, BOOK_IMAGE_URL, BOOK_INDEX, BOOK_PUBLISHER, BOOK_YOP, BOOK_HOLDINGS) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; 
	
	/**
	 * 책 수정
	 * @param String BOOK_TITLE
	 * @param String BOOK_CATEGORY
	 * @param String BOOK_AUTHOR
	 * @param String BOOK_PUBLISHER
	 * @param Date BOOK_YOP
	 * @param String BOOK_INFO
	 * @param String BOOK_INDEX
	 * @param String BOOK_IMAGE_URL
	 * @param String BOOK_BOOK_NO
	 */
	public final static String BOOK_UPDATE= "UPDATE BOOK SET BOOK_TITLE = ?, BOOK_CATEGORY = ?, BOOK_AUTHOR = ?, BOOK_PUBLISHER = ?, BOOK_YOP = ?, BOOK_INFO = ?, BOOK_INDEX = ?, BOOK_IMAGE_URL = ? WHERE BOOK_NO = ?"; 
	
	/**
	 * 책 1권의 대출 증가
	 * @param String BOOK_NO
	 */
	public final static String BOOK_ADD_LOAN = "update BOOK set BOOK_LOAN = BOOK_LOAN + 1 where BOOK_NO = ?"; 
	
	/**
	 * 책 1권의 대출 감소
	 * @param String BOOK_NO
	 */
	public final static String BOOK_SUB_LOAN = "update BOOK set BOOK_LOAN = BOOK_LOAN - 1 where BOOK_NO = ?"; 
	
	/**
	 * 책 1권의 예약 증가
	 * @param String BOOK_NO
	 */
	public final static String BOOK_ADD_RESERVATION = "UPDATE BOOK SET BOOK_RESERVATION = BOOK_RESERVATION + 1 WHERE BOOK_NO = ?"; 
	
	/**
	 * 책 1권의 예약 감소
	 * @param String BOOK_NO
	 */
	public final static String BOOK_SUB_RESERVATION = "UPDATE BOOK SET BOOK_RESERVATION = BOOK_RESERVATION - 1 WHERE BOOK_NO = ?"; 
	
	/**
	 * 책 번호로 책 삭제
	 * @param String BOOK_NO
	 */
	public final static String BOOK_DELETE = "delete from BOOK where BOOK_NO = ?"; 
	
}
