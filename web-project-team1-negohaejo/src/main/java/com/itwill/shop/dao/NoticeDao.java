package com.itwill.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.dto.Notice;
import com.itwill.shop.sql.NoticeSQL;

public class NoticeDao {
	private DataSource dataSource;

	public NoticeDao() throws Exception {
		BasicDataSource basicDataSource = new BasicDataSource();
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/com/itwill/shop/jdbc.properties"));
		basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("username"));
		basicDataSource.setPassword(properties.getProperty("password"));// 프로퍼티파일로 유지보수 확장성 증가 컴파일 불필요
		this.dataSource = basicDataSource;
	}

	public int create(Notice notice) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(NoticeSQL.NOTICE_INSERT);
			pstmt.setString(1, notice.getNoti_title());
			pstmt.setString(2, notice.getNoti_content());
			pstmt.setString(3, notice.getNoti_file());
			result = pstmt.executeUpdate();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		return result;
	}
	
	public int update(Notice notice) throws Exception {
		int result=0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt=con.prepareStatement(NoticeSQL.NOTICE_UPDATE);
			pstmt.setString(1, notice.getNoti_title());
			pstmt.setString(2, notice.getNoti_content());
			pstmt.setString(3, notice.getNoti_file());
			pstmt.setInt(4, notice.getNoti_no());
			result = pstmt.executeUpdate();			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt !=null) pstmt.close();
			if(con!=null) con.close();
		}
		return result;
	}
	
	public int remove(int noti_no) throws Exception{
		int result =0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(NoticeSQL.NOTICE_DELETE);
			pstmt.setInt(1, noti_no);
			result = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
		}
		
		return result;
		
	}
	
	public Notice selectByNo(int noti_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Notice notice = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(NoticeSQL.NOTICE_SELECT_BY_NO);
			pstmt.setInt(1, noti_no);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				notice = new Notice(
						rs.getInt("noti_no"), 
						rs.getString("noti_title"), 
						rs.getString("noti_content"), 
						rs.getDate("noti_date"),
						rs.getString("noti_file"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)	rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		return notice;
	}

	public List<Notice> selectAll() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Notice> noticeList = new ArrayList<Notice>();
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(NoticeSQL.NOTICE_SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				noticeList.add(new Notice(
										rs.getInt("NOTI_NO"), 
										rs.getString("noti_TITLE"), 
										rs.getString("NOTI_CONTENT"),
										rs.getDate("NOTI_DATE"), 
										rs.getString("NOTI_FILE")));
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)	rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		return noticeList;
	}

	public int getNoticeCount() throws Exception{
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con=dataSource.getConnection();
			String sql = "SELECT COUNT(*) FROM notice";
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) count=rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null)con.close();
		}
		return count;
	}
	
	public ArrayList<Notice> findNoticeList(int start, int last) throws Exception{
		System.out.println(""+start+" ~ "+last);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Notice> notices= new ArrayList<Notice>();
		
		try {
			con = dataSource.getConnection();
			StringBuffer sql = new StringBuffer(500);
			sql.append("SELECT * ");
			sql.append("FROM ");
			sql.append("( ");
			sql.append("	SELECT ");
			sql.append("		rownum idx, s.* ");
			sql.append("	FROM ");
			sql.append("	( ");
			sql.append("		SELECT ");
			sql.append("			noti_no, noti_title, noti_content, ");
			sql.append("			noti_date, noti_file");
			sql.append("		FROM ");
			sql.append("			notice ");
			sql.append("	) s ");
			sql.append(") ");
			sql.append("WHERE idx >= ? AND idx <= ? ");

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, last);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Notice notice = new Notice();
				notice.setNoti_no(rs.getInt(2));
				notice.setNoti_title(rs.getString(3));
				notice.setNoti_content(rs.getString(4));
				notice.setNoti_date(rs.getDate(5));
				notice.setNoti_file(rs.getString(6));
				notices.add(notice);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)con.close();
		}
		return notices;
	}

}