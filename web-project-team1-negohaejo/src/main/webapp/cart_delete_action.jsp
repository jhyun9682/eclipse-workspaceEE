<%@page import="com.itwill.shop.dto.User"%>
<%@page import="com.itwill.shop.service.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="login_check.jspf"%>     
<%
if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("product_list.jsp");
	return;
}

CartService cartService = new CartService();
cartService.deleteCart(s_u_id);
response.sendRedirect("cart_view.jsp");
%>
