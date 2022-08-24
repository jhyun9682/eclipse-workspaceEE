package com.itwill.toy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.toy.common.DataSourceUtil;
import com.itwill.toy.domain.Category;
import com.itwill.toy.domain.Order;
import com.itwill.toy.domain.OrderItem;
import com.itwill.toy.domain.Product;
import com.itwill.toy.sql.OrderItemSql;
import com.itwill.toy.sql.OrderSql;

public class OrderDao {
	
	private DataSource dataSource;
	public OrderDao() throws Exception{
		this.dataSource = DataSourceUtil.getDataSource();
	}
	/*
	 * 주문 전체삭제
	 */
	public int delete(String sM_id) throws Exception{
		String deleteSql="delete from orders where m_id=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSql.ORDER_DELETE_BY_M_ID);
			pstmt.setString(1, sM_id);
			rowCount = pstmt.executeUpdate();
			con.commit();
		}catch(Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return rowCount;
	}
	/*
	 * 주문 1건삭제
	 */
	public int deleteByOrderNo(int o_no) throws Exception{
		String deleteSql = "delete from orders where o_no=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(OrderSql.ORDER_DELETE_BY_ORDER_NO);
			pstmt.setInt(1, o_no);
			rowCount = pstmt.executeUpdate();
			con.commit();
		}catch(Exception e) {
			con.rollback();
			e.printStackTrace();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return rowCount;
	}
	/*
	 * 주문생성
	 */
	public int create(Order order) throws Exception{
		String insertOrder=
				"insert into orders(o_no,o_desc,o_date,o_price,o_rv_name,o_rv_phone,o_rv_address,o_message,m_id)\n"
				+ "values(orders_o_no_SEQ.nextval,?,sysdate,?,?,?,?,?,?)";
		String insertOrderItem=
				"insert into order_item(oi_no,oi_qty,o_no,p_no)\n"
				+ "values(order_item_oi_no_SEQ.nextval,?,orders_o_no_SEQ.currval,?)";
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1 = con.prepareStatement(OrderSql.ORDER_CREATE);
			pstmt1.setString(1, order.getO_desc());
			pstmt1.setInt(2, order.getO_price());
			pstmt1.setString(3, order.getO_rv_name());
			pstmt1.setString(4, order.getO_rv_phone());
			pstmt1.setString(5, order.getO_rv_address());
			pstmt1.setString(6, order.getO_message());
			pstmt1.setString(7, order.getM_Id());
			pstmt1.executeUpdate();
			
			pstmt2 = con.prepareStatement(OrderItemSql.ORDER_ITEM_CREATE);
			for(OrderItem orderItem:order.getOrderItemList()) {
				pstmt2.setInt(1, orderItem.getOi_qty());
				pstmt2.setInt(2, orderItem.getProduct().getP_no());
				pstmt2.executeUpdate();
			}
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
			con.rollback();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return 0;
	}
	
	/*
	 * 주문전체(특정사용자)
	 */
	public ArrayList<Order> list(String sM_id) throws Exception{
		ArrayList<Order> orderList = new ArrayList<Order>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "select * from orders where m_id=?";
		try {
			con=dataSource.getConnection();
			pstmt = con.prepareStatement(OrderSql.ORDER_SELECT_LIST_BY_M_ID);
			pstmt.setString(1,sM_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				orderList.add(new Order(rs.getInt("o_no"),
										rs.getString("o_desc"),
										rs.getDate("o_date"),
										rs.getInt("o_price"),
										rs.getString("o_rv_name"),
										rs.getString("o_rv_phone"),
										rs.getString("o_rv_address"), 
										rs.getString("o_message"),
										rs.getString("m_id"),
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
	 * 주문 1개보기(주문상세리스트)
	 */
	public Order detail(String sM_id,int o_no) throws Exception{
		Order order = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(OrderSql.ORDER_SELECT_BY_O_NO);
		pstmt.setString(1, sM_id);
		pstmt.setInt(2, o_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			order = new Order(rs.getInt("o_no"),
					rs.getString("o_desc"),
					rs.getDate("o_date"),
					rs.getInt("o_price"),
					rs.getString("o_rv_name"),
					rs.getString("o_rv_phone"),
					rs.getString("o_rv_address"), 
					rs.getString("o_message"),
					rs.getString("m_id"),
					null);
					
			List<OrderItem> tempOrderItemList = new ArrayList<OrderItem>();
			do{
				tempOrderItemList.add(new OrderItem(rs.getInt("oi_no"),
													rs.getInt("oi_qty"),
													rs.getInt("o_no"),
													new Product(rs.getInt("p_no"),
																rs.getString("p_name"),
																rs.getInt("p_price"),
																rs.getString("p_image"),
																rs.getString("p_desc"),
																rs.getDate("p_date"),
																null)));
			}while(rs.next());
			order.setOrderItemList(tempOrderItemList);
		}
		return order;
	}
	
	
	
	
	
	
	
	
}
