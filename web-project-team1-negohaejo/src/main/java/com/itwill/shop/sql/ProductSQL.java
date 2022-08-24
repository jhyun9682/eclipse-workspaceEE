package com.itwill.shop.sql;

public class ProductSQL {
	public final static String selectall="select * from product2 p left outer join review r on r.p_no=p.p_no";
	public final static String select="select * from product2 p left outer join review r on r.p_no=p.p_no";
	public final static String selectbycat="select * from product2 p left outer join review r on r.p_no=p.p_no where p.p_cat=?";
	public final static String selectbyno="select * from product2 p left outer join review r on r.p_no=p.p_no where p.p_no=?";
}
