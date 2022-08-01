package com.itwill.librarian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.itwill.librarian.common.Librarian;
import com.itwill.librarian.domain.HopeBook;
import com.itwill.librarian.sql.HopeBookSql;

public class HopeBookDao {
	private DataSource dataSource;

	public HopeBookDao() {
		this.dataSource = Librarian.getDataSource();
	}
	
	/**
	 * 
	 * @return ArrayList<HopeBook> getHopeBookList
	 * @throws Exception
	 */
	//HopeBook 전체 리스트
	public ArrayList<HopeBook> getHopeBookList(int memberNo) throws Exception {
		ArrayList<HopeBook> hopeBookList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			hopeBookList = new ArrayList<HopeBook>();
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(HopeBookSql.HOPE_BOOK_LIST);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				hopeBookList.add(new HopeBook(rs.getInt("HOPE_NO"),
											  rs.getInt("MEMBER_NO"),
											  rs.getString("BOOK_TITLE"),
											  rs.getString("BOOK_PUBLISHER"),
											  rs.getString("BOOK_AUTHOR"),
											  rs.getInt("IB_STATUS"),
											  rs.getDate("HOPE_REG_DATE")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		
		return hopeBookList;
	}
	
	/**
	 * HopeBook 1건 상세조회
	 * @param bookTitle
	 * @return HopeBook 1건
	 * @throws Exception
	 */
	public HopeBook getHopeByBookTitle(String bookTitle) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		HopeBook hopeBook = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(HopeBookSql.HOPE_BOOK_LIST_TITLE);
			pstmt.setString(3, bookTitle);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				hopeBook = new HopeBook();
				hopeBook.setHopeNO(rs.getInt(1));
				hopeBook.setMemberNo(rs.getInt(2));
				hopeBook.setBookTitle(rs.getString(3));
				hopeBook.setPublisher(rs.getString(4));
				hopeBook.setAuthor(rs.getString(5));
				hopeBook.setIbStatus(rs.getInt(6));
				hopeBook.setHopeRegDate(rs.getDate(7));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}
		return hopeBook;
	}
	/**
	 * 희망도서 생성
	 * @param hopeBook
	 * @return 영향받은 행 개수
	 * @throws Exception
	 */
	 
	public int addHopeBook(HopeBook hopeBook) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		
		try {
			conn = dataSource.getConnection();
			
			pstmt = conn.prepareStatement(HopeBookSql.HOPE_BOOK);
			pstmt.setInt(1, hopeBook.getMemberNo());
			pstmt.setString(2, hopeBook.getBookTitle());
			pstmt.setString(3, hopeBook.getPublisher());
			pstmt.setString(4, hopeBook.getAuthor());
			
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return rowCount;
	}
	
	//HopeBook 총 개수 반환
	public int getHopeBookCount() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(HopeBookSql.HOPE_BOOK_COUNT);
			rs = pstmt.executeQuery();
			
			if(rs.next())
				count = rs.getInt(1);
		}finally {
			if(rs != null) rs.close();
			if(pstmt != null) rs.close();
			if(conn != null) rs.close();
	}
		return count;
	}
	
}