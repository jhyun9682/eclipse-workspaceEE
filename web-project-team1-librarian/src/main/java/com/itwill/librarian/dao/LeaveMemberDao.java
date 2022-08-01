package com.itwill.librarian.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.itwill.librarian.common.Librarian;
import com.itwill.librarian.domain.LeaveMember;
import com.itwill.librarian.sql.LeaveMemberSql;

public class LeaveMemberDao {
	private DataSource dataSource;
	
	public LeaveMemberDao() {
		this.dataSource = Librarian.getDataSource();
	}
	
	// 회원 삭제
	public int removeMember(int memberNo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(LeaveMemberSql.MEMBER_DELETE);
			pstmt.setInt(1, memberNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return 0;
	}
	
	// 탈퇴회원 추가
	public int addLeaveMember(LeaveMember leaveMember) throws Exception {
		int insertRowCount = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(LeaveMemberSql.LEAVE_MEMBER_INSERT);
			pstmt.setString(1, leaveMember.getMemberId());
			pstmt.setString(2, leaveMember.getMemberOpinion());
			insertRowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return insertRowCount;
	}
	
	// 탈퇴회원 목록 조회
	public ArrayList<LeaveMember> getLeaveMemberList() throws Exception {
		ArrayList<LeaveMember> leaveMemberList = new ArrayList<LeaveMember>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(LeaveMemberSql.LEAVE_MEMBER_LIST);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				leaveMemberList.add(new LeaveMember(rs.getInt("leave_no"), rs.getString("member_id"), rs.getString("member_opinion"), rs.getDate("leave_date")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return leaveMemberList;
	}
	
}
