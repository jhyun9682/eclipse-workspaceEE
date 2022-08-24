<%@page import="com.itwill.shop.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>user_login_form.jsp</h1>
<form method = 'get' action="user_login_action.jsp">
	아 이 디 : <input type="text" name="s_u_id"><br>
	비밀번호 :<input type="text" name="u_password"><br>
	<input type="submit">

</form>
</body>
</html>
