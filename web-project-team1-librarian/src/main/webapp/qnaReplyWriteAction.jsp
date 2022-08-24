<%@page import="com.itwill.librarian.service.QnaService"%>
<%@page import="com.itwill.librarian.domain.Reply"%>
<%@ include file="qnaLoginIdCheck.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	if(sMember == null || sMemberNo == null){
		out.println("<script>");
		out.println("alert('로그인이 필요합니다.');");
		out.println("location.href='memberLogin.jsp';");
		out.println("</script>");
		return;
	}

	if(request.getMethod().equals("GET")){
		response.sendRedirect("qnaList.jsp");
	}

	try{
		request.setCharacterEncoding("UTF-8");
		QnaService qnaService = new QnaService();
		
		int qnano = Integer.parseInt(request.getParameter("qnano"));
		String content = request.getParameter("content");
		
		Reply reply = new Reply(0, content, qnano , Integer.parseInt(sMemberNo));
		qnaService.addReply(reply);
		
		response.sendRedirect("qnaView.jsp?qnano=" +qnano + "&pageno=" + request.getParameter("pageno"));
		
	}catch (Exception e){
		
	}

%>

