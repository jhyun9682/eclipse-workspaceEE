<%@page import="com.itwill.librarian.domain.Qna"%>
<%@page import="com.itwill.librarian.service.QnaService"%>
<%@ include file="qnaLoginIdCheck.jspf"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	Integer qnano=null;
	
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("qnaList.jsp");
	}
	
	try{
		String membernoStr = request.getParameter("memberno");
		Qna qna = new Qna();
		qnano=Integer.valueOf(request.getParameter("qnano"));
		
		QnaService qnaService = new QnaService();
		qnaService.removeQna(qnano);
		response.sendRedirect("qnaList.jsp");
	}catch(Exception e){
		e.printStackTrace();
	}
%>