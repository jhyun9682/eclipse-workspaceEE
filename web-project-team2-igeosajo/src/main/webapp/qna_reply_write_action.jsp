<%@page import="com.itwill.toy.service.QnaService"%>
<%@page import="com.itwill.toy.domain.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//Qna객체를 생성하고 입력된데이타를 읽어서 객체에저장
	Qna qna = new Qna();
	/*
	원글qnano
	*/
	qna.setQ_no(
			Integer.parseInt(request.getParameter("qnano")));
	/*
	답글 데이타
	*/
	qna.setQ_title(request.getParameter("title"));
	qna.setM_id(request.getParameter("writer"));
	qna.setQ_content(request.getParameter("content"));
	new QnaService().insertReply(qna);
	
	String pageno = "1";
	if(request.getParameter("pageno")!=null){
		pageno=request.getParameter("pageno");
	}
	response.sendRedirect(
			String.format("qna_list.jsp?pageno=%s",pageno));
	
%>