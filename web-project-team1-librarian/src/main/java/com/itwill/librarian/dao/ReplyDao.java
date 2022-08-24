package com.itwill.librarian.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import com.itwill.librarian.common.Librarian;
import com.itwill.librarian.domain.Qna;
import com.itwill.librarian.domain.Reply;
import com.itwill.librarian.sql.QnaSql;
import com.itwill.librarian.sql.ReplySql;

public class ReplyDao {
	private DataSource dataSource;
	
	public ReplyDao() {
		this.dataSource = Librarian.getDataSource();
	}
	
	public int replyCreate(Reply reply) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ReplySql.REPLY_CREATE);
			pstmt.setString(1, reply.getReplyContent());
			pstmt.setInt(2, reply.getQnaNo());
			pstmt.setInt(3, reply.getMemberNo());

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
