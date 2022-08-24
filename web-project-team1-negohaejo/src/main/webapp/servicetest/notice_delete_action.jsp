<%@page import="javax.websocket.SendResult"%>
<%@page import="com.itwill.shop.service.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("get")){
		response.sendRedirect("notice_list.jsp");
		return;
	}

	String notinoStr = request.getParameter("notino");
	NoticeService noticeService = new NoticeService();
	int deleteResult = noticeService.delete(Integer.parseInt(notinoStr));
	boolean result = false;
	String msg = "삭제실패";
	if(deleteResult==1) {
		result = true;
		msg = "삭제성공";
	}
%> 
<script type="text/javascript">
<%if(result){%>
	alert('<%=msg%>');
	location.href='notice_list.jsp?pageno=1';
<%}else{%>
	alert('<%=msg%>');
	location.href='notice_list.jsp?pageno=1';
<%}%>
</script>
