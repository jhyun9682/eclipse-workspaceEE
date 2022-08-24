<%@page import="com.itwill.toy.domain.Qna"%>
<%@page import="com.itwill.toy.service.QnaService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>   
<%
if (request.getMethod().equalsIgnoreCase("GET")) {
	response.sendRedirect("qna_list.jsp");
}

	String no = request.getParameter("no");
	String title = request.getParameter("title");
	String content = request.getParameter("content");

	Qna qna = new Qna();
	qna.setM_id(sM_id);
	qna.setQ_title(title);
	qna.setQ_content(content);

	QnaService qnaService = new QnaService();
	qnaService.insertNewQna(qna);

	response.sendRedirect("qna_list.jsp");
%>