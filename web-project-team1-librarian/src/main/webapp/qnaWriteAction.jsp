<%@page import="com.itwill.librarian.service.QnaService"%>
<%@page import="com.itwill.librarian.domain.Qna"%>
<%@page import="java.io.File" %>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@page import="com.oreilly.servlet.MultipartRequest" %>
<%@ include file="memberLoginCheck.jspf"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("qnaList.jsp");
	}

	request.setCharacterEncoding("UTF-8");
	
	try{
		
		String directory = application.getRealPath("/upload/"+sMember.getMemberNo()+"/");
		
		File targetDir = new File(directory);
		if(!targetDir.exists()){
			targetDir.mkdirs();
		}
		
		int maxSize = 1024 * 1024 * 500;
		String encoding = "UTF-8";
		
		MultipartRequest multipartRequest
		= new MultipartRequest(request, directory, maxSize, encoding,
						new DefaultFileRenamePolicy());
		
		String fileName = multipartRequest.getOriginalFileName("fileone");
		
		String qnaTitle = multipartRequest.getParameter("title");
		String qnaContent = multipartRequest.getParameter("content");
		String qnaVisible = multipartRequest.getParameter("open");
		
	
		Qna qna = new Qna(0, Integer.parseInt(sMemberNo), qnaTitle, qnaContent, null, Integer.parseInt(qnaVisible), fileName, 0);
	
		QnaService qnaService = new QnaService();
		qnaService.addQna(qna);
		response.sendRedirect("qnaList.jsp");
		
		} catch (Exception e){
			e.printStackTrace();
		}
%>