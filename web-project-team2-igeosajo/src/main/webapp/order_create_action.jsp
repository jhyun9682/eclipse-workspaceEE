<%@page import="java.util.HashMap"%>
<%@page import="com.itwill.toy.service.MemberService"%>
<%@page import="com.itwill.toy.service.OrderService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>   
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("order_list.jsp");
		return;
	}
	
	String p_noStr=request.getParameter("p_no");
	String p_qtyStr=request.getParameter("p_qty");
	String[] cart_item_no_strArray=request.getParameterValues("cart_item_no");
	String u_pointStr = request.getParameter("use_point");
	String t_priceStr = request.getParameter("t_price");

	OrderService orderService = new OrderService(); 
	MemberService memberService = new MemberService(); 

	// 적립금 사용 여부 확인 
	boolean isUsePoint = false;
	if((u_pointStr != "" && u_pointStr != null && !u_pointStr.equals("0"))) { 
		isUsePoint = true;
	}
	
	// 적립금 사용시
	if(isUsePoint){
		// 주문 총 금액 차감 
		int t_price = Integer.parseInt(t_priceStr);
		int u_point = Integer.parseInt(u_pointStr);
		t_priceStr = orderService.deductionTotalPrice(t_price, u_point) + ""; 		
		
		// 회원 적립금 변경
		int result_point = sMember.getM_point() - u_point;
		sMember.setM_point(result_point);
		memberService.updatePoint(sMember);
	}

	// 주문 정보 map에 저장 
	HashMap<String, String> order_info_map = new HashMap<>(); 
	order_info_map.put("t_price", t_priceStr);
	order_info_map.put("sM_id", sM_id);
	order_info_map.put("rv_name", request.getParameter("rv_name"));
	order_info_map.put("rv_phone", request.getParameter("rv_phone"));
	order_info_map.put("rv_addr", request.getParameter("rv_addr"));
	order_info_map.put("rv_message", request.getParameter("rv_message"));
	
	if(cart_item_no_strArray != null){
		//장바구니에서 주문 
		orderService.create(cart_item_no_strArray, order_info_map);   
	}else{ 
		// 직접 주문
		orderService.create(p_noStr, p_qtyStr, order_info_map);  
	}
	
	response.sendRedirect("order_list.jsp");
	 
%>