package com.itwill.shop.sql;

public class NoticeSQL {
	//CRUD
	public final static String NOTICE_INSERT=
			"insert into NOTICE(NOTI_NO,NOTI_TITLE,NOTI_CONTENT,NOTI_DATE,NOTI_FILE) values(NOTICE_noti_no_SEQ.nextval,?,?,sysdate,?)";
	public final static String NOTICE_SELECT_ALL=
			"select * from notice order by noti_date desc";
	public final static String NOTICE_SELECT_BY_NO=
			"select noti_no,noti_title,noti_content,noti_date,noti_file from notice where noti_no=?";
	public final static String NOTICE_UPDATE=
			"update notice set NOTI_TITLE=?,NOTI_CONTENT=?,NOTI_FILE=? where NOTI_NO=?";
	public final static String NOTICE_DELETE=
			"delete notice where NOTI_NO=?";
	public final static String NOTICE_SELECT_ALL_COUNT=
			"select count(*) cnt from notice";
	
	
	
}
