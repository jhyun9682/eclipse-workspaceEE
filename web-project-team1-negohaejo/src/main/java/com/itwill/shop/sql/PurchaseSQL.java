package com.itwill.shop.sql;

public class PurchaseSQL {
	
	//아이디로 결제 조회
	public static final String PURCHASE_SELECT_LIST_BY_U_ID="select * from purchase where u_id=?";
	//아이디로 디테일 까지
	public static final String PURCHASE_SELECT_LIST_DETAIL_BY_U_ID="select * from purchase pur join purchase_item puri on pur.o_no=puri.o_no join product2 p on puri.p_no=p.p_no  where u_id=?";
	//주문번호로 결제 조회
	public static final String PURCHASE_SELECT_LIST_O_NO="select * from purchase pur join purchase_item puri on pur.o_no=puri.o_no join product2 p on puri.p_no=p.p_no  where pur.o_no=?";

	
	//주문 번호 및 결제정보 생성
	public static final String PURCHASE_CREATE="insert into purchase(o_no, o_itemlistnum, o_payselect, o_itemtotprice, u_id) values (o_o_no_SEQ.nextval, ?, ?, ?, ?)";
	public static final String PURCHASE_ITEM_CREATE="insert into purchase_item(OI_NO,OI_QTY,O_NO,P_NO) values (oi_oi_no_SEQ.nextval,?,o_o_no_SEQ.currval,?)";

	//주문번호로 주문 삭제
	public static final String PURCHASE_DELETE_BY_O_NO="delete from purchase where o_no=?";
	
	//아이디 주문 전체 삭제
	public static final String PURCHASE_DELETE_BY_U_ID="delete from purchase where u_id=?";
	
}