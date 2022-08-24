<%@page import="com.itwill.toy.service.QnaService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.itwill.toy.service.QnaService"%>
<%@ include file="login_check.jspf" %>   
<%
	Integer qnano = null;
	Integer pageno = null;
	try {
		qnano = Integer.valueOf(request.getParameter("qnano"));
		pageno = Integer.valueOf(request.getParameter("pageno"));
	} catch (Exception ex) {
		
	}
	boolean result = true;
	String msg = "";
	if (qnano == null) {
		result = false;
		msg = "삭제실패";
	} else {
		try {
			new QnaService().deleteQna(qnano);
			result = true;
			msg = "삭제성공";
		} catch (Exception e) {
			result = false;
			msg = "삭제실패:" + e.getMessage();
		}
	}
%>
<script type="text/javascript">
<%if (result) {%>
	alert('<%=msg%>');
	location.href='qna_list.jsp?pageno=<%=pageno%>';
<%} else {%>
	alert('<%=msg%>');
	location.href='qna_list.jsp?pageno=<%=pageno%>';
<%}%>
	
</script>
