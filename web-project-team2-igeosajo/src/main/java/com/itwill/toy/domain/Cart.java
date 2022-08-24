package com.itwill.toy.domain;
/*
이름    널?       유형           
----- -------- ------------ 
C_NO  NOT NULL NUMBER(10)   
C_QTY          NUMBER(10)   
P_NO           NUMBER(10)   
M_ID           VARCHAR2(50) 
 */
public class Cart {
	private int c_no;
	private int c_qty;
	
	/** Product */
	private Product product;
	
	/** Member */
	private Member member;
	
	public Cart() {
		// TODO Auto-generated constructor stub
	}

	public int getC_no() {
		return c_no;
	}

	public void setC_no(int c_no) {
		this.c_no = c_no;
	}

	public int getC_qty() {
		return c_qty;
	}

	public void setC_qty(int c_qty) {
		this.c_qty = c_qty;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Cart(int c_no, int c_qty, Product product, Member member) {
		super();
		this.c_no = c_no;
		this.c_qty = c_qty;
		this.product = product;
		this.member = member;
	}

	@Override
	public String toString() {
		return "Cart [c_no=" + c_no + ", c_qty=" + c_qty + ", product=" + product + ", member=" + member + "]";
	}
	
}
