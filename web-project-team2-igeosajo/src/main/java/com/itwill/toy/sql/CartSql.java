package com.itwill.toy.sql;

public class CartSql {
	public static final String CART_SELECT_LIST_BY_USERID=
			"select * from cart c join member m on c.m_id=m.m_id join product p on p.p_no=c.p_no join category cg on p.cg_no=cg.cg_no where m.m_id=?";
	public static final String CART_SELECT_BY_CART_NO=
			"select * from cart c join product p on c.p_no=p.p_no where c_no=?";
	
	
	public static final String CART_IS_PRODUCT_EXIST=
			"select count(*)  as c_qty from cart c join member m on c.m_id=m.m_id where m.m_id=? and c.p_no=?";
	public static final String CART_ADD=
	"insert into cart(c_no,c_qty,p_no,m_id) values (cart_c_no_SEQ.nextval,?,?,?)";
	public static final String CART_ADD_UPDATE=
			"update cart set c_qty=c_qty + ? where p_no=? and m_id=?";
	public static final String CART_UPDATE=
			"update cart set c_qty=? where c_no=?";
	
	public static final String CART_DELETE_BY_CART_NO=
			"delete from cart where c_no=?";
	public static final String CART_DELETE_BY_USERID=
			"delete from cart where m_id=?";
	
	/*
	public static final String CART_INSERT=
			"insert into cart(cart_no,cart_qty,p_no,userid) values(cart_cart_no_SEQ.nextval,?,?,?)";
	public static final String CART_SELECT_LIST=
			"select c.*,p.* from cart c join product p on c.p_no=p.p_no where userid=?";
	public static final String CART_DELETE_BY_NO=
			"delete from cart where cart_no=?";
	public static final String CART_UPDATE_BY_CART_NO=
			"update cart set cart_qty=? where cart_no=?";
	public static final String CART_UPDATE_BY_PRODUCT_NO_USERID=
			"update cart set cart_qty=cart_qty+? where userid=? and p_no=?";
			
	public static final String CART_SELECT_BY_USERID_PRODUCT_NO=
					"select count(*) as cnt from cart where userid=? and p_no=?";
					*/
}



