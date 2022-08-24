package com.itwill.librarian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.itwill.librarian.common.Librarian;
import com.itwill.librarian.domain.Loan;
import com.itwill.librarian.sql.LoanSql;

public class LoanDao {
	
	private DataSource dataSource;
	
	public LoanDao() {
		this.dataSource = Librarian.getDataSource(); 
	}
	
	//유저 한 명의 대출 목록(access = true) or 반납 목록(access = false)
	public ArrayList<Loan> getLoanList(int memberNo, boolean access) throws Exception{
		ArrayList<Loan> loanList = null; 
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			loanList = new ArrayList<Loan>();
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(LoanSql.LOAN_LIST);
			
			pstmt.setInt(1, memberNo);
			/* 
			 * dao에서 access를 boolean으로 했지만 db에서는 number이므로
			 * 인자를 boolean으로 받고 삼항 연산자로 변환해서 사용
			 * 삼항 연산자 = 조건 ? 참일 경우 : 거짓일 경우
			 */
			pstmt.setInt(2, access ? 1 : 0);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				loanList.add(new Loan(
							rs.getInt("LOAN_NO"),
							rs.getInt("MEMBER_NO"),
							rs.getString("BOOK_NO"),
							rs.getDate("LOAN_REG_DATE"),
							rs.getDate("LOAN_RETURN_DATE"),
							rs.getBoolean("LOAN_ACCESS")
						));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		return loanList;
	}
	
	/* 
	 * 도서 대출
	 * 문제점: 대출시 이미 대출이 된 책이면 들어가면 안됨.
	 * DB적으로 할 수 있는 수단을 모르겠음. Service에서 제약을 주어야함.
	 */
	public int addLoan(int memberNo, String bookNo) throws Exception {
		int rowCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(LoanSql.ADD_LOAN);
			
			pstmt.setString(1, bookNo);
			pstmt.setInt(2, memberNo);
			
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		
		return rowCount;
	}
	
	//이미 대출 되어 있는 책인지 검사
	public boolean isExistLoanBook(int memberNo, String bookNo) throws Exception {
		Loan loan = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(LoanSql.GET_LOAN);
			
			pstmt.setInt(1, memberNo);
			pstmt.setString(2, bookNo);
			
			rs = pstmt.executeQuery();
			
			//결과 값이 있다면
			if(rs.next()) {
				//이미 대출 되어 있는 도서임.
				loan = new Loan();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		//loan이 null이면 대출 가능
		return loan == null ? true : false;
	}
	
	/*
	 * 도서 반납
	 * 시간이 경과해서 자동으로 접근 권한이 변경되는 것 또는
	 * 회원이 직접 반납을 하는 것 어느 쪽이든 loanNo을 사용할 수 있음
	 */
	public int modifyLoan(int loanNo) throws Exception {
		int rowCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(LoanSql.LOAN_RETURN);
			
			pstmt.setInt(1, loanNo);
			
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		
		return rowCount;
	}
	
	/* 
	 * 도서 대출 기록 삭제(반납 페이지에서만 사용)
	 * 삭제 버튼을 사용해서만 삭제하기 때문에 loanNo를 이용해서 삭제할 수 있음
	 */
	public int removeLoan(int loanNo) throws Exception {
		int rowCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(LoanSql.REMOVE_LOAN);
			
			pstmt.setInt(1, loanNo);
			
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		
		return rowCount;
	}
	
}
