package com.itwill.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.dto.Cart;
import com.itwill.shop.dto.Product;
import com.itwill.shop.dto.User;
import com.itwill.shop.sql.CartSQL;

public class CartDao {
	private DataSource dataSource;

	public CartDao() throws Exception {
		BasicDataSource basicDataSource = new BasicDataSource();
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/com/itwill/shop/jdbc.properties"));
		basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("username"));
		basicDataSource.setPassword(properties.getProperty("password"));
		this.dataSource = basicDataSource;
	}
	
	//Cart 제품 존재여부
	public boolean isProductExist(String u_id, int p_no) throws Exception{
		boolean isExist = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "select count(*) as c_qty from cart c join userinfo u on c.u_id=u.u_id where u.u_id=? and c.p_no=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_IS_PRODUCT_EXIST);
			pstmt.setString(1, u_id);
			pstmt.setInt(2, p_no);
			rs = pstmt.executeQuery();
			int count=0;
			if(rs.next()) {
				count=rs.getInt(1);
			}
			if(count==0) {
				isExist = false;
			}else {
				isExist = true;
			}
		}finally {
			if(con!=null) {
				con.close();
			}
			return isExist;
		}
		
	}
	
	//Cart 제품 추가√
	public int add(String u_id, int p_no, int c_qty) throws Exception{
		String insertQuery = "insert into cart(c_no,u_id,p_no,c_qty) values (cart_cart_no_SEQ.nextval,?,?,?)";
		Connection con = null;
		PreparedStatement pstmt = null;
		int insertRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_ADD);
			pstmt.setString(1, u_id);
			pstmt.setInt(2, p_no);
			pstmt.setInt(3, c_qty);
			insertRowCount = pstmt.executeUpdate();
			
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		
		return insertRowCount;
	}
	
	//Cart 수량 추가√
	public int update(String u_id, int p_no, int c_qty) throws Exception{
		String updateQuery = "update cart set c_qty=c_qty + ? where u_id=? and p_no=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		int updateRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_ADD_UPDATE);
			pstmt.setInt(1, c_qty);
			pstmt.setString(2, u_id);
			pstmt.setInt(3, p_no);
			updateRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return updateRowCount;
	}
	
	//Cart 수량 변경√
	public int update(int c_qty, int c_no) throws Exception{
		String updateQuery = "update cart set c_qty=? where c_no=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		int updateRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_UPDATE);
			pstmt.setInt(1, c_qty);
			pstmt.setInt(2, c_no);
			updateRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return updateRowCount;
	}
	
	//Cart 리스트√
	public ArrayList<Cart> getCartList(String u_id) throws Exception{
		ArrayList<Cart> cartList = new ArrayList<Cart>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "select * from cart c join userinfo u on c.u_id=u.u_id join product2 p on p.p_no=c.p_no where u.u_id=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_SELECT_LIST_BY_USERID);
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cartList.add(new Cart(rs.getInt("c_no"), rs.getInt("c_qty"), new Product(rs.getInt("p_no"),
																						 rs.getString("p_name"), 
																						 rs.getString("p_desc"), 
																						 null, 
																						 rs.getInt("p_price"), 
																						 rs.getString("p_img"), 
																						 rs.getString("p_cat"), 
																						 null),
																			 rs.getString("u_id")));
			}
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return cartList;
	}
	
	//Cart 아이디로 삭제√
	public int deleteCart(String u_id) throws Exception{
		String deleteQuery = "delete from cart where u_id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		int deleteRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_USERID);
			pstmt.setString(1, u_id);
			deleteRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return deleteRowCount;
	}
	
	//Cart 번호로 삭제
	public int deleteCart(int c_no) throws Exception{
		String deleteQuery = "delete from cart where c_no=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		int deleteRowCount = 0;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_DELETE_BY_CART_NO);
			pstmt.setInt(1, c_no);
			deleteRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return deleteRowCount;
	}
	
	//Cart 번호로 조회√
	public Cart getCartByCartNo(int c_no) throws Exception {
		Cart cart = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "select * from cart c join product2 p on c.p_no=p.p_no where c_no=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(CartSQL.CART_SELECT_BY_CART_NO);
			pstmt.setInt(1, c_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cart = new Cart(rs.getInt("c_no"), rs.getInt("c_qty"), new Product(rs.getInt("p_no"),
						 														   rs.getString("p_name"), 
						 														   rs.getString("p_desc"), 
						 														   null, 
						 														   rs.getInt("p_price"), 
						 														   rs.getString("p_img"), 
						 														   rs.getString("p_cat"), 
						 														   null),
																	  rs.getString("u_id"));
			}
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return cart;
	}
	
	
} //endClass
