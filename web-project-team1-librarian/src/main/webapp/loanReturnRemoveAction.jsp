<%@page import="com.itwill.librarian.service.LoanService"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="memberLoginCheck.jspf" %>
<%
	String loanNo = request.getParameter("loanNo");
	
	try{
		LoanService loanService = new LoanService();
		
		int rowCount = loanService.removeLoan(Integer.parseInt(loanNo));
		
		response.sendRedirect("loanReturnList.jsp");
		return;
	} catch(Exception e) {
		e.printStackTrace();
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);	
	}
%>















