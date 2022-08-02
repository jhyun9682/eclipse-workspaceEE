package com.itwill.shop.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;

public class CartDao {
	private DataSource dataSource;
	public CartDao() throws Exception{
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/com/itwill/shop/jdbc.properties"));
		/*** Apache DataSource ***/
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(properties.getProperty("driverClass"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("user"));
		basicDataSource.setPassword(properties.getProperty("password"));
		dataSource = basicDataSource;
	}
	/*
	 * cart제품 존재여부
	 */
	public boolean  isProductExist(String sUserId,int p_no) throws Exception{
		boolean isExist=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String selectQuery="select count(*)  as p_count from cart c join userinfo u on c.userid=u.userid where u.userid=? and c.p_no=?";
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(selectQuery);
			pstmt.setString(1, sUserId);
			pstmt.setInt(2, p_no);
			rs = pstmt.executeQuery();
			int count=0;
			if(rs.next()) {
				count=rs.getInt(1);
			}
			if(count==0) {
				isExist=false;
			}else {
				isExist=true;
			}
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return isExist;
	}
	
	
	/*
	 * cart insert
	 */
	public int add(String sUserId,int p_no,int cart_qty) throws Exception {
		String insertQuery="insert into cart(cart_no,userId,p_no,cart_qty) values (cart_cart_no_SEQ.nextval,?,?,?)";
		Connection con=null;
		PreparedStatement pstmt=null;
		int insertRowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(insertQuery);
			pstmt.setString(1, sUserId);
			pstmt.setInt(2, p_no);
			pstmt.setInt(3, cart_qty);
			insertRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return insertRowCount;
		
	}
	/*
	 * cart add update
	 */
	public int update(String sUserId,int p_no,int cart_qty) throws Exception{
		String updateQuery="update cart set cart_qty=cart_qty + ? where userid=? and p_no=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(updateQuery);
			pstmt.setInt(1, cart_qty);
			pstmt.setString(2, sUserId);
			pstmt.setInt(3, p_no);
			rowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return rowCount;
	}
	/*
	 * cart update
	 */
	public int update(int cart_no,int cart_qty) throws Exception{
		String updateQuery="update cart set cart_qty=? where cart_no=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(updateQuery);
			pstmt.setInt(1, cart_qty);
			pstmt.setInt(2, cart_no);
			rowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return rowCount;
	}
	/*
	 * cart list
	 */
	public ArrayList<CartItem> getCartList(String sUserId) throws Exception{
		ArrayList<CartItem> cartList=new ArrayList<CartItem>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String selectQuery="select * from cart c join userinfo u on c.userid=u.userid  "
				        + "join product p on p.p_no=c.p_no "
				        + "where u.userid=?";
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(selectQuery);
			pstmt.setString(1,sUserId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cartList.add(new CartItem(rs.getInt("cart_no"),
							new User(),
							new Product(rs.getInt("p_no"),
										rs.getString("p_name"),
										rs.getInt("p_price"),
										rs.getString("p_image"),
										null,
										0), 
							rs.getInt("cart_qty")));
			}
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return cartList;
	}
	
	/*
	 * cart pk delete
	 */
	public int deleteCartByNo(int cart_no) throws Exception{
		String deleteQuery="delete from cart where cart_no=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		int deleteRowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(deleteQuery);
			pstmt.setInt(1, cart_no);
			deleteRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return deleteRowCount;
	}
	/*
	 * cart  delete
	 */
	public int deleteCart(String sUserId) throws Exception{
		String deleteQuery="delete from cart where userid=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		int deleteRowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(deleteQuery);
			pstmt.setString(1, sUserId);
			deleteRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return deleteRowCount;
	}
	public CartItem getCartItemByCartNo(int cart_no)throws Exception {
		CartItem cartItem=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String selectQuery="select * from cart c join product p on c.p_no=p.p_no where cart_no=?";
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(selectQuery);
			pstmt.setInt(1,cart_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cartItem = new CartItem(rs.getInt("cart_no"),
							new User(),
							new Product(rs.getInt("p_no"),
										rs.getString("p_name"),
										rs.getInt("p_price"),
										rs.getString("p_image"),
										null,
										0), 
							rs.getInt("cart_qty"));
			}
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return cartItem;
	}
}
