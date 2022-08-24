package com.itwill.toy.sql;

public class NoticeSql {
	public static final String SELECT_NOTICE_LIST =
			"SELECT *"
			+ "FROM"
			+ "( SELECT rownum idx, s.*"
			+ "FROM"
			+ "( SELECT n_no, n_title, n_writer, n_content, n_date, n_count  FROM notice ORDER BY n_no DESC ) s"
			+ ")"
			+ "WHERE idx >= ? AND idx <= ?";
	public static final String SELECT_NOTICE_DETAIL =
			"select n_no, n_title, n_writer, n_content, n_date, n_count from notice where n_no = ?";
	public static final String UPDATE_READ_COUNT =
			"update notice set n_count = n_count + 1 where n_no = ?";
	public static final String SELECT_NOTICE_COUNT =
			"select count(*) cnt from notice";
	
}
