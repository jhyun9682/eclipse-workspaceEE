package com.itwill.shop.dao.test;

import com.itwill.shop.dao.CartDao;

public class CartDaoTestMain {

	public static void main(String[] args) throws Exception{
		CartDao cartDao = new CartDao();
		//System.out.println("제품추가:"+cartDao.add("test1", 5, 1));
		System.out.println("아이디로 조회:"+cartDao.getCartList("test1"));
		//System.out.println("카트번호로 조회:"+cartDao.getCartByCartNo(1));
		//System.out.println("수량추가:"+cartDao.update("test1", 1, 2));
		//System.out.println("수량변경:"+cartDao.update(1, 1));
		//System.out.println("아이디로 카트삭제:"+cartDao.deleteCart("test2"));
		System.out.println("카트번호로 삭제:"+cartDao.deleteCart(3));
		
		
		
		
		
		
		

	}

}
