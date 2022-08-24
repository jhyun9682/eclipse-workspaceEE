<%@page import="com.itwill.librarian.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="memberLoginCheck.jspf"%>
<%
	if (request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("index.jsp");
		return;
	}
	
	try {
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		MemberService memberService = new MemberService();
		Member member = new Member(Integer.parseInt(sMemberNo), name, password, phone, email);
		
		int updateRowCount = memberService.modifyMember(member);
		
		response.sendRedirect("memberMyInfo.jsp");
		
	} catch (Exception e) {
		e.printStackTrace();
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	}
%>






