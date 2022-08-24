package com.itwill.librarian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.sql.DataSource;
import com.itwill.librarian.common.Librarian;
import com.itwill.librarian.domain.Faq;
import com.itwill.librarian.sql.FaqSql;

public class FaqDao {

	private DataSource dataSource;

	public FaqDao() {
		this.dataSource = Librarian.getDataSource();
	}
	/**
	 * FAQ 전체 리스트
	 * @param strat
	 * @param last
	 * @return ArrayList<Faq> getFaqList
	 * @throws Exception
	 */
	public ArrayList<Faq> getFaqList(int strat, int last) throws Exception {
		ArrayList<Faq> faqList = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			faqList = new ArrayList<Faq>();
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(FaqSql.FAQ_LIST);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				faqList.add(new Faq(rs.getInt("FAQ_NO"),
									   rs.getString("FAQ_QUESTION"),
									   rs.getString("FAQ_ANSWER"),
									   rs.getString("FAQ_CATEGORY")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		}
		
		return faqList;
	}
	/**
	 * FAQ 1건 상세 조회
	 * @param faqNo
	 * @return FAQ 1건
	 * @throws Exception
	 */
	public Faq getFaqByNo(int faqNo) throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Faq faq = null;
		
		try {
			conn = dataSource.getConnection();
			StringBuffer sql = new StringBuffer(300);
			sql.append("SELECT");
			sql.append("FAQ_NO, FAQ_QUESTION, FAQ_ANSWER, FAQ_CATEGORY");
			sql.append("FROM FAQ");
			sql.append("WHERE FAQ_NO = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, faqNo);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				faq = new Faq();
				faq.setFaqNo(rs.getInt(1));
				faq.setFaqQuestion(rs.getString(2));
				faq.setFaqAnswer(rs.getString(3));
				faq.setFaqCategory(rs.getString(4));
				
				sql.delete(0, sql.length());
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
			return faq;
	}
	/**
	 * FAQ 총 개수 반환
	 * @return 
	 * @throws Exception
	 */
	public int getFaqCount() throws Exception{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(FaqSql.FAQ_COUNT);
			rs = pstmt.executeQuery();
			if(rs.next())
				count = rs.getInt(1);
		}
		 finally {
			 if (rs != null) rs.close();
			 if (pstmt != null) pstmt.close();
			 if (conn != null) conn.close();
		}
		return count;
	}
}
