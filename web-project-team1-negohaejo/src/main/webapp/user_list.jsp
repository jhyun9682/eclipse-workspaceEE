<%@page import="com.itwill.shop.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.shop.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    UserService userService = new UserService();
    
    List<User> userList = userService.findAll();
    
    out.println(userList);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>