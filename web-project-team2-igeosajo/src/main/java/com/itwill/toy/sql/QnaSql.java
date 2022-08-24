package com.itwill.toy.sql;

public class QnaSql {
	public static final String SELECT_QNA_LIST =
			"SELECT * "
			+ "FROM "
			+ "( SELECT rownum idx, s.* "
			+ "FROM ( SELECT q_no, q_title, m_id, q_date, q_count, q_group_no, q_step, q_depth "
			+ "FROM qna "
			+ "ORDER BY q_group_no DESC, q_step ASC ) s )"
			+ "WHERE idx >= ? AND idx <= ?";
	public static final String INSERT_NEW_QNA =
			"insert into qna(q_no, q_title, q_content, q_date, q_count, q_group_no, q_step, q_depth, m_id) "
			+ "VALUES(QNA_Q_NO_SEQ.nextval, ?, ?, sysdate, 0, QNA_Q_NO_SEQ.currval, 1, 0, ?)";
	public static final String SELECT_QNA =
			"select q_no, q_title, q_content, q_date, q_count, q_group_no, q_step, q_depth, m_id from qna where q_no = ?";
	public static final String INSERT_QNA_REPLY =
			" INSERT INTO qna(q_no, q_title, q_content, q_date, q_count, q_group_no, q_step, q_depth, m_id) "
			+ " VALUES (QNA_Q_NO_SEQ.nextval,?,?,sysdate,0,?,?,?,?)";
	public static final String DELETE_QNA =
			"delete qna where q_no = ?";
	public static final String UPDATE_QNA =
			"update qna set q_title=?, q_content=? where q_no = ?";
	public static final String UPDATE_READ_COUNT =
			"update qna set q_count = q_count+1 where q_no = ?";
	public static final String UPDATE_STEP =
			"update qna set q_step = q_step + 1 where q_step > ? AND q_group_no = ?";
	public static final String SELECT_QNA_ALL_COUNT =
			"select count(*) cnt from qna"; 
	
}
