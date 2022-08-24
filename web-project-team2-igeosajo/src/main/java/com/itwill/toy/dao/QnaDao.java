package com.itwill.toy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.itwill.toy.common.DataSourceUtil;
import com.itwill.toy.domain.Qna;
import com.itwill.toy.sql.QnaSql;

public class QnaDao {

	private DataSource dataSource;

	public QnaDao() {
		this.dataSource = DataSourceUtil.getDataSource();
	}

	/**
	 * 새로운 게시물을 추가하는 메써드.
	 */
	public int insertNewQna(Qna qna) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(QnaSql.INSERT_NEW_QNA);
			pstmt.setString(1, qna.getQ_title());
			pstmt.setString(2, qna.getQ_content());
			pstmt.setString(3, qna.getM_id());
			int result = pstmt.executeUpdate();
			return result;
		} finally {
			con.close();
		}

	}

	/**
	 * 게시물 번호에 해당하는 게시물 정보를 반환하는 메써드.
	 */
	public Qna selectQna(int q_no) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Qna qna = null;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(QnaSql.SELECT_QNA);
			pstmt.setInt(1, q_no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				qna = new Qna();
				qna.setQ_no(rs.getInt("q_no"));
				qna.setQ_title(rs.getString("q_title"));
				qna.setQ_content(rs.getString("q_content"));
				qna.setQ_date(rs.getDate("q_date"));
				qna.setQ_count(rs.getInt("q_count"));
				qna.setQ_group_no(rs.getInt("q_group_no"));
				qna.setQ_step(rs.getInt("q_step"));
				qna.setQ_depth(rs.getInt("q_depth"));
				qna.setM_id(rs.getString("m_id"));
			}
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
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		return qna;

	}

	/**
	 * 답글 게시물을 추가하는 메써드
	 */
	public int insertReply(Qna qna) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			// 댓글을 작성할 대상글(원글)의 정보를 조회
			Qna temp = this.selectQna(qna.getQ_no());

			// 영향을 받는 기존 글들의 논리적인 순서 번호 변경
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(QnaSql.UPDATE_STEP);
			pstmt.setInt(1, temp.getQ_step());// step 번호
			pstmt.setInt(2, temp.getQ_group_no());// group 번호
			pstmt.executeUpdate();
			pstmt.close();

			// 댓글 삽입
			pstmt = con.prepareStatement(QnaSql.INSERT_QNA_REPLY);
			pstmt.setString(1, qna.getQ_title());// 제목
			pstmt.setString(2, qna.getQ_content());// 내용
			pstmt.setInt(3, temp.getQ_group_no());// group no
			pstmt.setInt(4, temp.getQ_step() + 1);// step
			pstmt.setInt(5, temp.getQ_depth() + 1);// depth
			pstmt.setString(6, qna.getM_id());// 작성자

			count = pstmt.executeUpdate();

		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		return count;

	}

	/**
	 * 게시물 리스트를 반환(게시물시작번호,게시물끝번호)
	 */
	public ArrayList<Qna> selectBoardList(int start, int last) throws Exception {
		System.out.println("" + start + " ~ " + last);
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Qna> qnaList = new ArrayList<Qna>();

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(QnaSql.SELECT_QNA_LIST);
			pstmt.setInt(1, start);
			pstmt.setInt(2, last);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				Qna qna = new Qna();
				qna.setQ_no(rs.getInt("q_no"));
				qna.setQ_title(rs.getString("q_title"));
				qna.setM_id(rs.getString("m_id"));
				qna.setQ_date(rs.getDate("q_date"));
				qna.setQ_count(rs.getInt("q_count"));
				qna.setQ_group_no(rs.getInt("q_group_no"));
				qna.setQ_step(rs.getInt("q_step"));
				qna.setQ_depth(rs.getInt("q_depth"));

				qnaList.add(qna);
			}
		} finally {
			if (pstmt != null)
				try {
					pstmt.close();
				} catch (Exception ex) {
				}
			if (con != null)
				try {
					con.close();
				} catch (Exception ex) {
				}
		}
		return qnaList;
	}

	/**
	 * 게시물을 삭제하는 메써드
	 */
	public int deleteQna(int q_no) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = dataSource.getConnection();

			pstmt = con.prepareStatement(QnaSql.DELETE_QNA);
			pstmt.setInt(1, q_no);
			count = pstmt.executeUpdate();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
			}
			try {
				if (con != null)
					con.close();
				;
			} catch (Exception ex) {
			}
		}
		return count;

	}

	/**
	 * 게시물내용을 수정하는 메써드.
	 */
	public int updateQna(Qna qna) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int count = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(QnaSql.UPDATE_QNA);
			pstmt.setString(1, qna.getQ_title());
			pstmt.setString(2, qna.getQ_content());
			pstmt.setInt(3, qna.getQ_no());
			count = pstmt.executeUpdate();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
			}
			try {
				if (con != null)
					con.close();
				;
			} catch (Exception ex) {

			}
		}
		return count;
	}

	/**
	 * 게시물 조회수를 1 증가.
	 */
	public void updateReadCount(int q_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(QnaSql.UPDATE_READ_COUNT);
			pstmt.setInt(1, q_no);
			pstmt.executeUpdate();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
	}

	/**
	 * 게시물 총 건수를 조회, 반환
	 */
	public int selectQnaCount() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(QnaSql.SELECT_QNA_ALL_COUNT);
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
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		return count;
	}
}
