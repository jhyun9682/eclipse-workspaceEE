package com.itwill.shop.dto;

import java.util.Date;
import java.util.List;

public class Product{
	/*
	 * 이름      널?       유형            
------- -------- ------------- 
P_NO    NOT NULL NUMBER(10)    
P_NAME           VARCHAR2(100) 
P_DESC           VARCHAR2(200) 
P_DATE           DATE          
P_PRICE          NUMBER(10)    
P_IMG            VARCHAR2(100) 
P_CAT            VARCHAR2(100) 
	 */
	
	private int p_no;
	private String p_name;
	private String p_desc;
	private Date p_date;
	private int p_price;
	private String p_img;
	private String p_cat;
	private List<Review> reviewList;
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public Product(int p_no, String p_name, String p_desc, Date p_date, int p_price, String p_img, String p_cat,
			List<Review> reviewList) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_desc = p_desc;
		this.p_date = p_date;
		this.p_price = p_price;
		this.p_img = p_img;
		this.p_cat = p_cat;
		this.reviewList = reviewList;
	}
	
	@Override
	public String toString() {
		return "Product [p_no=" + p_no + ", p_name=" + p_name + ", p_desc=" + p_desc + ", p_date=" + p_date
				+ ", p_price=" + p_price + ", p_img=" + p_img + ", p_cat=" + p_cat + ", reviewList=" + reviewList + "]";
	}

	public int getP_no() {
		return p_no;
	}

	public void setP_no(int p_no) {
		this.p_no = p_no;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_desc() {
		return p_desc;
	}

	public void setP_desc(String p_desc) {
		this.p_desc = p_desc;
	}

	public Date getP_date() {
		return p_date;
	}

	public void setP_date(Date p_date) {
		this.p_date = p_date;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public String getP_cat() {
		return p_cat;
	}

	public void setP_cat(String p_cat) {
		this.p_cat = p_cat;
	}

	public List<Review> getReviewList() {
		return reviewList;
	}

	public void setReviewList(List<Review> reviewList) {
		this.reviewList = reviewList;
	}
	public String getReviewScoreAvg() {
		int i=0;
		String reviewScoreAvg="";
		if(this.reviewList==null || this.reviewList.size()==0) { reviewScoreAvg="리뷰가 없습니다.";
		}else {for(Review review : this.reviewList) {
			i+=review.getR_score();
		}
		
		reviewScoreAvg+=(double)i/(this.reviewList.size());
		
		}
		return reviewScoreAvg;
	}

	
	

}
