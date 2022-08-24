<%@page import="com.itwill.librarian.service.LoanService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="memberLoginCheck.jspf" %>
<%
	String loanNo = request.getParameter("loanNo");
	String bookNo = request.getParameter("bookNo");
	
	try{
		LoanService loanService = new LoanService();
		
		int rowCount = loanService.modifyLoan(Integer.parseInt(loanNo), bookNo, Integer.parseInt(sMemberNo));
		
		response.sendRedirect("loanList.jsp");
		return;
	} catch(Exception e) {
		e.printStackTrace();
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);	
	}
%>















