package com.itwill.shop.dto;

import java.util.List;

public class Purchase{
	private int o_No;
	private int o_ItemListNum;
	private String o_PaySelect;
	private int o_ItemTotPrice;
	private String u_ID;
	private List<Purchase_Item> purchase_Itemlist;
	public Purchase(int o_No, int o_ItemListNum, String o_PaySelect, int o_ItemTotPrice, String u_ID,
			List<Purchase_Item> purchase_Itemlist) {
		super();
		this.o_No = o_No;
		this.o_ItemListNum = o_ItemListNum;
		this.o_PaySelect = o_PaySelect;
		this.o_ItemTotPrice = o_ItemTotPrice;
		this.u_ID = u_ID;
		this.purchase_Itemlist = purchase_Itemlist;
	}
	
	public Purchase() {
		
	}
	@Override
	public String toString() {
		return "Purchase [o_No=" + o_No + ", o_ItemListNum=" + o_ItemListNum + ", o_PaySelect=" + o_PaySelect
				+ ", o_ItemTotPrice=" + o_ItemTotPrice + ", u_ID=" + u_ID + ", purchase_Itemlist=" + purchase_Itemlist
				+ "]";
	}
	public int getO_No() {
		return o_No;
	}
	public void setO_No(int o_No) {
		this.o_No = o_No;
	}
	public int getO_ItemListNum() {
		return o_ItemListNum;
	}
	public void setO_ItemListNum(int o_ItemListNum) {
		this.o_ItemListNum = o_ItemListNum;
	}
	public String getO_PaySelect() {
		return o_PaySelect;
	}
	public void setO_PaySelect(String o_PaySelect) {
		this.o_PaySelect = o_PaySelect;
	}
	public int getO_ItemTotPrice() {
		return o_ItemTotPrice;
	}
	public void setO_ItemTotPrice(int o_ItemTotPrice) {
		this.o_ItemTotPrice = o_ItemTotPrice;
	}
	public String getU_ID() {
		return u_ID;
	}
	public void setU_ID(String u_ID) {
		this.u_ID = u_ID;
	}
	public List<Purchase_Item> getPurchase_Itemlist() {
		return purchase_Itemlist;
	}
	public void setPurchase_Itemlist(List<Purchase_Item> purchase_Itemlist) {
		this.purchase_Itemlist = purchase_Itemlist;
	}
	
	
}