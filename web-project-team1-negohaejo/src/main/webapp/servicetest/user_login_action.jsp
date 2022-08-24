<%@page import="com.itwill.shop.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String s_u_id=request.getParameter("s_u_id");
	String u_password=request.getParameter("u_password");
	UserService userService = new UserService();

	int result=userService.login(s_u_id, u_password);
	
	/*
	 회원로그인
	 * 0:아이디 존재 안함
	 * 1:로그인성공
	 * 2:패스워드 불일치
	 */

	 if(result==1){
		 session.setAttribute("s_u_id", s_u_id);

		 response.sendRedirect("main.jsp");
	 }

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>user_login_action.jsp</h1>
로그인결과: <%=result%>

</body>
</html>
