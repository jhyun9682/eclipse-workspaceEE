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

String c_qtyStr = request.getParameter("c_qty");
String p_noStr = request.getParameter("p_no");
CartService cartService = new CartService();
cartService.addCart(s_u_id, Integer.parseInt(p_noStr), Integer.parseInt(c_qtyStr));
response.sendRedirect("cart_view.jsp");
%>
