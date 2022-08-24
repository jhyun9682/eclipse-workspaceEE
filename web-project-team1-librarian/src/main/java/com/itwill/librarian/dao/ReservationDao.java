package com.itwill.librarian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

import javax.sql.DataSource;

import com.itwill.librarian.common.Librarian;
import com.itwill.librarian.domain.Reservation;
import com.itwill.librarian.sql.LoanSql;
import com.itwill.librarian.sql.ReservationSql;

public class ReservationDao {

	private DataSource dataSource;
	
	public ReservationDao() {
		// TODO Auto-generated constructor stub
		this.dataSource = Librarian.getDataSource();
	}	
	
	//예약 생성
	public int addReservation(Reservation reservation) throws Exception{
		//int memberNo, String bookNo, Date reservationRegDate

		Connection con = null;
		PreparedStatement pstmt = null;
		int insertRowCount=0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ReservationSql.RESERVATION_INSERT);
			pstmt.setInt(1, reservation.getMemberNo());
			pstmt.setString(2, reservation.getBookNo());
			pstmt.setDate(3, reservation.getReservationRegDate() != null ? 
                    new Date(reservation.getReservationRegDate().getTime()) : new Date(System.currentTimeMillis()));
			insertRowCount = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			// TODO: handle finally clause
			if (pstmt !=null) pstmt.close();
			if (con!=null) con.close();
			
			
		}
		return insertRowCount;
	}
	
	//예약 삭제
	public int removeReservation(Reservation reservation) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int deleteRowCount=0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ReservationSql.RESERVATION_DELETE);
			pstmt.setInt(1, reservation.getMemberNo());
			pstmt.setString(2, reservation.getBookNo());
			deleteRowCount = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			// TODO: handle finally clause
			if (pstmt !=null) pstmt.close();
			if (con!=null) con.close();
			
			
		}
		
		
		return deleteRowCount;
	}
	
	//예약 전체 삭제
	public int removeAllReservation(int memberNo) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int deleteAllRowCount=0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ReservationSql.RESERVATION_DELETEALL);
			pstmt.setInt(1, memberNo);
			deleteAllRowCount = pstmt.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			// TODO: handle finally clause
			if (pstmt !=null) pstmt.close();
			if (con!=null) con.close();
			
			
		}
		
		
		return deleteAllRowCount;
	}

	
	//RESERVATION_LIST 예약 리스트(member_no로 찾기)
	
	public ArrayList<Reservation> getReservationList(int memberNo) throws Exception{
		ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ReservationSql.RESERVATION_LIST);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			// int memberNo, String bookNo, Date reservationRegDate
			while (rs.next()) {
				reservationList.add(new Reservation(rs.getInt("member_no"), 
													rs.getString("book_no"),
													rs.getDate("RESERVATION_REG_DATE")));
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();

		}

		return reservationList;
	}
	
	/*
	 * 회원 1명의 예약 도서 개수
	 */
	public int getreservationCount(int memberNo) throws Exception{
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ReservationSql.RESERVATION_COUNT);
			pstmt.setInt(1, memberNo);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("reserCount");
			
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
	
	/*
	 * 이미 예약된 책인지 검사
	 */
	public boolean isExistReservationBook(Reservation reservation) throws Exception{
		boolean isExist = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ReservationSql.RESERVATION_GET_RESERVATION);
			
			pstmt.setInt(1, reservation.getMemberNo());
			pstmt.setString(2, reservation.getBookNo());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				isExist = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		return isExist;
	}
	
}









