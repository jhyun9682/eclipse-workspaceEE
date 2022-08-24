<%@page import="com.itwill.shop.dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.shop.dto.Purchase_Item"%>
<%@page import="com.itwill.shop.dto.Cart"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.shop.service.CartService"%>
<%@page import="com.itwill.shop.dto.Purchase"%>
<%@page import="com.itwill.shop.service.PurchaseService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>     
    <%
    if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("order_list.jsp");
		return;
	}
    String o_payselect = request.getParameter("o_payselect");
	String[] cart_item_no_strArray=request.getParameterValues("cart_item_no");
    PurchaseService purchaseService=new PurchaseService();
    purchaseService.p_Create(s_u_id, o_payselect);
    response.sendRedirect("order_list.jsp");
    
    %>
