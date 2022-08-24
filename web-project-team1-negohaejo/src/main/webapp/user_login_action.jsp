<%@page import="com.itwill.shop.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String u_id=request.getParameter("u_id");
	String u_password=request.getParameter("u_password");
	//s_u_id="nana";
	//u_password="nana";
	UserService userService = new UserService();

	int result=userService.login(u_id, u_password);
	
	/*
	 회원로그인
	 * 0:아이디 존재 안함
	 * 1:로그인성공
	 * 2:패스워드 불일치
	 */

	 if(result==1){
		 session.setAttribute("s_u_id", u_id);

		 response.sendRedirect("main.jsp");
	 }else if(result==0){
		 //response.sendRedirect("user_login_form.jsp");
			out.println("<script>");
			out.println("alert('"+u_id+" 는 존재하지않는 아이디입니다');");
			out.println("location.href='user_login_form.jsp';");
			out.println("</script>");
	 }else if(result==2){
		 //response.sendRedirect("user_login_form.jsp");
		  out.println("<script>");
			out.println("alert('패쓰워드가 일치하지않습니다.');");
			out.println("location.href='user_login_form.jsp';");
			out.println("</script>");
	 }

%>


