<%@ page contentType="text/html; charset=UTF-8" %>
<!-- 
1.자동생성되는 서블릿파일의 위치
	C:\2022-05-JAVA-DEVELOPER\eclipse-workspaceEE
	\.metadata\.plugins\org.eclipse.wst.server.core
	\tmp0\work\Catalina\localhost\jspSite\org\apache\jsp
	
2.자동생성되는 서블릿파일의 이름
	_1_hello_jsp.java
 -->

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%for(int i=0;i<5;i++){%>
		<h3>Hello[안녕] JSP[change]</h3>
		<hr/>
	<%}%>
<%@include file="5-6.directive_included_file.jspf" %>	
</body>
</html>
