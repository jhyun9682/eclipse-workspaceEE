<%@page import="com.itwill.shop.service.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	NoticeService noticeService = new NoticeService();
	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function noticeCreate(){
		if(f.title.value==""){
			alert("제목을 입력하십시요.");
			f.title.focus();
			return false;
		}
		if(f.content.value==""){
			alert("내용을 입력하십시요.");
			f.content.focus();
			return false;
		}
		
		f.action = "notice_write_action.jsp"
		f.method = "POST";
		f.submit();
	}
	
	function noticeList(){
		f.action = "notice_list.jsp"
		f.submit();
	}
</script>
</head>
<body>
<h1>게시판쓰기</h1>
<form name="f" method="post">
	<table>
	<tr>
		<td>제목</td>
	<td><input type="text" name="title"></td>
	</tr>
	<tr>
	<td>내용</td>
	<td><textarea name="content" class="textarea"> </textarea></td>
	</tr>
	</table>
</form>
	<input type="button" value="쓰기" onClick="noticeCreate()"> &nbsp;
	<input type="button" value="목록" onClick="noticeList()"> &nbsp;
	

</body>
</html>