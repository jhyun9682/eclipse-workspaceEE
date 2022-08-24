<%@page import="com.itwill.toy.domain.Member"%>
<%@page import="com.itwill.toy.service.MemberService"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("shop_main.jsp");
		return;
	}
	String m_id = request.getParameter("m_id");
	String m_password = request.getParameter("m_password");
	
	MemberService memberService = new MemberService();
	int result = memberService.login(m_id, m_password);

	/*
	 회원로그인
	 * 0:비밀번호 틀림
	 * 1:로그인성공
	 * 2:존재하지 않는 아이디
	 */
	if (result == 1) {
		session.setAttribute("sM_id", m_id);
		session.setAttribute("sMember", memberService.findMember(m_id));
		response.sendRedirect("shop_main.jsp");
	} else if (result == 2) {
		out.println("<script>");
		out.println("alert('" + m_id + " 는 존재하지않는 아이디입니다');");
		out.println("location.href='member_login_form.jsp';");
		out.println("</script>");
	} else if (result == 0) {
		out.println("<script>");
		out.println("alert('패스워드가 일치하지않습니다.');");
		out.println("location.href='member_login_form.jsp';");
		out.println("</script>");
	}
%>
