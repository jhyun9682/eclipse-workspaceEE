package com.itwill.librarian.sql;

public class LoanSql {

	/**
	 * INSERT 도서 대출
	 * @author 유재협
	 * @param memberNo int
	 * @param bookNo String
	 * @return 영향 받은 행 개수
	 */
	public final static String ADD_LOAN = "INSERT INTO LOAN(LOAN_NO, BOOK_NO, MEMBER_NO) VALUES (LOAN_SEQ.nextval, ?, ?)";
	
	/**
	 * UPDATE 대출한 도서를 반납
	 * @author 유재협
	 * @param loanNo int
	 * @return 영향 받은 행 개수
	 */
	public final static String LOAN_RETURN = "UPDATE LOAN SET LOAN_ACCESS = 0, LOAN_RETURN_DATE = SYSDATE "
										   + "WHERE LOAN_NO = ? AND LOAN_ACCESS = 1";
	
	/**
	 * DELETE 반납 기록을 삭제
	 * @author 유재협
	 * @param loanNo int
	 * @return 영향 받은 행 개수
	 */
	public final static String REMOVE_LOAN = "DELETE FROM LOAN WHERE LOAN_NO = ?";
	
	/**
	 * SELECT 읽을 수 있는 대출 도서 목록
	 * @author 유재협
	 * @param memberNo int
	 * @param access int
	 * @return 유저의 도서 대출 목록
	 */
	public final static String LOAN_LIST = "SELECT * FROM LOAN WHERE MEMBER_NO = ? AND LOAN_ACCESS = ? order by LOAN_RETURN_DATE desc, LOAN_REG_DATE desc";
	
	
	/**
	 * SELECT 대출 돼 있는 도서를 대출하는지 검사하는 쿼리
	 * @author 유재협
	 * @param memberNo int
	 * @param bookNo String
	 * @return 의미 없음 중복 대출인지가 중요
	 */
	public final static String GET_LOAN = "SELECT LOAN_NO FROM LOAN WHERE MEMBER_NO = ? "
										+ "AND BOOK_NO = ? AND LOAN_ACCESS = 1";
	
	
	
	
	
}
