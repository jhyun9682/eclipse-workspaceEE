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
CartService cartService = new CartService();
cartService.deleteCart(Integer.parseInt(c_noStr));
response.sendRedirect("cart_view.jsp");
%>