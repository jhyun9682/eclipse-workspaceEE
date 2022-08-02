package com.itwill.shop.order;

public class OrderSQL {
	/*
	 insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_seq.nextval,'비글외1종',sysdate,1550000,'guard1');
	 insert into order_item(oi_no,oi_qty,o_no,p_no)  values(order_item_oi_no_seq.nextval,1,orders_o_no_seq.currval,1);
	 */
	public static final String ORDER_INSERT=
			"insert into orders(o_no,o_desc,o_date,o_price,userid) values (orders_o_no_seq.nextval,?,sysdate,?,?)";
	
	public static final String ORDER_ITEM_INSERT=
			"insert into order_item(oi_no,oi_qty,o_no,p_no)  values(order_item_oi_no_seq.nextval,?,orders_o_no_seq.currval,?)";
	
	public static final String ORDER_ORDER_ITEM_PRODUCT_LIST=
			" select * from orders o"
			+" join order_item oi on o.o_no=oi.o_no"
			+" join product p on oi.p_np=p.p_no"
			+" where o.userid=?";
	
	public static final String ORDER_ORDER_ITEM_PRODUCT_BY_ORDER_NO="";
	
}