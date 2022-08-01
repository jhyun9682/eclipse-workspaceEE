package com.itwill.librarian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

import javax.sql.DataSource;

import com.itwill.librarian.common.Librarian;
import com.itwill.librarian.domain.Qna;
import com.itwill.librarian.domain.Reply;
import com.itwill.librarian.sql.QnaSql;
import com.itwill.librarian.sql.ReplySql;

public class QnaDao {

	private DataSource dataSource;

	public QnaDao() {
		this.dataSource = Librarian.getDataSource();
	}
	
	/** QNA 전체 리스트 조회
	 *  @return ArrayList<Qna> getQnaList
	 *  @throws Exception
	 */
	public ArrayList<Qna> getQnaList(int start, int last) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Qna> qnas = new ArrayList<Qna>();

		try {
			conn = dataSource.getConnection();
			StringBuffer sql = new StringBuffer(500);
			
			
			sql.append("select * from");
			sql.append("(");
			sql.append("select rownum idx, s.*");
			sql.append("from ");
			
			sql.append("( ");
			sql.append("select ");
			sql.append("qna_no, member_no, qna_title, qna_reg_date, ");
			sql.append("qna_visible, qna_file, qna_views, ");
			sql.append("(select count(*) from reply where qna_no = a.qna_no) ");
			sql.append("from ");
			sql.append("qna a ");
			sql.append("order by qna_no desc");
			
			sql.append(") s ");
			sql.append(")");
			
			sql.append("where idx >= ? and idx <= ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, last);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Qna qna = new Qna();
				qna.setQnaNo(rs.getInt(2));
				qna.setMemberNo(rs.getInt(3));
				qna.setQnaTitle(rs.getString(4));
				qna.setQnaRegDate(rs.getDate(5));
				qna.setQnaVisible(rs.getInt(6));
				qna.setQnaFile(rs.getString(7));
				qna.setQnaViews(rs.getInt(8));
				qna.setQna_reply_count(rs.getInt(9));
				qnas.add(qna);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return qnas;
	}

	/**
	 * QNA 1건 상세 조회
	 * @param qnaNo
	 * @return QNA 1건
	 * @throws Exception
	 */
	public Qna getQnaByNo(int qnaNo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null, rs2 = null;
		Qna qna = null;

		try {
			conn = dataSource.getConnection();
			StringBuffer sql = new StringBuffer(300);
			sql.append("SELECT ");
			sql.append("QNA_NO, MEMBER_NO, QNA_TITLE, QNA_CONTENT, ");
			sql.append("QNA_REG_DATE, QNA_VISIBLE, ");
			sql.append("QNA_FILE, QNA_VIEWS ");
			sql.append("FROM QNA ");
			sql.append("WHERE QNA_NO = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, qnaNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				qna = new Qna();
				qna.setQnaNo(rs.getInt(1));
				qna.setMemberNo(rs.getInt(2));
				qna.setQnaTitle(rs.getString(3));
				qna.setQnaContent(rs.getString(4));
				qna.setQnaRegDate(rs.getDate(5));
				qna.setQnaVisible(rs.getInt(6));
				qna.setQnaFile(rs.getString(7));
				qna.setQnaViews(rs.getInt(8));
				
				sql.delete(0, sql.length());

				sql.append("SELECT REPLY_NO, REPLY_CONTENT, ").append("	   QNA_NO, MEMBER_NO ")
						.append("FROM REPLY ").append("WHERE QNA_NO = ?");
				pstmt2 = conn.prepareStatement(sql.toString());
				pstmt2.setInt(1, qnaNo);
				rs2 = pstmt2.executeQuery();
				ArrayList<Reply> replys = new ArrayList<Reply>();
				while (rs2.next()) {
					Reply reply = new Reply();
					reply.setReplyNo(rs2.getInt(1));
					reply.setReplyContent(rs2.getString(2));
					reply.setQnaNo(rs2.getInt(3));
					reply.setMemberNo(rs2.getInt(4));
					replys.add(reply);
				}
				qna.setReplys(replys);

			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (rs2 != null) rs2.close();
			if (pstmt != null) pstmt.close();
			if (pstmt2 != null) pstmt2.close();
			if (conn != null) conn.close();
		}
		return qna;
	}
	

	/**
	 * QNA 게시물 생성
	 * @param qna
	 * @return
	 * @throws Exception
	 */
	public int addQna(Qna qna) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			conn = dataSource.getConnection();

			pstmt = conn.prepareStatement(QnaSql.QNA_CREATE);
			pstmt.setInt(1, qna.getMemberNo());
			pstmt.setString(2, qna.getQnaTitle());
			pstmt.setString(3, qna.getQnaContent());
			pstmt.setInt(4, qna.getQnaVisible());
			pstmt.setString(5, qna.getQnaFile());

			rowCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		return rowCount;

	}
	
	/**
	 * QNA 공개 유무 QNA_VISIBLE
	 * @param qnaNo
	 * @return QNA_VISIBLE 1 or 0
	 * @throws Exception
	 */
	public int openSettings(int qnaNo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(QnaSql.QNA_SETTINGS);
			pstmt.setInt(1, qnaNo);
			rs = pstmt.executeQuery();
			rs.next();
			count = rs.getInt("QNA_VISIBLE");
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return count;
	}
	
	/**
	 * QNA 게시물 수정
	 * @param qna
	 * @return
	 * @throws Exception
	 */
	public void modifyQna(Qna qna) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(QnaSql.QNA_UPDATE);
			pstmt.setString(1, qna.getQnaTitle());
			pstmt.setInt(2, qna.getQnaVisible());
			pstmt.setString(3, qna.getQnaFile());
			pstmt.setString(4, qna.getQnaContent());
			pstmt.setInt(5, qna.getQnaNo());
			pstmt.setInt(6, qna.getMemberNo());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
				
	}

