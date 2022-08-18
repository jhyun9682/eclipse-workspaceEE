<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("sUserId", "www");
	request.setAttribute("sUserId", "xxx");
	session.setAttribute("sUserId", "yyy");
	application.setAttribute("sUserId", "zzz");
	

	request.setAttribute("name", "제임스딘");
	request.setAttribute("age", new Integer(34));
	request.setAttribute("age", 29);
	request.setAttribute("wight", 69.235);
	request.setAttribute("married", true);
	double height=175.69;
	String address="서울시민";

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL String,Wrapper객체(기본형객체) 출력</h1>
<ol>
	<li>${sUserId}</li>
	<li>${name}</li>
	<li>${age}</li>
	<li>${wight}</li>
	<li>${married}</li>
	<li>EL출력불가능[속성객체아니므로]</li>
	<li>${height}</li>
	<li>${address}</li>
</ol>
</body>
</html>










