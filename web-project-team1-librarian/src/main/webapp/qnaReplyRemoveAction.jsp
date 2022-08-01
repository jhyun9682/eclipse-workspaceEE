<%@page import="com.itwill.librarian.service.QnaService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	try{
		request.setCharacterEncoding("UTF-8");
		String replynoStr = request.getParameter("replyNo");
		int replyno = Integer.parseInt(replynoStr);
		QnaService qnaService = new QnaService();
		qnaService.removeReply(replyno);
		
		response.sendRedirect("qnaView.jsp?qnano=" +request.getParameter("qnaNo") + "&pageno=" + request.getParameter("pageNo"));
		
		
	}catch (Exception e){
		
	}

%>