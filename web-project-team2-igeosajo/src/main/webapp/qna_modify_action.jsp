<%@page import="com.itwill.toy.domain.Qna"%>
<%@page import="com.itwill.toy.service.QnaService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>   
<%
	if (request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("qna_list.jsp");
	}

	String pageno = "1";
	if (request.getParameter("pageno") != null) {
		pageno = request.getParameter("pageno");
	}

	String noStr = request.getParameter("qnano");
	int no = Integer.parseInt(noStr);
	String title = request.getParameter("title");
	String content = request.getParameter("content");
	
	Qna qna = new Qna();
	qna.setQ_no(no);
	qna.setQ_title(title);
	qna.setQ_content(content);
	
	QnaService qnaService = new QnaService();
	qnaService.updateQna(qna); 
	
	response.sendRedirect("qna_list.jsp?" + pageno);

%>
