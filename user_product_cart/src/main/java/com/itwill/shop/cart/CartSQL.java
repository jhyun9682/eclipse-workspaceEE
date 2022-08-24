package com.itwill.shop.cart;

public class CartSQL {
	/*
	 -- 로그인한 guard1 님의 카트아이템리스트
		select * from cart c join product p on c.p_no=p.p_no where c.userid='guard1';
	 --	로그인한 guard1 님이 카트에 카트아이템(제품)추가
	 	insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_seq.nextval,2,1,'guard1');
	
	----------- update -----------
	
	--로그인한 guard1 님의  카트에 제품번호1번 존재여부(0:insert , 1:update)
		select count(*) product_count from cart where userid='guard1' and p_no=1;
		
	--guard1 카트에 있는 1번제품의 수량증가
		update cart set cart_qty=cart_qty+2 where userid='guard1'  and p_no = 1;
	
	 */
	public static final String CART_SELECT_LIST_BY_USERID=
			"select * from cart c join product p on c.p_no=p.p_no where c.userid=?";
	public static final String CART_INSERT = 
			"insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_seq.nextval,?,?,?)";
	public static final String CART_UPDATE_BY_P_NO_USERID=
			"update cart set cart_qty=cart_qty+? where userid=?  and p_no = ?";
	public static final String CART_SELECT_PRODUCT_COUNT_BY_USERID_P_NO=
			"select count(*) product_count from cart where userid=? and p_no=?";
}
