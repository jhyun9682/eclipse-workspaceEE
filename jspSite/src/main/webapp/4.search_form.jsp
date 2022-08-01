<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>검색</h3><hr/>
<!-- 
form tag
 - 요청시 전송되는 데이타를 묶어주는 단위
 - form 안에 있는 데이타들은 요청시 쿼리스트링으로 만들어져서 서버로 전송된다.
    ex> name=kim&phone=12324&address=seoul
 - action:요청할 URL(서블릿URL)
 - method:요청방법
 -->
	<form action="4.search_result.jsp" method="get">
		검색어:<input type="text" name="searchkeyword">
		<!--
		 4.search_result.jsp?searchkeyword=java   요청==>  String searchkeyword=request.getParameter("searchkeyword");
		<< submit button >>
			- form안에 존재해야하며
			- submit 버튼클릭시에 자기가 속해있는 폼의 데이타모두를 쿼리스트링형태로변경해서 
			  action url 에 ?를 사용해서추가한후  기술되어있는 서블릿으로 요청한다[GET방식요청].
			  ex> http://localhost/servletSite/4.search_result.jsp?searchkeyword=java
	 	-->
		<input type="submit" value="검색요청">
	</form>
</body>
</html>
