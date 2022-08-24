package com.itwill.shop.sql;

public class CartSQL {

	public static final String CART_SELECT_LIST_BY_USERID = "select * from cart c join userinfo u on c.u_id=u.u_id join product2 p on p.p_no=c.p_no where u.u_id=?";

	public static final String CART_SELECT_BY_CART_NO = "select * from cart c join product2 p on c.p_no=p.p_no where c_no=?";

	public static final String CART_IS_PRODUCT_EXIST = "select count(*) as c_qty from cart c join userinfo u on c.u_id=u.u_id where u.u_id=? and c.p_no=?";

	public static final String CART_ADD = "insert into cart(c_no,u_id,p_no,c_qty) values (cart_cart_no_SEQ.nextval,?,?,?)";

	public static final String CART_ADD_UPDATE = "update cart set c_qty=c_qty + ? where u_id=? and p_no=?";

	public static final String CART_UPDATE = "update cart set c_qty=? where c_no=?";

	public static final String CART_DELETE_BY_CART_NO = "delete from cart where c_no=?";

	public static final String CART_DELETE_BY_USERID = "delete from cart where u_id=?";

}
