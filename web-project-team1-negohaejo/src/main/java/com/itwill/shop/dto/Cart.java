package com.itwill.shop.dto;

public class Cart {
	private int c_no;
	private int c_qty;
	private Product product;
	private String u_id;
	
	public Cart() {
		
	}

	public Cart(int c_no, int c_qty, Product product, String u_id) {
		super();
		this.c_no = c_no;
		this.c_qty = c_qty;
		this.product = product;
		this.u_id = u_id;
	}

	@Override
	public String toString() {
		return "Cart [c_no=" + c_no + ", c_qty=" + c_qty + ", product=" + product + ", u_id=" + u_id + "]";
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

	public String getU_id() {
		return u_id;
	}

	public void setU_id(String u_id) {
		this.u_id = u_id;
	}

	
	
	
	
}
