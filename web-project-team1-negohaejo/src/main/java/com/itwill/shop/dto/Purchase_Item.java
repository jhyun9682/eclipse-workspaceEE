package com.itwill.shop.dto;

public class Purchase_Item {
private int oi_No;
private int oi_Qty;
private int o_No;
private Product product;
public Purchase_Item(int oi_No, int oi_Qty, int o_No, Product product) {
	super();
	this.oi_No = oi_No;
	this.oi_Qty = oi_Qty;
	this.o_No = o_No;
	this.product = product;
}
@Override
public String toString() {
	return "Purchase_Item [oi_No=" + oi_No + ", oi_Qty=" + oi_Qty + ", o_No=" + o_No + ", product=" + product + "]";
}
public int getOi_No() {
	return oi_No;
}
public void setOi_No(int oi_No) {
	this.oi_No = oi_No;
}
public int getOi_Qty() {
	return oi_Qty;
}
public void setOi_Qty(int oi_Qty) {
	this.oi_Qty = oi_Qty;
}
public int getO_No() {
	return o_No;
}
public void setO_No(int o_No) {
	this.o_No = o_No;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}

}
