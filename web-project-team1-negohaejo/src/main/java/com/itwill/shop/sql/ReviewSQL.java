package com.itwill.shop.sql;

public class ReviewSQL {
	public final static String selectpno="select * from review where p_no=?";
	public final static String reviewavg="select avg(r_score) AVG from review where p_no=?";
}
