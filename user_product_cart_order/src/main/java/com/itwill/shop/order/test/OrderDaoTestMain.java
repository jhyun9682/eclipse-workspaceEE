package com.itwill.shop.order.test;

import java.util.List;

import com.itwill.shop.order.Order;
import com.itwill.shop.order.OrderDao;

public class OrderDaoTestMain {

	public static void main(String[] args) throws Exception{
		OrderDao  orderDao=new OrderDao();
		List<Order> orderList=orderDao.list_detail("guard1");
		System.out.println(orderList);
	}

}
