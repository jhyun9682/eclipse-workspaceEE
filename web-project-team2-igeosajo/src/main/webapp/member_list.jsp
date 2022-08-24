<%@page import="com.itwill.toy.domain.Member"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.toy.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    MemberService memberService = new MemberService();
    
    List<Member> memberList = memberService.findAll();
    
    
    out.println(memberList);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>