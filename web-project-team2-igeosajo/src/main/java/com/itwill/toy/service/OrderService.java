package com.itwill.toy.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.itwill.toy.dao.CartDao;
import com.itwill.toy.dao.OrderDao;
import com.itwill.toy.dao.ProductDao;
import com.itwill.toy.domain.Cart;
import com.itwill.toy.domain.Order;
import com.itwill.toy.domain.OrderItem;
import com.itwill.toy.domain.Product;

public class OrderService {
	private OrderDao orderDao;
	private ProductDao productDao;
	private CartDao cartDao; 

	public OrderService() throws Exception {
		orderDao = new OrderDao();
		productDao = new ProductDao();
		cartDao = new CartDao();
	}
	
	/*
	 * 주문 생성(장바구니)
	 */
	public int create(String[] cart_item_no_strArray, HashMap<String, String> order_info_map) throws Exception {
		ArrayList<Cart> cartList = new ArrayList<>(); 
		ArrayList<OrderItem> orderItemList = new ArrayList<>(); 
		
		for(String c_noStr : cart_item_no_strArray){
			int c_no = Integer.parseInt(c_noStr);
			// 주문한 카트번호의 카트 객체 cartList에 저장
			cartList.add(cartDao.getCartItemByCartNo(c_no));
			// 주문한 카트목록 삭제 
			cartDao.deleteCartByNo(c_no);
		}
		
		// cartList의 cart객체 정보 orderItem에 세팅 후 orderItemList에 저장 
		for(Cart cart : cartList){
			OrderItem orderItem = new OrderItem(); 
			orderItem.setOi_qty(cart.getC_qty()); 
			orderItem.setProduct(cart.getProduct()); 
			orderItemList.add(orderItem); 
		}
		
		// 주문이름 생성 
		String order_desc = orderItemList.get(0).getProduct().getP_name();
		int size = orderItemList.size();
		if(size > 1) {
			order_desc += " 외 " + (size-1) + "건";
		}
		
		// Order 객체 생성
		Order order = new Order(); 
		order.setO_desc(order_desc); 
		order.setO_price(Integer.parseInt(order_info_map.get("t_price"))); 
		order.setO_rv_name(order_info_map.get("rv_name"));
		order.setO_rv_phone(order_info_map.get("rv_phone"));
		order.setO_rv_address(order_info_map.get("rv_addr"));
		order.setO_message(order_info_map.get("rv_message"));
		order.setM_Id(order_info_map.get("sM_id")); 
		order.setOrderItemList(orderItemList); 
		
		return orderDao.create(order);
	}

	/*
	 * 주문 생성(직접주문)
	 */
	public int create(String p_noStr, String p_qtyStr, HashMap<String, String> order_info_map) throws Exception {
		ArrayList<OrderItem> orderItemList = new ArrayList<>(); 
		
		// 상품번호와 수량정보 orderitem객체에 세팅 후 orderItemList에 저장   
		Product product = productDao.getProduct(Integer.parseInt(p_noStr));
		OrderItem orderItem = new OrderItem(); 
		orderItem.setOi_qty(Integer.parseInt(p_qtyStr)); 
		orderItem.setProduct(product); 
		orderItemList.add(orderItem); 
		
		// 주문이름 생성 
		String order_desc = orderItemList.get(0).getProduct().getP_name();
		
		// Order 객체 생성
		Order order = new Order(); 
		order.setO_desc(order_desc); 
		order.setO_price(Integer.parseInt(order_info_map.get("t_price"))); 
		order.setO_rv_name(order_info_map.get("rv_name"));
		order.setO_rv_phone(order_info_map.get("rv_phone"));
		order.setO_rv_address(order_info_map.get("rv_addr"));
		order.setO_message(order_info_map.get("rv_message"));
		order.setM_Id(order_info_map.get("sM_id"));
		order.setOrderItemList(orderItemList);
		
		return orderDao.create(order);
	}
	
	/*
	 * 적립금 사용시 주문 총 금액 차감
	 */
	public int deductionTotalPrice(int t_price, int u_point) {
		return t_price - u_point;
	}
	
	/*
	 * 주문 1개 삭제
	 */
	public int deleteByOrderNo(int o_no) throws Exception {
		return orderDao.deleteByOrderNo(o_no);
	}

	/*
	 * 주문전체삭제
	 */
	public int delete(String sM_id) throws Exception {
		return orderDao.delete(sM_id);
	}

	/*
	 * 주문목록
	 */
	public ArrayList<Order> list(String sM_id) throws Exception {
		return orderDao.list(sM_id);
	}

	/*
	 * 주문상세보기
	 */
	public Order detail(String sM_id, int o_no) throws Exception {
		return orderDao.detail(sM_id, o_no);
	}

}
