<%@page import="com.itwill.toy.service.MemberService"%>
<%@page import="com.itwill.toy.domain.Member"%>
<%@page import="java.net.URLEncoder"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("member_write_form.jsp");
		return;
	}
	String m_id=request.getParameter("m_id");
	String m_password=request.getParameter("m_password");
	String m_name=request.getParameter("m_name");
	String m_email=request.getParameter("m_email");
	String m_birth=request.getParameter("m_birth");
	String m_gender=request.getParameter("m_gender");
	String m_address=request.getParameter("m_address");
	String m_phone=request.getParameter("m_phone");
	int m_point=Integer.parseInt(request.getParameter("m_point"));
		MemberService memberService=new MemberService();
		Member newMember=new Member(m_id,m_password,m_name,m_email,m_birth,m_gender,m_address,m_phone,1000);
		int result = memberService.create(newMember);
		if(result == -1){
			//아이디 중복
			String msg = m_id+" 는 이미존재하는 아이디입니다.";
			request.setAttribute("msg", msg);
			request.setAttribute("fmember",newMember);
%>
	 <jsp:forward page="member_write_form.jsp"/>

<% 
		}else if (result == 1){
			//회원가입 성공
			out.println("<script>");
			out.println("alert('"+m_id+"님 가입 축하합니다. 신규회원 1000포인트 적립 되었습니다.');");
			out.println("location.href='member_login_form.jsp';");
			out.println("</script>");
		}
		
	
%>