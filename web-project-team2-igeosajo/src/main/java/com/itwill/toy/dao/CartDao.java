package com.itwill.toy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;


import com.itwill.toy.domain.Product;
import com.itwill.toy.domain.Cart;
import com.itwill.toy.domain.Category;
import com.itwill.toy.domain.Member;
import com.itwill.toy.common.DataSourceUtil;
import com.itwill.toy.sql.CartSql;

/*
이름    널?       유형           
----- -------- ------------ 
C_NO  NOT NULL NUMBER(10)   
C_QTY          NUMBER(10)   
P_NO           NUMBER(10)   
M_ID           VARCHAR2(50) 
 */
public class CartDao {
	private DataSource dataSource;
	
	public CartDao() throws Exception{
		this.dataSource = DataSourceUtil.getDataSource();
	}

	/*
	 * cart제품 존재여부
	 */
	public boolean  isProductExist(String sUserId,int p_no) throws Exception{
		boolean isExist=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		//String selectQuery="select count(*)  as p_qty from cart c join member m on c.m_id=m.m_id where m.m_id=? and c.p_no=?";
		
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSql.CART_IS_PRODUCT_EXIST);
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
	public int add(int c_qty,int p_no,String sUserId) throws Exception {
		//String insertQuery="insert into cart(c_no,c_qty,p_no,m_id,) values (cart_c_no_SEQ.nextval,?,?,?)";
		Connection con=null;
		PreparedStatement pstmt=null;
		int insertRowCount=0;
		try {
			con=dataSource.getConnection() ;
			pstmt=con.prepareStatement(CartSql.CART_ADD);
			pstmt.setInt(1, c_qty);
			pstmt.setInt(2, p_no);
			pstmt.setString(3, sUserId);
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
	public int update(int c_qty,int p_no,String sUserId) throws Exception{
		//String updateQuery="update cart set c_qty=c_qty + ? where m_id=? and p_no=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSql.CART_ADD_UPDATE);
			pstmt.setInt(1, c_qty);
			pstmt.setInt(2, p_no);
			pstmt.setString(3, sUserId);
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
	public int update(int c_no,int c_qty) throws Exception{
		//String updateQuery="update cart set cart_qty=? where cart_no=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSql.CART_UPDATE);
			pstmt.setInt(1, c_qty);
			pstmt.setInt(2, c_no);
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
	public ArrayList<Cart> getCartList(String sUserId) throws Exception{
		ArrayList<Cart> cartList=new ArrayList<Cart>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String selectQuery="select * from cart c "
				+ "join member m on c.m_id=m.m_id "
				+ "join product p on p.p_no=c.p_no"
				+ "join category cg on p.p_no=cg.cg_no"
				+ "where m.m_id=?";
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSql.CART_SELECT_LIST_BY_USERID);
			pstmt.setString(1,sUserId);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				/*
				 int c_no, int c_qty, Product product, Member member
				 */
				cartList.add(new Cart(rs.getInt("c_no"),
									  rs.getInt("c_qty"),
									  /*
									   int p_no, String p_name, int p_price, String p_image, String p_desc, Date p_date, Category category
									   */
									  new Product(rs.getInt("p_no"),
											      rs.getString("p_name"),
												  rs.getInt("p_price"),
												  rs.getString("p_image"),
												  rs.getString("p_desc"),
												  null,
												  /*
												   int cg_no, String cg_name 
												   */
												  new Category(rs.getInt("cg_no"),
													           rs.getString("cg_name"))),
									  			  /*
									  			  The constructor Member(String, String, String, String, String, String, String, String, String) is undefined
									  			  
									  			   */
												  new Member())
						              );
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
	public int deleteCartByNo(int c_no) throws Exception{
		String deleteQuery="delete from cart where c_no=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		int deleteRowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSql.CART_DELETE_BY_CART_NO);
			pstmt.setInt(1, c_no);
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
		String deleteQuery="delete from cart where m_id=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		int deleteRowCount=0;
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSql.CART_DELETE_BY_USERID);
			pstmt.setString(1, sUserId);
			deleteRowCount = pstmt.executeUpdate();
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return deleteRowCount;
	}
	public Cart getCartItemByCartNo(int cart_no)throws Exception {
		Cart cartItem=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String selectQuery="select * from cart c join product p on c.p_no=p.p_no where cart_no=?";
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(CartSql.CART_SELECT_BY_CART_NO);
			pstmt.setInt(1,cart_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				
				cartItem = (new Cart(rs.getInt("c_no"),
						  rs.getInt("c_qty"),
						  /*
						   int p_no, String p_name, int p_price, String p_image, String p_desc, Date p_date, Category category
						   */
						  new Product(rs.getInt("p_no"),
								      rs.getString("p_name"),
									  rs.getInt("p_price"),
									  rs.getString("p_image"),
									  rs.getString("p_desc"),
									  null,
									  /*
									   int cg_no, String cg_name 
									   */
									  null),
						  			  /*
						  			  The constructor Member(String, String, String, String, String, String, String, String, String) is undefined
						  			  
						  			   */
									  new Member())
			              );
			}
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return cartItem;
		
	}
}
