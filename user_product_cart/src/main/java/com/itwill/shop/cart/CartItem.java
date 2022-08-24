package com.itwill.shop.cart;

import com.itwill.shop.product.Product;
/*
VO(Value Object),DTO(Data Transfer Object)
	- cart 테이블 1개 row의 데이타의 값을 가지는객체
	- cart 테이블 1개 row의 데이타값을 이동(파라메타,리턴데이타)시키기위한객체 
	- cart 테이블의 컬럼과 동일한수의 멤버변수를가지는객체
*/
/*
이름       널?       유형            
-------- -------- ------------- 
CART_NO  NOT NULL NUMBER(10)    
CART_QTY          NUMBER(10)    
USERID            VARCHAR2(100) 
P_NO              NUMBER(10)  
 */

public class CartItem {
	private int cart_no;
	private int cart_qty;
	/*
	private int p_no;//FK
	*/
	private Product product;
	private String userid;//FK
	public CartItem() {
		// TODO Auto-generated constructor stub
	}
	public CartItem(int cart_no, int cart_qty, Product product, String userid) {
		super();
		this.cart_no = cart_no;
		this.cart_qty = cart_qty;
		this.product = product;
		this.userid = userid;
	}
	public int getCart_no() {
		return cart_no;
	}
	public void setCart_no(int cart_no) {
		this.cart_no = cart_no;
	}
	public int getCart_qty() {
		return cart_qty;
	}
	public void setCart_qty(int cart_qty) {
		this.cart_qty = cart_qty;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "CartItem [cart_no=" + cart_no + ", cart_qty=" + cart_qty + ", product=" + product + ", userid=" + userid
				+ "]";
	}
	
	
}











