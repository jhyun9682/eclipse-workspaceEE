<%@page import="com.itwill.librarian.domain.Member"%>
<%@page import="com.itwill.librarian.service.MemberService"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("memberLogin.jsp");
		return;
	}

	String memberId = null;
	String password = null;
	
	try{
		memberId = request.getParameter("memberId");
		password = request.getParameter("password");
		
		MemberService memberService=new MemberService();
		
		Member loginMember = memberService.login(memberId, password);
		
		if(loginMember != null){
			session.setAttribute("sMemberNo", Integer.toString(loginMember.getMemberNo()));
			session.setAttribute("sMember", loginMember);
			
			response.sendRedirect("index.jsp");
		} else {
			String erorrMessage = URLEncoder.encode("아이디나 패스워드가 일치하지 않습니다", "UTF-8");
			response.sendRedirect("memberLogin.jsp?msg=" + erorrMessage);
		}
		
	}catch(Exception e){
		e.printStackTrace();
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	}
%>








