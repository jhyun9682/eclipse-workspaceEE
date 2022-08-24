package com.itwill.librarian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.itwill.librarian.common.Librarian;
import com.itwill.librarian.domain.Favorite;
import com.itwill.librarian.sql.FavoriteSql;
import com.itwill.librarian.sql.ReservationSql;

public class FavoriteDao {

	private DataSource dataSource;
	
	public FavoriteDao() {
		this.dataSource = Librarian.getDataSource();
	}
	/*
	 * 관심 도서 추가
	 */
	public int addFavorite(Favorite favorite) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int insertRowCount=0;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(FavoriteSql.FAVORITE_INSERT);
			pstmt.setInt(1, favorite.getMemberNo());
			pstmt.setString(2, favorite.getBookNo());
			insertRowCount = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			if (pstmt!=null) pstmt.close();
			if (con!=null) con.close();
			
		}
		return insertRowCount;
	}
	
	/*
	 * -- 멤버 3번의 관심도서 목록 
	 * select B.BOOK_NO, BOOK_TITLE, BOOK_AUTHOR, BOOK_CATEGORY,
	 * 		  BOOK_HOLDINGS, BOOK_LOAN, BOOK_RESERVATION, BOOK_IMAGE_URL 
	 * from FAVORITE F
	 * join BOOK B on F.BOOK_NO = B.BOOK_NO 
	 * where F.MEMBER_NO = 3;
	 */
	
	public ArrayList<Favorite> getFavoriteList(int memberNo) throws Exception{
		ArrayList<Favorite> favoriteList = new ArrayList<Favorite>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(FavoriteSql.FAVORITE_LIST);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				favoriteList.add(new Favorite(rs.getInt("member_no"),
											  rs.getString("book_no")));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
			
		}
		
		return favoriteList;
	}
	// 관심 도서 1개 삭제
	public int removeFavorite(Favorite favorite) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int removeRowCount=0;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(FavoriteSql.FAVORITE_DELETE);
			pstmt.setInt(1, favorite.getMemberNo());
			pstmt.setString(2, favorite.getBookNo());
			removeRowCount = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			if (pstmt!=null) pstmt.close();
			if (con!=null) con.close();
			
		}
		
		return removeRowCount;
	}
	
	// 관심 도서 전체 삭제
	public int removeAllFavorite(int memberNo) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int removeAllRowCount=0;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(FavoriteSql.FAVORITE_DELETE);
			pstmt.setInt(1, memberNo);
			removeAllRowCount = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			if (pstmt!=null) pstmt.close();
			if (con!=null) con.close();
			
		}
		
		return removeAllRowCount;
	}
	
	/*
	 * 회원 1 명의 관심 도서 수
	 */
	public int getFavoriteCount(int memberNo) throws Exception{
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(FavoriteSql.FAVORITE_COUNT);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("favorCount");
			
			}
		}catch (Exception e) {
				e.printStackTrace();
 
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		return count;
	}
	
}