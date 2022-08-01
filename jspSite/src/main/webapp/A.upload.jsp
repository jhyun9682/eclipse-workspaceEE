<%--@page import="com.oreilly.servlet.MultipartRequest"--%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("A.file_upload.jsp");
	return;
}

String 	saveDirectory="C:\\upload";
int maxPostSize=1024*1024*100;
String encoding="UTF-8";
/*
-DefaultFileRenamePolicy:똑같은 이름을 가진 파일이 존재한다면 파일명(숫자) 1,2,3을 붙여서 저장해주는 클래스
-FileRenamePolicy:똑같은 이름을 가진 파일이 존재한다면 사용자가 만든이름을 적용시킬수 있게해주는 클래스
*/

MultipartRequest multipartRequest=
new MultipartRequest(request,saveDirectory,maxPostSize,encoding,new DefaultFileRenamePolicy());

String name= multipartRequest.getParameter("name");
String fileone=multipartRequest.getFilesystemName("fileone");
String filetwo=multipartRequest.getFilesystemName("filetwo");
%>
<h1>Upload Data</h1>
<hr/>
<br/>
<br/>
<br/>
<li>name:<%=name %></li>
<li>fileone:<%=fileone %></li>
<li>filetwo:<%=filetwo %></li>
