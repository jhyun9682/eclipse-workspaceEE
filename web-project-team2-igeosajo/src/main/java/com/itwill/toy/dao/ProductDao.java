package com.itwill.toy.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.itwill.toy.domain.Category;
import com.itwill.toy.domain.Product;
import com.itwill.toy.sql.ProductSql;
import com.itwill.toy.common.DataSourceUtil;

public class ProductDao {
	private DataSource dataSource;
	
	public ProductDao() throws Exception{
		this.dataSource = DataSourceUtil.getDataSource();
	}
	
	public ArrayList<Product> getProductList() throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Product> productList = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ProductSql.PRODUCT_SELECT_LIST);
			rs = pstmt.executeQuery();
			productList = new ArrayList<Product>();
			Product product = null;
			while(rs.next()) {
				/*
이름      널?       유형            
------- -------- ------------- 
P_NO    NOT NULL NUMBER(10)    
P_NAME           VARCHAR2(50)  
P_PRICE          NUMBER(10)    
P_IMAGE          VARCHAR2(50)  
P_DESC           VARCHAR2(512) 
P_DATE           DATE          
CG_NO            NUMBER(10)  
				 */
				product = new Product();
				product.setP_no(rs.getInt("p_no"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price(rs.getInt("p_price"));
				product.setP_image(rs.getString("p_image"));
				product.setP_desc(rs.getString("p_desc"));
				product.setP_date(rs.getDate("p_date"));
				product.setCategory(new Category(rs.getInt("cg_no"),rs.getString("cg_name")));
				productList.add(product);
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return productList;
	}
	
	public Product getProduct(int p_no) throws Exception{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		
		try {
			con = dataSource.getConnection();
			
			pstmt = con.prepareStatement(ProductSql.PRODUCT_SELECT_BY_P_NO);
			pstmt.setInt(1, p_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				product = new Product();
				product.setP_no(rs.getInt("p_no"));
				product.setP_name(rs.getString("p_name"));
				product.setP_price(rs.getInt("p_price"));
				product.setP_image(rs.getString("p_image"));
				product.setP_desc(rs.getString("p_desc"));
				product.setP_date(rs.getDate("p_date"));
				product.setCategory(new Category(rs.getInt("cg_no"),rs.getString("cg_name")));
			}
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ex) {
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (Exception ex) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ex) {
			}
		}
		return product;
	}
	
}//end class
