package com.itwill.librarian.sql;

public class QnaSql {

	// QNA 리스트
	public final static String QNA_LIST = "select * from\r\n"
			+ "(\r\n"
			+ "select rownum idx, s.* from(\r\n"
			+ "select qna_no, qna_title, qna_reg_date, qna_visible, qna_file, qna_views, \r\n"
			+ "(select count(*) from reply where qna_no = a.qna_no) from qna a\r\n"
			+ "order by qna_no desc) s\r\n"
			+ ")\r\n"
			+ "\r\n"
			+ "where idx >= 0 and idx <= 30 ";

	// QNA 상세
	public final static String QNA_LIST_NO = "select * from qna where qna_no = ?";

	// QNA 생성
	public final static String QNA_CREATE = "insert into QNA(QNA_NO,MEMBER_NO,QNA_TITLE,QNA_CONTENT,QNA_REG_DATE,QNA_VISIBLE,QNA_FILE,QNA_VIEWS) VALUES(QNA_SEQ.nextval,?,?,?,sysdate,?,?,0)";

	// QNA 수정
	public final static String QNA_UPDATE = "UPDATE QNA SET qna_title = ?, qna_visible = ?, qna_file = ?,  qna_content = ? where QNA_NO = ? and MEMBER_NO = ?";
	
	// QNA 삭제
	public final static String QNA_DELETE = "DELETE FROM QNA WHERE QNA_NO = ?";
	
	// QNA 조회수 증가
	public final static String QNA_READ_COUNT = "UPDATE QNA SET QNA_VIEWS = QNA_VIEWS + 1 where QNA_NO = ?";

	// QNA 전체 게시물 수
	public final static String QNA_COUNT = "SELECT COUNT(*) FROM QNA";
	
	// QNA 공개 여부
	public final static String QNA_SETTINGS = "SELECT QNA_VISIBLE FROM QNA WHERE QNA_NO = ?";
	
	// QNA 제목+내용 검색
	public final static String QNA_SERACH_TITLE_COTENT = "select * from (select rownum idx, s.* from (select qna_no, member_no, qna_title, qna_reg_date, qna_visible, qna_file, qna_views, (select count(*) from reply where QNA_NO = a.qna_no) from qna a where QNA_TITLE like ? or QNA_CONTENT like ? order by QNA_NO desc) s) where idx >= ? and idx <= ?";
			
	public final static String QNA_SERACH_TITLE_COTENT_COUNT = "select count(*) from QNA where QNA_TITLE like ? or QNA_CONTENT like ? order by QNA_NO desc";
	
}
