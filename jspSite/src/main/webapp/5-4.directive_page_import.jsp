
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.student.StudentService"%>
<%@page import="com.itwill.student.StudentDao"%>
<%@page import="com.itwill.student.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

	Student student1=new Student();
	Student student2=new Student();
	StudentDao studentDao=new StudentDao();
	StudentService studentService=new StudentService();
	
	List<String> nameList=new ArrayList<String>();
	nameList.add("김태희");
	nameList.add("김민종");
	nameList.add("이소라");
	HashMap map=new HashMap();

%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>page 지시어 [import]</h1>
<h2>형태:&lt;%@page import="com.itwill.Student"&gt;</h2>
<hr/>
<ul>
	<li><%=student1%></li>
	<li><%=student2%></li>
	<li><%=studentDao%></li>
	<li><%=studentService%></li>
	<li><%=nameList%></li>
	<li><%=map%></li>
	
</ul>
</body>
</html>