	/**
	 * QNA 게시물 삭제
	 * @param qnaNo
	 * @return
	 * @throws Exception
	 */
	public void removeQna(int qnaNo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(QnaSql.QNA_DELETE);
			pstmt.setInt(1, qnaNo);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
	}
	
	/**
	 * QNA 1건 조회수 상승
	 * @param qnaNo
	 * @throws Exception
	 */
	public void increaseQnaReadCount(int qnaNo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(QnaSql.QNA_READ_COUNT);
			pstmt.setInt(1, qnaNo);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
	}
	
	/**
	 * QNA 총 갯수 반환
	 * @return
	 */
	public int getQnaCount() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(QnaSql.QNA_COUNT);
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt(1);

		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		}
		return count;
	}
	
	/**
	 * QNA 답변 작성
	 * @param reply
	 * @throws Exception
	 */
	public void addReply(Reply reply) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(ReplySql.REPLY_CREATE);
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getQnaNo());
			pstmt.setInt(3, reply.getMemberNo());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}

	}
	
	/**
	 * QNA 답변 수정
	 * @param reply
	 * @throws Exception
	 */
	public void modifyReply(Reply reply) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(ReplySql.REPLY_UPDATE);
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getReplyNo());
			pstmt.setInt(3, reply.getMemberNo());
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
	}
	
	/**
	 * QNA 답변 삭제
	 * @param replyNo
	 * @throws Exception
	 */
	public void removeReply(int replyNo) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(ReplySql.REPLY_DELETE);
			pstmt.setInt(1, replyNo);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
	}
	
	/**
	 * QNA 검색 페이지
	 * @param keyword
	 * @return 검색결과
	 * @throws Exception
	 */
	public ArrayList<Qna> getQnaListByTitleContent(String keyword, int start, int last) throws Exception {
		ArrayList<Qna> qnaList = new ArrayList<Qna>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(QnaSql.QNA_SERACH_TITLE_COTENT);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			pstmt.setInt(3, start);
			pstmt.setInt(4, last);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Qna qna = new Qna();
				qna.setQnaNo(rs.getInt(2));
				qna.setMemberNo(rs.getInt(3));
				qna.setQnaTitle(rs.getString(4));
				qna.setQnaRegDate(rs.getDate(5));
				qna.setQnaVisible(rs.getInt(6));
				qna.setQnaFile(rs.getString(7));
				qna.setQnaViews(rs.getInt(8));
				qna.setQna_reply_count(rs.getInt(9));
				qnaList.add(qna);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		
		return qnaList;
	}
	
	public int getQnaListByTitleContentCount(String keyword) throws Exception {
		int count = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(QnaSql.QNA_SERACH_TITLE_COTENT_COUNT);
			pstmt.setString(1, "%" + keyword + "%");
			pstmt.setString(2, "%" + keyword + "%");
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		
		return count;
	}
}
