<%@page import="com.itwill.shop.dto.User"%>
<%@page import="javax.jws.soap.SOAPBinding.Use"%>
<%@page import="com.itwill.shop.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
		<%
		String s_u_id=(String)session.getAttribute("s_u_id");
		UserService userService=new UserService();
	User loginUser=userService.findUser(s_u_id);
%>
<h1>
	<a href="">메인으로</a>
	<% if(s_u_id!=null){%><p>
	<%=loginUser.getU_id() %>님로그인 <a href='user_logout_action'>로그아웃</a></P>
	<%}else{ %><p>로그인안됨</p><%}%>
	<form method='get' action='product_list.jsp'>
		검색--<input type='text' name='keyword'><br> 
		<input type='submit' value='검색'>
	</form>
</h1>
