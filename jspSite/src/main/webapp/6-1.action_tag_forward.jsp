<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	System.out.println("6-1.action_forward.jsp");

	/*
	forwarding 
		- 6-1.action_tag_forwarded.jsp로 HTTP 요청을 보냄
	  
	*/
	RequestDispatcher rd = request.getRequestDispatcher("6-1.action_tag_forwarded.jsp");
	rd.forward(request, response);
%>
<%-- 
<jsp:forward page="6-1.action_tag_forwarded.jsp"/>
--%>