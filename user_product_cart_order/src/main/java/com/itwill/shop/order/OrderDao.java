package com.itwill.shop.order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.cart.CartItem;
import com.itwill.shop.product.Product;
import com.itwill.shop.user.User;

public class OrderDao {
	
	private DataSource dataSource;
	public OrderDao() throws Exception {
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
	/**************************2022.08.02구현************************/
	public int create(Order order)throws Exception{
		/*
		 insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_seq.nextval,'비글외1종',sysdate,1550000,'guard1');
		 insert into order_item(oi_no,oi_qty,o_no,p_no)  values(order_item_oi_no_seq.nextval,1,orders_o_no_seq.currval,1);
		 */
		Connection con=null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			/*
			 * transaction시작
			 */
			//order insert
			pstmt1 = con.prepareStatement(OrderSQL.ORDER_INSERT);
			pstmt1.setString(1,order.getO_desc());
			pstmt1.setInt(2,order.getO_price());
			pstmt1.setString(3,order.getUserId());
			pstmt1.executeUpdate();
			//orderitem insert
			pstmt2=con.prepareStatement(OrderSQL.ORDER_ITEM_INSERT);
			for(OrderItem orderItem:order.getOrderItemList()) {
				pstmt2.clearParameters();
				pstmt2.setInt(1, orderItem.getOi_qty());
				pstmt2.setInt(2, orderItem.getProduct().getP_no());
				pstmt2.executeUpdate();
			}
			/*
			 * transaction종료(성공)
			 */
			con.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			/*
			 * transaction종료(실패)
			 */
			con.rollback();
			throw e;
		}
		return 0;
	}
	/*
	 * 주문상세리스트(특정사용자)
	 * 
	 */
	public List<Order> list_detail(String userId) throws Exception{
		List<Order> orderList=new ArrayList<Order>();
		
		Connection con=dataSource.getConnection();
		PreparedStatement pstmt1 = con.prepareStatement(OrderSQL.ORDER_O_NO_LIST);
		PreparedStatement pstmt2 = con.prepareStatement(OrderSQL.ORDER_LIST_BY_USERID_O_NO);
		
		pstmt1.setString(1, userId);
		ResultSet rs1=pstmt1.executeQuery();
		while(rs1.next()) {
			int temp_o_no=rs1.getInt("o_no");
			
			pstmt2.setString(1, userId);
			pstmt2.setInt(2, temp_o_no);
			ResultSet rs2 = pstmt2.executeQuery();
			Order order=null;
			if(rs2.next()) {
				//int o_no, String o_desc, Date o_date, int o_price, String userId, List<OrderItem> orderItemList
				order = new Order(rs2.getInt("o_no"),
										rs2.getString("o_desc"),
										rs2.getDate("o_date"),
										rs2.getInt("o_price"),
										rs2.getString("userid"),
										null);
				
				List<OrderItem> orderItemList=new ArrayList<OrderItem>();
				do {
					//int oi_no, int oi_qty, int o_no, Product product
					orderItemList.add(new OrderItem(rs2.getInt("oi_no"),
													rs2.getInt("oi_qty"),
													rs2.getInt("o_no"),
													//int p_no, String p_name, int p_price, String p_image, String p_desc, int p_click_count
													new Product(rs2.getInt("p_no"),
																rs2.getString("p_name"),
																rs2.getInt("p_price"),
																rs2.getString("p_image"),
																rs2.getString("p_desc"),
																rs2.getInt("p_click_count"))));
					
				}while(rs2.next());
				order.setOrderItemList(orderItemList);
			}//end if
			orderList.add(order);
		}//end while
		/*
		2	다스훈트외1종	2022/08/02	2400000	guard1	3	1	2	7	7	닥스훈트	800000	dachshund.jpg	기타 상세 정보 등...
		2	다스훈트외1종	2022/08/02	2400000	guard1	4	2	2	8	8	사모예드	800000	samoyed.jpg		기타 상세 정보 등...
		
		4	비글외 2종		2022/08/02	2300000	guard1	6	2	4	1	1	비글		550000	bigle.png		기타 상세 정보 등...
		4	비글외 2종		2022/08/02	2300000	guard1	7	1	4	3	3	퍼그		400000	pug.jpg			기타 상세 정보 등...
		4	비글외 2종		2022/08/02	2300000	guard1	8	1	4	7	7	닥스훈트	800000	dachshund.jpg	기타 상세 정보 등...
		
		5	샤페이외 0종	2022/08/02	700000	guard1	9	1	5	6	6	샤페이		700000	shaipei.jpg		기타 상세 정보 등...
		
		6	샤페이외 0종	2022/08/02	700000	guard1	10	1	6	6	6	샤페이		700000	shaipei.jpg		기타 상세 정보 등...
		*/
		return orderList;
		
		
	}//end method
	
