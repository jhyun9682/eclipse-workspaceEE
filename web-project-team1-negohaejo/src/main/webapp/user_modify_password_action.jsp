<%@page import="com.itwill.shop.service.UserService"%>
<%@page import="com.itwill.shop.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("main.jsp");
	return;
}

String u_id = request.getParameter("u_id");
String u_password = request.getParameter("u_password");

User modipassUser = new User(u_id,u_password,null,null,null,null,null);

UserService userService = new UserService();

int updatePasswordUser = userService.updatePassword(modipassUser);

response.sendRedirect("user_logout_action.jsp");

%>