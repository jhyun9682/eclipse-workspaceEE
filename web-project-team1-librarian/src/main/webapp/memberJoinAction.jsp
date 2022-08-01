<%@page import="com.itwill.librarian.service.MemberService"%>
<%@page import="com.itwill.librarian.domain.Member"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("index.jsp");
		return;
	}

	String memberId = request.getParameter("memberId");
	String password = request.getParameter("password");
	String name = request.getParameter("name");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	
	Member newMember = null;
	
	try{
		newMember = new Member(memberId, password, name, phone, email);
		MemberService memberService = new MemberService();
		
		int rowCount = memberService.addMember(newMember);
		
		if(rowCount == 1) {
			response.sendRedirect("memberLogin.jsp");
		} else {
			String errorMessage = URLEncoder.encode("는 이미존재하는 아이디입니다.","UTF-8");
	    	response.sendRedirect("memberJoin.jsp?msg=" + errorMessage);			
		}
	} catch(Exception e) {
		e.printStackTrace();
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);	
	}
%>















