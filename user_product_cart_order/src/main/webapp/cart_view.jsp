<%@page import="com.itwill.shop.cart.CartItem"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.shop.cart.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sUserId="guard1";
	CartService cartService=new CartService();
	List<CartItem> cartList = cartService.getCartList(sUserId);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%=cartList %>
</body>
</html>