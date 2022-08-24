package com.itwill.shop.order.test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.itwill.shop.cart.CartDao;
import com.itwill.shop.cart.CartItem;
import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderDao;
import com.itwill.shop.order.OrderItem;
import com.itwill.shop.product.Product;
import com.itwill.shop.product.ProductDao;

public class OrderDaoCreateTestMain {

	public static void main(String[] args) throws Exception{
		OrderDao orderDao=new OrderDao();
		CartDao cartDao=new CartDao();
		ProductDao productDao=new ProductDao();
		System.out.println(">>>>> 1.상품에서직접주문");
		/*
		  1.상품에서직접주문
		     - 상품번호 1번
		     - 상품수량 1개
		*/  
		int p_no=6;
		int p_qty=1;
		
		List<OrderItem> orderItemList=new ArrayList<OrderItem>();
		Product product=productDao.selectByNo(p_no);
		orderItemList.add(new OrderItem(0, p_qty, 0, product));
		
		Order newOrder=
				new Order(0,
						orderItemList.get(0).getProduct().getP_name()+"외 "+(orderItemList.size()-1)+"종",
						null,
						product.getP_price()*p_qty,
						"guard1",
						orderItemList);
		orderDao.create(newOrder);
		
		System.out.println(">>>>> 2.cart에서 cartitem 전체주문");
		/*
		  2.cart에서 cartitem 전체주문
		  	- 로그인한 guard1님이 주문
		*/
		
		List<CartItem> cartItemList=cartDao.getCartList("guard1");
		orderItemList=new ArrayList<OrderItem>();
		
		/*
		 * CartItem-->OrderItem
		 */
		
		int order_price=0;
		for (CartItem cartItem : cartItemList) {
			orderItemList.add(new OrderItem(0, cartItem.getCart_qty(), 0, cartItem.getProduct()));
			order_price+=cartItem.getCart_qty()*cartItem.getProduct().getP_price();
		}
		
		newOrder=
				new Order(0,
						orderItemList.get(0).getProduct().getP_name()+"외 "+(orderItemList.size()-1)+"종",
						null,
						order_price,
						"guard1",
						orderItemList);
		orderDao.create(newOrder);
		
		cartDao.deleteCart("guard1");
		
	}

}
