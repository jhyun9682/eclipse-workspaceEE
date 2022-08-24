package com.itwill.shop.cart.test;

import com.itwill.shop.cart.CartItem;
import com.itwill.shop.cart.CartService;
import com.itwill.shop.product.Product;

public class CartServiceTestMain {

	public static void main(String[] args) throws Exception{
		CartService cartService=new CartService();
		CartItem cartItem=
				new CartItem(0, 4, 
						new Product(7, null, 0, null, null, 0), "guard1");
		cartService.addCart(cartItem);
		System.out.println("insert or update");
	}

}
