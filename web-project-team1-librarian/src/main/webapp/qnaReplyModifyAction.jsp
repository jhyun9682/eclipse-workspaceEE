<%@page import="com.itwill.librarian.service.QnaService"%>
<%@page import="com.itwill.librarian.domain.Reply"%>
<%@ include file="qnaLoginIdCheck.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");

	try{
		String content = request.getParameter("content");
		int replyno = Integer.parseInt(request.getParameter("replyno"));
		int memberno = Integer.parseInt(request.getParameter("memberno"));
		int qnano = Integer.parseInt(request.getParameter("qnano"));
		
		
		Reply reply = new Reply(replyno,content,qnano,memberno);
		QnaService qnaService = new QnaService();
		qnaService.modifyReply(reply);
		
		response.sendRedirect("qnaView.jsp?qnano=" +request.getParameter("qnano") + "&pageno=" + request.getParameter("pageno"));
		
	}catch(Exception e){
		
	}

%>


