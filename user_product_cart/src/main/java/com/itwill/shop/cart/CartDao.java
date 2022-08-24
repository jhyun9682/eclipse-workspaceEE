package com.itwill.shop.cart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;

/*
쇼핑몰에서 cart 테이블과의 데이타베이스와의 작업을 전담하는 클래스
cart 테이블에 CRUD 등의 작업을한다.
*/

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
	 * cart에있는 제품count
	 */
	 public int cartProductCount(CartItem cartItem) throws Exception{
		 Connection con=dataSource.getConnection();
		 PreparedStatement pstmt=con.prepareStatement(CartSQL.CART_SELECT_PRODUCT_COUNT_BY_USERID_P_NO);
		 pstmt.setString(1, cartItem.getUserid());
		 pstmt.setInt(2, cartItem.getProduct().getP_no());
		 ResultSet rs = pstmt.executeQuery();
		 rs.next();
		 int product_count=rs.getInt("product_count");
		 con.close();
		 return product_count;
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
	 * cart insert(CartItem)
	 */
	public int add(CartItem newCartItem)throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(CartSQL.CART_INSERT);
		pstmt.setInt(1,newCartItem.getCart_qty());
		pstmt.setInt(2,newCartItem.getProduct().getP_no());
		pstmt.setString(3,newCartItem.getUserid());
		int rowCount=pstmt.executeUpdate();
		
		con.close();
		return rowCount;
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
	 * cart 추가시 수량 update
	 */
	public int updateByProductNoAndUserId(CartItem cartItem) throws Exception{
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt=con.prepareStatement(CartSQL.CART_UPDATE_BY_P_NO_USERID);
		pstmt.setInt(1,cartItem.getCart_qty());
		pstmt.setString(2,cartItem.getUserid());
		pstmt.setInt(3,cartItem.getProduct().getP_no());
		int rowCount=pstmt.executeUpdate();
		con.close();
		return rowCount;
	}
	/*
	 * cart 추가시 수량 update
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
	 * 로그인한 사용자의 cart item list
	 */
	public List<CartItem> getCartList(String sUserId) throws Exception{
		
	    List<CartItem> cartItemList=new ArrayList<CartItem>();
	    Connection con=dataSource.getConnection();
	    PreparedStatement pstmt=con.prepareStatement(CartSQL.CART_SELECT_LIST_BY_USERID);
	    pstmt.setString(1, sUserId);
	    ResultSet rs=pstmt.executeQuery();
	    /*
		-------------------------------------------------------------------------------------------------------------
		cart_no cart_qty  userid  p_no    p_name		p_price  p_image		p_desc					p_click_count
		-------------------------------------------------------------------------------------------------------------
			1		2	  guard1	1	  비글			550000	 bigle.png	 	기타 상세 정보 등...	 	0
			2		1	  guard1	3	  퍼그			400000	 pug.jpg		기타 상세 정보 등...		0
			3		1	  guard1	7	  닥스훈트		800000	 dachshund.jpg	기타 상세 정보 등...		0
		 */
	    while(rs.next()) {
	    	CartItem cartItem=
	    			new CartItem(rs.getInt("cart_no"),
	    						rs.getInt("cart_qty"),
	    						new Product(rs.getInt("p_no"), 
	    									rs.getString("p_name"),
	    									rs.getInt("p_price"), 
	    									rs.getString("p_image"), 
	    									rs.getString("p_desc"),
	    									rs.getInt("p_click_count")),
	    						sUserId);
	    	cartItemList.add(cartItem);
	    }
	    con.close();
	    return cartItemList;
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
	
}
