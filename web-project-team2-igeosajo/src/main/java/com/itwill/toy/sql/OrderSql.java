package com.itwill.toy.sql;

public class OrderSql {
		/*
		이름           널?       유형            
		------------ -------- ------------- 
		O_NO         NOT NULL NUMBER(10)    
		O_DESC                VARCHAR2(100) 
		O_DATE                DATE          
		O_PRICE               NUMBER(10)    
		O_RV_NAME             VARCHAR2(10)  
		O_RV_PHONE            VARCHAR2(20)  
		O_RV_ADDRESS          VARCHAR2(50)  
		O_MESSAGE             VARCHAR2(200) 
		M_ID                  VARCHAR2(50)  
		*/
	public static final String ORDER_CREATE =
			"insert into orders(o_no, o_desc, o_date, o_price,o_rv_name, o_rv_phone, o_rv_address, o_message, m_id) "
			+ " values(orders_o_no_SEQ.nextval, ?, sysdate, ?, ?, ?, ?, ?, ?)";
	//로그인한멤버의 주문전체목록
	public static final String ORDER_SELECT_LIST_BY_M_ID =
			"select * from orders where m_id=? order by o_no desc"; 
	//로그인한멤버의 주문한개목록
	public static final String ORDER_SELECT_BY_O_NO =
			"select * from orders o join order_item oi on o.o_no=oi.o_no join product p on oi.p_no=p.p_no where o.m_id=? and o.o_no=?";
	//로그인한 멤버의 주문 한개 삭제
	public static final String ORDER_DELETE_BY_ORDER_NO =
			"delete from orders where o_no=?";
	//로그인한 멤버의 주문 전체 삭제
	public static final String ORDER_DELETE_BY_M_ID =
			"delete from orders where m_id=?";

}

