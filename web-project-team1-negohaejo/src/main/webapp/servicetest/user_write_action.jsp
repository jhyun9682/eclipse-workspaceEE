
<%@page import="com.itwill.shop.dto.User"%>
<%@page import="com.itwill.shop.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   	String u_id = request.getParameter("u_id");
   	String u_password = request.getParameter("u_password");
   	String u_name = request.getParameter("u_name");
   	String u_birth = request.getParameter("u_birth");
   	String u_gender = request.getParameter("u_gender");
   	String u_phone = request.getParameter("u_phone");
   	String u_address = request.getParameter("u_address");
   	UserService userService = new UserService();
   	
   	int result = userService.create(new User(u_id,u_password,u_name,u_birth,u_gender,u_phone,u_address));
   	out.println("결과"+result);
   
   
   %>
   