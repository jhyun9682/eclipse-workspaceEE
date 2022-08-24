package com.itwill.toy.domain;

import java.util.Date;

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


public class Product {
	private int p_no;
	private String p_name;
	private int p_price;
	private String p_image;
	private String p_desc;
	private Date p_date;
	private Category category;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int p_no, String p_name, int p_price, String p_image, String p_desc, Date p_date,
			Category category) {
		super();
		this.p_no = p_no;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_image = p_image;
		this.p_desc = p_desc;
		this.p_date = p_date;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [p_no=" + p_no + ", p_name=" + p_name + ", p_price=" + p_price + ", p_image=" + p_image
				+ ", p_desc=" + p_desc + ", p_date=" + p_date + ", category=" + category + "]";
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

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_image() {
		return p_image;
	}

	public void setP_image(String p_image) {
		this.p_image = p_image;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
