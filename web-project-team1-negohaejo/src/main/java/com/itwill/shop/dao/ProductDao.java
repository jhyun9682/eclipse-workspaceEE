package com.itwill.shop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

import com.itwill.shop.dto.Product;
import com.itwill.shop.dto.Review;
import com.itwill.shop.sql.ProductSQL;

public class ProductDao {
	private DataSource dataSource;

	public ProductDao() throws Exception {
		
		BasicDataSource basicDataSource = new BasicDataSource();
		Properties properties = new Properties();
		properties.load(this.getClass().getResourceAsStream("/com/itwill/shop/jdbc.properties"));
		basicDataSource.setDriverClassName(properties.getProperty("driverClassName"));
		basicDataSource.setUrl(properties.getProperty("url"));
		basicDataSource.setUsername(properties.getProperty("username"));
		basicDataSource.setPassword(properties.getProperty("password"));
		this.dataSource = basicDataSource;
	}

	public ArrayList<Product> selectAll() throws Exception {
		ArrayList<Product> productList = new ArrayList<Product>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int compare=-1;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ProductSQL.selectall);
			rs = pstmt.executeQuery();
			ArrayList<Review> reviewList=new ArrayList<Review>();
			while (rs.next()) {
				int p_no=rs.getInt("p_no");
				if (rs.getString("review_no") == null) {
					productList.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
							new Date(rs.getDate(4).getTime()), rs.getInt(5), rs.getString(6), rs.getString(7),
							null));
				}else if(p_no==compare){
					reviewList.add(new Review(rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11),
							rs.getInt(12), rs.getInt(13)));
					
				}else {
					
					reviewList = new ArrayList<Review>();
							reviewList.add(new Review(rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11),
							rs.getInt(12), rs.getInt(13)));
					productList.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
							new Date(rs.getDate(4).getTime()), rs.getInt(5), rs.getString(6), rs.getString(7),
							reviewList));
					compare=p_no;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();

		}

		return productList;
	}
	public ArrayList<Product> selectbyCat(String p_cat) throws Exception {
		ArrayList<Product> productList = new ArrayList<Product>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int compare=-1;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ProductSQL.selectbycat);
			pstmt.setString(1, p_cat);
			rs = pstmt.executeQuery();
			ArrayList<Review> reviewList=new ArrayList<Review>();
			while (rs.next()) {
				int p_no=rs.getInt("p_no");
				if (rs.getString("review_no") == null) {
					productList.add(new Product(rs.getInt("p_no"), rs.getString("p_name"), rs.getString("p_desc"),
							new Date(rs.getDate("p_date").getTime()), rs.getInt("p_price"), rs.getString("p_img"), rs.getString("p_cat"),
							null));
				}else if(p_no==compare){
					reviewList.add(new Review(rs.getInt("review_no"), rs.getString("reviewdesc"), rs.getString("u_id"), rs.getInt("p_no"),
							rs.getInt("r_score"), rs.getInt("oi_no")));
					
				}else {
					
					reviewList = new ArrayList<Review>();
							reviewList.add(new Review(rs.getInt("review_no"), rs.getString("reviewdesc"), rs.getString("u_id"), rs.getInt("p_no"),
							rs.getInt("r_score"), rs.getInt("oi_no")));
					productList.add(new Product(rs.getInt("p_no"), rs.getString("p_name"), rs.getString("p_desc"),
							new Date(rs.getDate("p_date").getTime()), rs.getInt("p_price"), rs.getString("p_img"), rs.getString("p_cat"),
							reviewList));
					compare=p_no;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();

		}

		return productList;
	}

	public Product selectByNo(int p_no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Product product = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(ProductSQL.selectbyno);
			pstmt.setInt(1, p_no);

			rs = pstmt.executeQuery();
			ArrayList<Review> reviewList = new ArrayList();
			while (rs.next()) {
				if (rs.getString("review_no") == null) {
					product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
							new Date(rs.getDate(4).getTime()), rs.getInt(5), rs.getString(6), rs.getString(7),
							reviewList);
				} else {
					reviewList.add(new Review(rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11),
							rs.getInt(12), rs.getInt(12)));
					product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
							new Date(rs.getDate(4).getTime()), rs.getInt(5), rs.getString(6), rs.getString(7),
							reviewList);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return product;
	}
	public ArrayList<Product> select(String keyword,String p_cat,String ord,String sc) throws Exception {
		ArrayList<Product> productList = new ArrayList<Product>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int compare=-1;
		try {
			con = dataSource.getConnection();
			String combination="";
			if(keyword!=null && !keyword.equals("")) combination+=("where p_name like '%"+keyword+"%'");
			if((p_cat!=null && !p_cat.equals("")) && combination.equals("")) { combination+=("where p.p_cat='"+p_cat+"'");}
			if((p_cat!=null && !p_cat.equals("")) && !combination.equals("")) { combination+=("and p_cat='"+p_cat+"'");}
			if(ord!=null && !ord.equals("")) combination+=("order by "+ord);
			if(sc!=null && !sc.equals("")) combination+=" "+sc;
			//get으로 받을 경우 잘못받으면 오류 ord 없이 sc만 받는 경우등 request.getparameter("없는파라메터")-->null 검색단어는 한글자만
			
			pstmt = con.prepareStatement(ProductSQL.select+" "+combination);
			rs = pstmt.executeQuery();
			ArrayList<Review> reviewList=new ArrayList<Review>();
			while (rs.next()) {
				int p_no=rs.getInt("p_no");
				if (rs.getString("review_no") == null) {
					productList.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
							new Date(rs.getDate(4).getTime()), rs.getInt(5), rs.getString(6), rs.getString(7),
							null));
				}else if(p_no==compare){
					reviewList.add(new Review(rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11),
							rs.getInt(12), rs.getInt(12)));
					
				}else {
					
					reviewList = new ArrayList<Review>();
							reviewList.add(new Review(rs.getInt(8), rs.getString(9), rs.getString(10), rs.getInt(11),
							rs.getInt(12), rs.getInt(12)));
					productList.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3),
							new Date(rs.getDate(4).getTime()), rs.getInt(5), rs.getString(6), rs.getString(7),
							reviewList));
					compare=p_no;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();

		}

		return productList;
	}
}
