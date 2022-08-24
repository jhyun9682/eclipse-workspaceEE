package com.itwill.toy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.itwill.toy.common.DataSourceUtil;
import com.itwill.toy.domain.Member;
import com.itwill.toy.sql.MemberSql;

public class MemberDao {
	private DataSource dataSource;

	public MemberDao() throws Exception {
		this.dataSource = DataSourceUtil.getDataSource();
	}

	/*
	 * 멤버 생성
	 */
	public int create(Member member) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int insertRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.MEMBER_INSERT);
			pstmt.setString(1, member.getM_id());
			pstmt.setString(2, member.getM_password());
			pstmt.setString(3, member.getM_name());
			pstmt.setString(4, member.getM_email());
			pstmt.setString(5, member.getM_birth());
			pstmt.setString(6, member.getM_gender());
			pstmt.setString(7, member.getM_address());
			pstmt.setString(8, member.getM_phone());
			pstmt.setInt(9, member.getM_point());
			insertRowCount = pstmt.executeUpdate();
		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return insertRowCount;
	}

	/*
	 * 멤버 수정
	 */
	public int update(Member member) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int updateRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.MEMBER_UPDATE_ALL);
			pstmt.setString(1, member.getM_password());
			pstmt.setString(2, member.getM_name());
			pstmt.setString(3, member.getM_email());
			pstmt.setString(4, member.getM_address());
			pstmt.setString(5, member.getM_phone());
			pstmt.setString(6, member.getM_id());
			updateRowCount = pstmt.executeUpdate();
			pstmt.close();
			con.close();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}

		return updateRowCount;
	}
	/*
	 * 멤버 비밀번호 수정
	 */

	public int updatePassword(Member member) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int updateRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.MEMBER_UPDATE_PASSWORD);
			pstmt.setString(1, member.getM_password());
			pstmt.setString(2, member.getM_id());
			updateRowCount = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return updateRowCount;
	}

	/*
	 * 멤버 포인트(적립금) 수정
	 */
	public int updatePoint(Member member) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int updateRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.MEMBER_UPDATE_POINT);
			pstmt.setInt(1, member.getM_point());
			pstmt.setString(2, member.getM_id());
			updateRowCount = pstmt.executeUpdate();
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return updateRowCount;
	}

	/*
	 * 멤버 삭제
	 */
	public int remove(String m_id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int removeRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.MEMBER_REMOVE);
			pstmt.setString(1, m_id);
			removeRowCount = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return removeRowCount;
	}

	/*
	 * 멤버 찾기
	 */
	public Member findMember(String M_ID) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member findMember = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.MEMBER_SELECT_BY_ID);
			pstmt.setString(1, M_ID);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				findMember = new Member(rs.getString("m_id"), rs.getString("m_password"), rs.getString("m_name"),
						rs.getString("m_email"), rs.getString("m_birth"), rs.getString("m_gender"),
						rs.getString("m_address"), rs.getString("m_phone"), rs.getInt("m_point"));

			}
		} finally {

		}
		return findMember;
	}

	/*
	 * 모든 멤버 검색
	 */
	public ArrayList<Member> selectAll() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Member> selectAll = new ArrayList<Member>();
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.MEMBER_SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				selectAll.add(new Member(rs.getString("m_id"), rs.getString("m_password"), rs.getString("m_name"),
						rs.getString("m_email"), rs.getString("m_birth"), rs.getString("m_gender"),
						rs.getString("m_address"), rs.getString("m_phone"), rs.getInt("m_point")));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return selectAll;
	}

	/*
	 * 아이디 존재여부 확인
	 */
	public boolean existedMember(String m_id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isExist = false;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(MemberSql.MEMBER_SELECT_BY_ID_COUNT);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			rs.next();
			int count = rs.getInt("cnt");
			if (count == 1) {
				isExist = true;
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return isExist;
	}

}