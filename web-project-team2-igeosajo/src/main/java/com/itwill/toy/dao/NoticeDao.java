package com.itwill.toy.dao;

import java.sql.*;
import java.util.ArrayList;
import javax.sql.DataSource;

import com.itwill.toy.common.DataSourceUtil;
import com.itwill.toy.domain.Notice;
import com.itwill.toy.sql.NoticeSql;


public class NoticeDao {
	private DataSource dataSource;
	
	public NoticeDao() {
		this.dataSource = DataSourceUtil.getDataSource();
	}
	
	/*
	 * 공지사항 목록 조회
	 */
	public ArrayList<Notice> selectNoticeList(int start, int last) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Notice> noticeList = new ArrayList<Notice>();

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(NoticeSql.SELECT_NOTICE_LIST);
			pstmt.setInt(1, start);
			pstmt.setInt(2, last);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Notice notice = new Notice();
				notice.setN_no(rs.getInt("n_no"));
				notice.setN_title(rs.getString("n_title"));
				notice.setN_writer(rs.getString("n_writer"));
				notice.setN_content(rs.getString("n_content"));
				notice.setN_date(rs.getDate("n_date"));
				notice.setN_count(rs.getInt("n_count"));

				noticeList.add(notice);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return noticeList;
	}
	
	/*
	 * 공지사항 상세 조회
	 */
	public Notice selectNoticeDetail(int noticeNo) throws Exception{
		Notice notice = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(NoticeSql.SELECT_NOTICE_DETAIL);
			pstmt.setInt(1, noticeNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				notice = new Notice();
				notice.setN_title(rs.getString("n_title"));
				notice.setN_writer(rs.getString("n_writer"));
				notice.setN_content(rs.getString("n_content"));
				notice.setN_date(rs.getDate("n_date"));
				notice.setN_count(rs.getInt("n_count"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return notice;
	}
	
	/*
	 * 공지사항 조회수 증가
	 */
	public void updateReadCount(int n_no) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(NoticeSql.UPDATE_READ_COUNT);
			pstmt.setInt(1, n_no);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
	}
	
	/*
	 * 공지사항 총 개수 반환
	 */
	public int selectNoticeCount() throws Exception{
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(NoticeSql.SELECT_NOTICE_COUNT);
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt("cnt");

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception ex) {
			}
		}
		return count;
	}

}