	/****************************************************************/
	/*
	 * 주문전체삭제(ON DELETE CASCADE)
	 */
	public int delete(String sUserId)throws Exception{
		String deleteSql="delete from orders where userid=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(deleteSql);
			pstmt.setString(1, sUserId);
			rowCount = pstmt.executeUpdate();
			con.commit();
		}catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return rowCount;
	}
	/*
	 * 주문1건삭제
	 */
	/*
	public int delete(int j_no)throws Exception{
		String deleteSql1="delete from order_item where o_no=?";
		String deleteSql2="delete from orders where o_no=?";
		Connection con=null;
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1=con.prepareStatement(deleteSql1);
			pstmt2=con.prepareStatement(deleteSql2);
			pstmt1.setInt(1, j_no);
			pstmt2.setInt(1, j_no);
			int rowCount1 = pstmt1.executeUpdate();
			int rowCount2 = pstmt2.executeUpdate();
			con.commit();
		}catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return 0;
	}
	*/
	/*
	 * 주문1건삭제(ON DELETE CASCADE)
	 */
	public int deleteByOrderNo(int o_no)throws Exception{
		String deleteSql="delete from orders where o_no=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(deleteSql);
			pstmt.setInt(1, o_no);
			rowCount= pstmt.executeUpdate();
			con.commit();
		}catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return rowCount;
	}
	
	/*
	 * 주문리스트(특정사용자)
	 */
	public ArrayList<Order> list(String sUserId) throws Exception{
		ArrayList<Order> orderList=new ArrayList<Order>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String selectQuery="select * from orders where userid=?";
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(selectQuery);
			pstmt.setString(1,sUserId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				orderList.add(new Order(rs.getInt("o_no"),
										rs.getString("o_desc"),
								       rs.getDate("o_date"),
								       rs.getInt("o_price"),
								       rs.getString("userid"),
								       null));
			}
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return orderList;
	}
	/*
	 * 주문1개보기(주문상세)
	 */
	public Order detail(String sUserId,int o_no)throws Exception{
		/*
		select * from orders o join order_item oi on o.o_no=oi.o_no  join  product p on oi.p_no=p.p_no where o.userid=? and o.o_no = ?
		 */
		String selectSql=
				"select * from orders o join order_item oi on o.o_no=oi.o_no  join  product p on oi.p_no=p.p_no where o.userid=? and o.o_no = ?";
		Order order=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		con=dataSource.getConnection();
		pstmt=con.prepareStatement(selectSql);
		pstmt.setString(1,sUserId);
		pstmt.setInt(2,o_no);
		rs=pstmt.executeQuery();
		
		
		if(rs.next()) {
			order=new Order(rs.getInt("o_no"), 
					rs.getString("o_desc"),
					rs.getDate("o_date"),
					rs.getInt("o_price"),rs.getString("userid"),null);
			do{
				order.getOrderItemList()
					.add(new OrderItem(
								rs.getInt("oi_no"), 
								rs.getInt("oi_qty"), 
								rs.getInt("o_no"), 
								new Product(rs.getInt("p_no"),
											rs.getString("p_name"),
											rs.getInt("p_price"),
											rs.getString("p_image"),
											rs.getString("p_desc"),
											rs.getInt("p_click_count"))
								)
							);
			}while(rs.next());
		}
		
		
		return order;
	}
	
	
}
