<%@page import="com.itwill.librarian.service.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("noticeList.jsp");
}

try{
	NoticeService noticeService = new NoticeService();
	String noticeno = request.getParameter("noticeno");
	noticeService.removeNotice(Integer.parseInt(noticeno));
	out.println("<script>");
	out.println("alert('삭제되었습니다.');");
	out.println("location.href='noticeList.jsp'");
	out.println("</script>");
}catch(Exception e){
	e.printStackTrace();
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

</body>
</html>