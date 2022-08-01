<%@page import="com.itwill.librarian.domain.LeaveMember"%>
<%@page import="com.itwill.librarian.service.LeaveMemberService"%>
<%@page import="com.itwill.librarian.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="memberLoginCheck.jspf" %>    
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("index.jsp");
		return;	
	}

	try {
		String opinion = getInitParameter("opinion");
		
		MemberService memberService = new MemberService();
		LeaveMemberService leaveMemberService = new LeaveMemberService();
		
		Member leaveMember = memberService.getMember(Integer.parseInt(sMemberNo));
		
		int rowCount = memberService.removeMember(leaveMember.getMemberNo());
		rowCount = leaveMemberService.addLeaveMember(new LeaveMember(leaveMember.getMemberId(), opinion));
		
		response.sendRedirect("memberLogoutAction.jsp");
	} catch(Exception e) {
		e.printStackTrace();
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	}	
%>