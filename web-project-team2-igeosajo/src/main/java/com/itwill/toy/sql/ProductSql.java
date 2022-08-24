package com.itwill.toy.sql;

public class ProductSql {
	
	public static final String PRODUCT_SELECT_LIST=
			"select * from product p join category cg on p.cg_no=cg.cg_no";
	public static final String PRODUCT_SELECT_BY_P_NO=
			"select * from product p join category cg on p.cg_no=cg.cg_no where p.p_no=?";
			//"select * from product where p_no=?";
	
}
