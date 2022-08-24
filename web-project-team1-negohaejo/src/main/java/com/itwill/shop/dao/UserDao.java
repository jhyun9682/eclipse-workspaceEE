package com.itwill.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.dto.User;
import com.itwill.shop.sql.UserSQL;

public class UserDao {
	private DataSource dataSource;
	public UserDao() throws Exception {
		BasicDataSource basicDataSource = new BasicDataSource();
		Properties properties=new Properties();
		properties.load(this.getClass().getResourceAsStream("/com/itwill/shop/jdbc.properties"));
		basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("username"));
		basicDataSource.setPassword(properties.getProperty("password"));
		this.dataSource=basicDataSource;
	}
	
	public int create(User user) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		int insertRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(UserSQL.USER_INSERT);
			pstmt.setString(1, user.getU_id());
			pstmt.setString(2, user.getU_password());
			pstmt.setString(3, user.getU_name());
			pstmt.setString(4, user.getU_birth());
			pstmt.setString(5, user.getU_gender());
			pstmt.setString(6, user.getU_phone());
			pstmt.setString(7, user.getU_address());
			insertRowCount = pstmt.executeUpdate();
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		return insertRowCount;
	}
	
	public int updateAll(User user) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int updateRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(UserSQL.USER_UPDATE_ALL);
			pstmt.setString(1, user.getU_name());
			pstmt.setString(2, user.getU_birth());
			pstmt.setString(3, user.getU_gender());
			pstmt.setString(4, user.getU_phone());
			pstmt.setString(5, user.getU_address());
			pstmt.setString(6, user.getU_id());
			updateRowCount = pstmt.executeUpdate();
		} finally {
			if(pstmt != null) {
				pstmt.close();
			}
			if(con != null) {
				con.close();
			}
		}
		return updateRowCount;
	}
	public int updatePassword(User user) throws Exception {
			Connection con = null;
			PreparedStatement pstmt = null;
			int updatePasswordRowCount = 0;
			try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(UserSQL.USER_UPDATE_PASSWORD);
				pstmt.setString(1, user.getU_password());
				pstmt.setString(2, user.getU_id());
				updatePasswordRowCount = pstmt.executeUpdate();
			} finally {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			}
			return updatePasswordRowCount;
	}
	
	
	public int remove(String u_id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		int removeRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(UserSQL.USER_REMOVE);
			pstmt.setString(1, u_id);
			removeRowCount = pstmt.executeUpdate();
		} finally {
			if(pstmt != null) 
				pstmt.close();
			if(con != null) 
				con.close();
		}
		return removeRowCount;
	}
	
	public User findUser(String u_id) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User findUser = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(UserSQL.USER_SELECT_BY_ID);
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				findUser = new User(rs.getString("u_id"),
									rs.getString("u_password"),
									rs.getString("u_name"),
									rs.getString("u_birth"),
									rs.getString("u_gender"),
									rs.getString("u_phone"),
									rs.getString("u_address"));
			}
			
		} finally {
			if(rs != null)
				rs.close();
			if(pstmt != null) 
				pstmt.close();
			if(con != null) 
				con.close();
		}
		return findUser;
	}
	public ArrayList<User> findUserList()throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<User> findUserList = new ArrayList<User>();
		try {
				con = dataSource.getConnection();
				pstmt = con.prepareStatement(UserSQL.USER_SELECT_ALL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					findUserList.add(new User(rs.getString("u_id"),
							rs.getString("u_password"),
							rs.getString("u_name"),
							rs.getString("u_birth"),
							rs.getString("u_gender"),
							rs.getString("u_phone"),
							rs.getString("u_address")));
			
		}
	}finally {
		if (rs != null)
			rs.close();
		if (pstmt != null)
			pstmt.close();
		if (con != null)
			con.close();
		}
		return findUserList;
	}
		
	
	public boolean existedUser(String u_id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean isExist = false;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(UserSQL.USER_SELECT_BY_ID_COUNT);
			pstmt.setString(1, u_id);
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
