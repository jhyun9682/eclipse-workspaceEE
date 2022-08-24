<%@page import="com.itwill.shop.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.shop.dto.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.shop.service.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="user_login_check.jspf"%> 

<%

CartService cartService = new CartService();
List<Cart> cartList = cartService.getCartList(s_u_id);

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 보기</title>
</head>
<body>
<h1>cart_view.jsp</h1><hr>
<%for(Cart cart:cartList){ %>
	<%=cart%>
<%	}%>
</body>
</html>