<%@page import="javax.websocket.SendResult"%>
<%@page import="com.itwill.shop.dto.Notice"%>
<%@page import="com.itwill.shop.service.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getParameter("notino")==null || request.getParameter("notino")==""){
		response.sendRedirect("notice_list.jsp");
		return;
	}
	String pageno=request.getParameter("pageno");
	if(pageno==null||pageno.equals("")){
		pageno="1";
	}
	NoticeService noticeService = new NoticeService();
	Notice notice = noticeService.selectByNo(Integer.parseInt(request.getParameter("notino")));
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function notice_update(){
		f.action = "notice_update_form.jsp";
		f.submit();
	}
	function notice_list(){
		f.action = "notice_list.jsp"
		f.submit();
	}
	function notice_delete(){
		f.action="notice_delete_action.jsp"
		f.method="post"
		f.submit();
	}
</script>
</head>
<body>
<table>
<tr>
	<td><%=notice.getNoti_no() %></td>
	<td><%=notice.getNoti_title()%></td>
	<td><%=notice.getNoti_content()%></td>
	<td><%=notice.getNoti_date() %></td>
	<td><%=notice.getNoti_file() %></td>
</tr>
</table>
<form name="f" method = "post" >
<input type="hidden" name="notino" value="<%=notice.getNoti_no() %>">
</form>
<input type="button" value="수정" onClick="notice_update()">
<input type="button" value="목록" onClick="notice_list()">
<input type="button" value="삭제" onClick="notice_delete()">
</body>
</html>