package com.itwill.librarian.sql;

public class MemberSql {
	
	/**
	 * SELECT 회원 번호로 DTO가져오기
	 * @author 유재협
	 * @param memberNo int
	 * @return 회원 번호에 맞는 회원
	 */
	public final static String GET_MEMBER_BY_NO = "SELECT * FROM MEMBER WHERE MEMBER_NO = ?";
	
	/**
	 * SELECT 회원 ID로 DTO가져오기
	 * @author 유재협
	 * @param memberId String
	 * @return 회원 ID에 맞는 회원
	 */
	public final static String GET_MEMBER_BY_ID = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
	
	/**
	 * DELETE 회원 탈퇴
	 * @author 유재협
	 * @param memberNo int
	 * @return 영향 받은 행 개수
	 */
	public final static String REMOVE_MEMBER = "DELETE FROM MEMBER WHERE MEMBER_NO = ?";
	
	/**
	 * INSERT 회원 가입
	 * @author 유재협
	 * @param memberNo int
 	 * @param memberName String
 	 * @param memberId String
	 * @param memberPass String
	 * @param memberPhone String
	 * @param memberEmail String
	 * @return 영향 받은 행 개수
	 */
	public final static String ADD_MEMBER = "INSERT INTO MEMBER(MEMBER_NO, MEMBER_NAME, MEMBER_ID, "
										  + "                   MEMBER_PASS, MEMBER_PHONE, MEMBER_EMAIL) "
										  + "VALUES (MEMBER_SEQ.nextval, ?, ?, ?, ?, ?)";
	
	/**
	 * UPDATE 회원 수정
	 * @author 유재협
	 * @param memberName String
	 * @param memberPass String
	 * @param memberPhone String
	 * @param memberEmail String
	 * @param memberNo int
	 * @return 영향 받은 행 개수
	 */
	public final static String MODIFY_MEMBER = "UPDATE MEMBER "
											 + "SET MEMBER_NAME = ?, "
											 + "    MEMBER_PASS = ?, "
											 + "    MEMBER_PHONE = ?, "
											 + "    MEMBER_EMAIL = ? "
											 + "WHERE MEMBER_NO = ?";
	
	/**
	 * UPDATE 대출 제약 증감
	 * @author 유재협
	 * @param memberLoan int (1 or -1)
	 * @param memberNo int
	 * @return 영향 받은 행 개수
	 */
	public final static String MODIFY_MEMBER_LOAN =
			"UPDATE MEMBER SET MEMBER_LOAN = MEMBER_LOAN + ? WHERE MEMBER_NO = ?";
	
	
	/**
	 * UPDATE 예약 제약 증감
	 * @author 유재협
	 * @param memberReservation int (1 or -1)
	 * @param memberNo int
	 * @return 영향 받은 행 개수
	 */	
	public final static String MODIFY_MEMBER_RESERVATION =
			"UPDATE MEMBER SET MEMBER_RESERVATION = MEMBER_RESERVATION + ? WHERE MEMBER_NO = ?";
	
}
