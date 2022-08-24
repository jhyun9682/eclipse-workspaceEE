package com.itwill.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.dto.Product;
import com.itwill.shop.dto.Purchase;
import com.itwill.shop.dto.Purchase_Item;
import com.itwill.shop.dto.Review;
import com.itwill.shop.sql.PurchaseSQL;

public class PurchaseDao {
	private DataSource dataSource;

	public PurchaseDao() throws Exception {
		BasicDataSource basicDataSource = new BasicDataSource();
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/com/itwill/shop/jdbc.properties"));
		basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("username"));
		basicDataSource.setPassword(properties.getProperty("password"));
		this.dataSource = basicDataSource;
	}
	
	//주문생성
	public int purchaseCreate(Purchase purchase) throws Exception{
		
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt1=con.prepareStatement(PurchaseSQL.PURCHASE_CREATE);
			pstmt1.setInt(1, purchase.getO_ItemListNum());
			pstmt1.setString(2, purchase.getO_PaySelect());
			pstmt1.setInt(3, purchase.getO_ItemTotPrice());
			pstmt1.setString(4, purchase.getU_ID());
			pstmt1.executeUpdate();
			
			pstmt2=con.prepareStatement(PurchaseSQL.PURCHASE_ITEM_CREATE);
			for(Purchase_Item purchase_Item:purchase.getPurchase_Itemlist()) {
				pstmt2.setInt(1, purchase_Item.getOi_Qty());
				pstmt2.setInt(2, purchase_Item.getProduct().getP_no());
				pstmt2.executeUpdate();
			}
			
			con.commit();
		}
		catch (Exception e){
			e.printStackTrace();
			con.rollback();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return 0;
			
		
	}
	
	//아이디로 결제 전체 삭제
	public int purchaseDeleteById(String u_id) throws Exception{
	
		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(PurchaseSQL.PURCHASE_DELETE_BY_U_ID);
			pstmt.setString(1, u_id);
			rowCount =pstmt.executeUpdate();
			con.commit();
		}
		catch (Exception e){
			e.printStackTrace();
			con.rollback();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return rowCount;
		
	}
	
	//주문번호로 결제 삭제


	public int purchaseDeleteByNo(int o_no) throws Exception{
		

		Connection con = null;
		PreparedStatement pstmt = null;
		int rowCount=0;
		try {
			con=dataSource.getConnection();
			con.setAutoCommit(false);
			pstmt=con.prepareStatement(PurchaseSQL.PURCHASE_DELETE_BY_O_NO);

			pstmt.setInt(1,o_no);
			pstmt.executeUpdate();

			con.commit();
		}
		catch (Exception e){
			e.printStackTrace();
			con.rollback();
			throw e;
		}finally {
			if(con!=null)con.close();
		}
		return rowCount;
		
	}
	
	//아이디로 결제정보 전체 출력
	public ArrayList<Purchase> list(String u_id) throws Exception{
		ArrayList<Purchase> purchaseList = new ArrayList<Purchase>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(PurchaseSQL.PURCHASE_SELECT_LIST_BY_U_ID);
			pstmt.setString(1, u_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				/*Product product = new Product();
				ArrayList<Purchase_Item> purchase_Itemlist= new ArrayList<Purchase_Item>();*/
				purchaseList.add(new Purchase(rs.getInt("o_no"),
						rs.getInt("o_itemlistnum"),
						rs.getString("o_payselect"),
						rs.getInt("o_itemtotprice"),
						rs.getString("u_id"), null));
			}
			
		}finally {
			if(con!=null) {
				con.close();
			}
		}
		return purchaseList;
	}
	
	//주문번호 결제 조회
	public Purchase detail(int o_no)throws Exception{
		
		Purchase purchase = null;
		Connection con = dataSource.getConnection();
		PreparedStatement pstmt = con.prepareStatement(PurchaseSQL.PURCHASE_SELECT_LIST_O_NO);
		pstmt.setInt(1, o_no);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			purchase = new Purchase(rs.getInt("o_no"),
					rs.getInt("o_itemlistnum"),
					rs.getString("o_payselect"),
					rs.getInt("o_itemtotprice"), 
					rs.getString("u_id"), null);
			
			List<Purchase_Item> tempPurchaseItemList = new ArrayList<Purchase_Item>();
			do {
				tempPurchaseItemList.add(new Purchase_Item(rs.getInt("oi_no"),
						rs.getInt("oi_qty"),
						rs.getInt("o_no"),
						new Product(rs.getInt("p_no"),
								rs.getString("p_name"),
								rs.getString("p_desc"),
								rs.getDate("p_date"),
								rs.getInt("p_price"),
								rs.getString("p_img"),
								rs.getString("p_cat"),null)));
			}while(rs.next());
			purchase.setPurchase_Itemlist(tempPurchaseItemList);
		}
		return purchase;
	}
	
	

}
