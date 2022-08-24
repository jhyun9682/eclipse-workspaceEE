<%@page import="com.itwill.toy.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="login_check.jspf" %>    
<%
if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("shop_main.jsp");
	return;	
}
try{
	MemberService memberService=new MemberService();
	int removeRowCount=memberService.remove(sM_id);
	response.sendRedirect("member_logout_action.jsp");
}catch(Exception e){
	e.printStackTrace();
	response.sendRedirect("member_error.jsp");
}	
%>