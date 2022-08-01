<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String searchKeyword=
			request.getParameter("searchKeyword"); 
	if(searchKeyword==null || searchKeyword.equals("")){
		response.sendRedirect("7-0.cookie_search.jsp");
		return;
	}
	/*************응답객체를 사용해서 클라이언트에 쿠키전송***********/
	/*
		1.Cookie객체생성
	*/
	String searchKeyword1=URLEncoder.encode(searchKeyword,"UTF-8");
	Cookie searchKeywordCookie=new Cookie("searchKeyword",searchKeyword1);
	
	/*
	    2.쿠키객체설정(setMaxAge)
	       - 쿠키의유효기간설정(파일로저장)
	       - 쿠키의유효기간설정안하면(메모리에저장)
	 */
	searchKeywordCookie.setMaxAge(60*60*24*365); 
	/*
		3.응답객체에 쿠키추가
	*/
	response.addCookie(searchKeywordCookie);
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>검색결과[쿠키생성]</h1><hr>
<div>니안에 쿠키있다.</div>
<ol>
	
	<%
	int no=(int)(Math.random()*10);
	for(int i=0;i<no;i++){
	%>
	<li><%=searchKeyword%> 검색결과</li>
	<%
	}
	%>
</ol>
<div>
	<a href='7-0.cookie_search.jsp'>다시검색[쿠키읽기]</a>
	<a href='7-0.cookie_delete.jsp'>쿠키삭제</a>
</div>
</body>
</html>















