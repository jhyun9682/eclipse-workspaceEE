<%@page import="com.itwill.shop.dto.Notice"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.shop.service.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    		NoticeService noticeService = new NoticeService();
    		List<Notice> noticeList=noticeService.selectAll();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_search_top_form.jsp"/>
			<!-- include_common_top.jsp end-->
		</div>
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp"/>
			<!-- include_common_left.jsp end-->
		</div>
		<div id="notice">
		<%for(Notice notice : noticeList) {%>
		<li><a href='notice_detail.jsp?=<%=notice.getNoti_no()%>'><%=notice.getNoti_title()%></a></li>
		<% }%>
		</div>
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>

</body>
</html>