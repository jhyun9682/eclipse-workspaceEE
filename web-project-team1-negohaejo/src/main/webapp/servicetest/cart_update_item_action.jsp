<%@page import="com.itwill.shop.service.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="user_login_check.jspf"%> 
<%
if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("product_list.jsp");
	return;
}

String c_noStr = request.getParameter("c_no");
String c_qtyStr = request.getParameter("c_qty");
CartService cartService = new CartService();
if(c_qtyStr.equals("0")){
	cartService.deleteCart(Integer.parseInt(c_noStr));
}else{
	cartService.updateCart(Integer.parseInt(c_noStr), Integer.parseInt(c_qtyStr));
}
response.sendRedirect("cart_view_select_update_qty.jsp");
%>
