<%@page import="com.itwill.librarian.service.QnaService"%>
<%@page import="com.itwill.librarian.domain.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equals("GET")){
		response.sendRedirect("qnaList.jsp");
	}
	
	try{
		request.setCharacterEncoding("UTF-8");
		
		String qnano = request.getParameter("qnano");
		String memberno = request.getParameter("memberno");
		String title = request.getParameter("title");
		String open = request.getParameter("open");
		String fileone = request.getParameter("fileone");
		String content = request.getParameter("content");
		Qna qna = new Qna();
		
		qna.setQnaNo(Integer.parseInt(qnano));
		qna.setMemberNo(Integer.parseInt(memberno));
		qna.setQnaTitle(title);
		qna.setQnaVisible(Integer.parseInt(open));
		qna.setQnaFile(fileone);
		qna.setQnaContent(content);
		
		QnaService qnaService = new QnaService();
		qnaService.modifyQna(qna);
		String pageno = "1";
		if (request.getParameter("pageno") != null) {
			pageno = request.getParameter("pageno");
		}
		response.sendRedirect(
				String.format("qnaView.jsp?qnano=&pageno=", qna.getQnaNo(), pageno));
		
	}catch (Exception e){
		
	}

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





