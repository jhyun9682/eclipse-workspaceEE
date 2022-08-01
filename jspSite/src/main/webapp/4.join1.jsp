<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	 * GET방식으로 요청이 들어오면 4.form1.jsp로 방향재지정(redirection) 
	 */
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("4.form1.jsp");
		return;
	}
	/*
	 * 0.요청객체인코딩설정
	 */
	request.setCharacterEncoding("UTF-8");

	/*
	 * 1.파라메타받기
	 */
	String id=request.getParameter("id");
	String password=request.getParameter("password");
	String email1=request.getParameter("email1");
	String email2=request.getParameter("email2");
	String email=email1+"@"+email2;
	String gender=request.getParameter("gender");
	String[] favorites=request.getParameterValues("favorite");
	if(favorites==null){
		favorites=new String[1];
		favorites[0]="관심사항없음";
	}
	String message=request.getParameter("message");
	message=message.replace("\n", "<br>");
	/*
	 * 2.Service객체가입메쏘드호출
	 */
	/*
	 * 3.클라이언트로 응답출력
	 */
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>가입정보</h1><hr>
<ul>
	<li>아이디:<%=id %>
	<li>패쓰워드:<%=password %>
	<li>이메일:<%=email %>
	<li>성별:<%=gender %>
	<li>관심영역
		<ol>
			<%for(String favorite:favorites){ %>
			<li><%=favorite%>
			<%}%>
		</ol>
	<li>가입인사:<%=message %>	
</ul>
</body>
</html>


















