
<%@page import="com.itwill.toy.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>     
<%
	if(request.getMethod().equals("GET")){
		response.sendRedirect("shop_main.jsp");
		return;
	}
	
		String m_password=request.getParameter("m_password");
		String m_name=request.getParameter("m_name");
		String m_email=request.getParameter("m_email");
		String m_birth=request.getParameter("m_birth");
		String m_gender=request.getParameter("m_gender");
		String m_address=request.getParameter("m_address");
		String m_phone=request.getParameter("m_phone");
		int m_point = Integer.parseInt(request.getParameter("m_point"));
		Member member=new Member(sM_id,m_password,m_name,m_email,m_birth,m_gender,m_address,m_phone,0);
		MemberService memberService=new MemberService();
		int updateRowCount=memberService.updateAll(member);
		
		response.sendRedirect("member_view.jsp");
	
%>