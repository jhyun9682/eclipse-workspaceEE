<%@page import="com.itwill.shop.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
	String u_id = "test2";	
 
 	if(request.getMethod().equalsIgnoreCase("GET")){
 		response.sendRedirect("main.jsp");
 		return;
 	}
 
	UserService userService = new UserService();
	
	int removeUser = userService.remove(u_id);
	
	response.sendRedirect("main.jsp");
	
	
	%>
 