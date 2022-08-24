package com.itwill.librarian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.itwill.librarian.common.Librarian;
import com.itwill.librarian.domain.Member;
import com.itwill.librarian.sql.MemberSql;

public class MemberDao {
	
	private DataSource dataSource;
	
	public MemberDao() {
		this.dataSource = Librarian.getDataSource();
	}
	
	//회원 번호로 검색
	public Member getMember(int memberNo) throws Exception{
		Member member = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.GET_MEMBER_BY_NO);
			
			pstmt.setInt(1, memberNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member(
						rs.getInt("MEMBER_NO"),
						rs.getString("MEMBER_NAME"),
						rs.getString("MEMBER_ID"),
						rs.getString("MEMBER_PASS"),
						rs.getString("MEMBER_PHONE"),
						rs.getString("MEMBER_EMAIL"),
						rs.getInt("MEMBER_LOAN"),
						rs.getInt("MEMBER_RESERVATION"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		return member;
	}
	
	//회원 ID로 검색
	public Member getMember(String memberId) throws Exception{
		Member member = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.GET_MEMBER_BY_ID);
			
			pstmt.setString(1, memberId);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member(
						rs.getInt("MEMBER_NO"),
						rs.getString("MEMBER_NAME"),
						rs.getString("MEMBER_ID"),
						rs.getString("MEMBER_PASS"),
						rs.getString("MEMBER_PHONE"),
						rs.getString("MEMBER_EMAIL"),
						rs.getInt("MEMBER_LOAN"),
						rs.getInt("MEMBER_RESERVATION"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		return member;
	}

	//회원 가입
	public int addMember(Member newMember) throws Exception{
		int rowCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.ADD_MEMBER);
			
			pstmt.setString(1, newMember.getMemberName());
			pstmt.setString(2, newMember.getMemberId());
			pstmt.setString(3, newMember.getMemberPass());
			pstmt.setString(4, newMember.getMemberPhone());
			pstmt.setString(5, newMember.getMemberEmail());
			
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		return rowCount;
	}
	
	//회원 탈퇴
	public int removeMember(int memberNo) throws Exception{
		int rowCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.REMOVE_MEMBER);
			
			pstmt.setInt(1, memberNo);
			
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		return rowCount;
	}
	
	//회원 정보 수정
	public int modifyMember(Member member) throws Exception{
		int rowCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.MODIFY_MEMBER);
			
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getMemberPass());
			pstmt.setString(3, member.getMemberPhone());
			pstmt.setString(4, member.getMemberEmail());
			pstmt.setInt(5, member.getMemberNo());
			
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		return rowCount;
	}
	
	//회원 대출 증감 (true == 1, false == -1)
	public int modifyMemberLoan(int memberNo, boolean increase) throws Exception{
		int rowCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.MODIFY_MEMBER_LOAN);
			
			pstmt.setInt(1, increase ? 1 : -1);
			pstmt.setInt(2, memberNo);
			
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		return rowCount;
	}
	
	//회원 예약 증감 (true == 1, false == -1)
	public int modifyMemberReservation(int memberNo, boolean increase) throws Exception{
		int rowCount = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.MODIFY_MEMBER_RESERVATION);
			
			pstmt.setInt(1, increase ? 1 : -1);
			pstmt.setInt(2, memberNo);
			
			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		}
		
		return rowCount;
	}
	
}
