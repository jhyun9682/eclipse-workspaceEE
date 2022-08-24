package com.itwill.toy.sql;

public class OrderItemSql {
	/*
	이름     널?       유형         
	------ -------- ---------- 
	OI_NO  NOT NULL NUMBER(10) 
	OI_QTY          NUMBER(10) 
	O_NO            NUMBER(10) 
	P_NO            NUMBER(10) 
	*/
	public static final String ORDER_ITEM_CREATE =
	"insert into order_item(oi_no, oi_qty, o_no, p_no) values(order_item_oi_no_SEQ.nextval, ?, orders_o_no_SEQ.currval, ?)";
}
