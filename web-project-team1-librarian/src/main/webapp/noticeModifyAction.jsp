<%@page import="com.itwill.librarian.service.NoticeService"%>
<%@page import="com.itwill.librarian.domain.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

Notice notice = new Notice();
notice.setNoticeNo(Integer.parseInt(request.getParameter("noticeno")));
notice.setNoticeTitle(request.getParameter("title"));
notice.setNoticeFile(request.getParameter("fileone"));
notice.setNoticeContent(request.getParameter("content"));

NoticeService.getInstance().modifyNotice(notice);
String pageno = "1";
if (request.getParameter("pageno") != null) {
	pageno = request.getParameter("pageno");
}
// 목록으로 이동
response.sendRedirect("noticeList.jsp");
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