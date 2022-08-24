package com.itwill.toy.dao.test;

import java.util.ArrayList;

import com.itwill.toy.dao.CartDao;
import com.itwill.toy.dao.OrderDao;
import com.itwill.toy.domain.Cart;
import com.itwill.toy.domain.Order;
import com.itwill.toy.domain.OrderItem;

public class OrderDaoTestMain {
	
	public static void main(String[] args) throws Exception{
		OrderDao orderDao = new OrderDao();
		System.out.println(orderDao.list("wpig1"));
		System.out.println(orderDao.detail("wpig1", 7));
		
		ArrayList<OrderItem> orderItemList = new ArrayList<OrderItem>();
		CartDao cartDao = new CartDao();
		ArrayList<Cart> itemList = cartDao.getCartList("toto");
		for(Cart cart : itemList) {
			OrderItem oi = new OrderItem();
			oi.setOi_qty(cart.getC_qty());
			oi.setProduct(cart.getProduct());
			orderItemList.add(oi);
		}
		
		Order order = new Order();
		order.setO_desc("주문설명");
		order.setO_price(10000);
		order.setO_rv_name("수령자명");
		order.setO_rv_phone("01000");
		order.setO_rv_address("배송지입니다");
		order.setO_message("메세지입니다");
		order.setM_Id("toto");
		order.setOrderItemList(orderItemList);
		
		System.out.println(order);
		
		orderDao.create(order);

	}
}
