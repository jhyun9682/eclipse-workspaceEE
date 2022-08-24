package com.itwill.shop.cart.test;
import com.itwill.shop.cart.CartDao;
import com.itwill.shop.cart.CartItem;
import com.itwill.shop.product.Product;

public class CartDaoTestMain {
	public static void main(String[] args) throws Exception{
		CartDao cartDao=new CartDao();
		System.out.println("--------cart list------");
		System.out.println(cartDao.getCartList("guard1"));
	
		System.out.println("--------cart product count(select)------");
		System.out.println(
		cartDao.cartProductCount(
				new CartItem(0,
							0,
							new Product(1, null, 0, null, null, 0),
							"guard1")));
		
		System.out.println("--------cart add(insert)------");
		//System.out.println(cartDao.add(new CartItem(0, 5, new Product(2, null, 0, null, null, 0), "guard1")));
		System.out.println("--------cart add(update)------");
		System.out.println(cartDao.updateByProductNoAndUserId(
				new CartItem(0,
							 3,
							 new Product(1, null, 0, null, null, 0),
							 "guard1")));
		
	}
}
