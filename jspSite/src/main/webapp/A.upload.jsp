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
/*
생성자 
MultipartRequest(javax.servlet.http.HttpServletRequest request,
				 java.lang.String saveDirectory, 
				 int maxPostSize, 
				 java.lang.String encoding)
*/
	String saveDirectory="C:\\upload";
	int maxPostSize=1024*1024*100;
	String encoding="UTF-8";
	
	/*
		- DefaultFileRenamePolicy : 똑같은 이름을가진파일이 존재한다면 파일명(숫자) 1,2,3..를 붙여서 저장해주는 클래스
		- FileRenamePolicy        : 똑같은 이름을가진파일이 존재한다면 사용자가 만든이름을 적용시킬수있게해주는 클래스
	*/
	
	MultipartRequest multipartRequest=
		new MultipartRequest(request,saveDirectory,maxPostSize,encoding,new DefaultFileRenamePolicy());	
	/*
	파라메타가존재하지않는다
	String name=request.getParameter("name");
	*/
	String name= multipartRequest.getParameter("name");
	String fileone = multipartRequest.getFilesystemName("fileone");
	String filetwo = multipartRequest.getFilesystemName("filetwo");
%>
<h1>Upload Data</h1>
<hr/>
<br/>
<br/>
<br/>
<li>name:<%=name %></li>
<li>fileone:<%=fileone %></li>
<li>filetwo:<%=filetwo %></li>
