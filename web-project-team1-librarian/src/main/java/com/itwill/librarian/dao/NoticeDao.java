package com.itwill.librarian.dao;

import java.sql.*;
import java.util.ArrayList;
import javax.sql.DataSource;

import com.itwill.librarian.common.Librarian;
import com.itwill.librarian.domain.Notice;
import com.itwill.librarian.sql.NoticeSql;
import com.itwill.librarian.sql.QnaSql;

public class NoticeDao {
	private DataSource dataSource;
	
	public NoticeDao() {
		this.dataSource = Librarian.getDataSource();
	}
	
	// 공지사항 목록 조회
	public ArrayList<Notice> getNoticeList(int start, int last) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<Notice> noticeList = new ArrayList<Notice>();

		try {
			conn = dataSource.getConnection();
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT * ");
			sql.append("FROM ");
			sql.append("( ");
			sql.append("	SELECT ");
			sql.append("		rownum idx, s.* ");
			sql.append("	FROM ");

			sql.append("	( ");
			sql.append("		SELECT ");
			sql.append("			notice_no, notice_title, notice_content, ");
			sql.append("			notice_reg_date, notice_file, notice_views ");
			sql.append("		FROM ");
			sql.append("			notice ");
			sql.append("		ORDER BY notice_no DESC ");
			sql.append("	) s ");

			sql.append(") ");
			sql.append("WHERE idx >= ? AND idx <= ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, last);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Notice notice = new Notice();
				notice.setNoticeNo(rs.getInt(2));
				notice.setNoticeTitle(rs.getString(3));
				notice.setNoticeContent(rs.getString(4));
				notice.setNoticeRegDate(rs.getDate(5));
				notice.setNoticeFile(rs.getString(6));
				notice.setNoticeViews(rs.getInt(7));

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
	public ArrayList<Notice> getNoticeList(int start, int last) throws Exception {
		ArrayList<Notice> noticeList = new ArrayList<Notice>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(NoticeSql.NOTICE_LIST);
			pstmt.setInt(1, start);
			pstmt.setInt(2, last);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				noticeList.add(new Notice(rs.getInt("notice_no"), rs.getString("notice_title"), rs.getString("notice_content"), rs.getDate("notice_reg_date"), rs.getString("notice_file"), rs.getInt("notice_views")));
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
	 */
	
	// 공지사항 상세 조회
	public Notice getNoticeDetail(int noticeNo) throws Exception{
		Notice notice = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(NoticeSql.NOTICE_DETAIL);
			pstmt.setInt(1, noticeNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				notice = new Notice(rs.getString("notice_title"), rs.getString("notice_content"), rs.getDate("notice_reg_date"), rs.getString("notice_file"));
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
	
	// 공지사항 추가
	public int addNotice(Notice notice) throws Exception {
		int insertRowCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(NoticeSql.NOTICE_INSERT);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setString(3, notice.getNoticeFile());
			insertRowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return insertRowCount;
	}
	
	// 공지사항 수정
	public int modifyNotice(Notice notice) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(NoticeSql.NOTICE_UPDATE);
			pstmt.setString(1, notice.getNoticeTitle());
			pstmt.setString(2, notice.getNoticeContent());
			pstmt.setString(3, notice.getNoticeFile());
			pstmt.setInt(4, notice.getNoticeNo());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return 0;
	}
	
	// 공지사항 삭제
	public int removeNotice(int noticeNo) throws Exception {
		int removeRowCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(NoticeSql.NOTICE_DELETE);
			pstmt.setInt(1, noticeNo);
			removeRowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return removeRowCount;
	}
	
	// 공지사항 조회수 증가
	public void increaseNoticeReadCount(int noticeNo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(NoticeSql.NOTICE_READ_COUNT);
			pstmt.setInt(1, noticeNo);
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
	public int getNoticeCount() throws Exception{
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM NOTICE");
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt(1);

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
