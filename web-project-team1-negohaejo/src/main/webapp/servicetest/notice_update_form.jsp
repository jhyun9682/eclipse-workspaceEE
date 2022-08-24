<%@page import="com.itwill.shop.dto.Notice"%>
<%@page import="com.itwill.shop.service.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Integer notino = null;
	try{
		notino=Integer.valueOf(request.getParameter("notino"));
	}catch(Exception e){
		
	}
	if(notino==null){
		response.sendRedirect("notice_list.jsp");
		return;
	}
	NoticeService noticeService = new NoticeService();
	Notice notice = noticeService.selectByNo(notino);
	if(notice==null){
		response.sendRedirect("notice_list.jsp");
		return;
	}
	String pageno="1";
	if(request.getParameter("pageno")!=null){
		pageno = request.getParameter("pageno");
	}
	
	
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function noticeUpdate(){
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
		
		f.action="notice_update_action.jsp";
		f.method="post"
		f.submit();
	}
	function noticeView(){
		f.action="notice_view.jsp?notino="+notino;
		f.submit();
	}

</script>
</head>
<body>
<h1>게시판수정</h1>
<form name="f" method="post">
	<input type="hidden" name="notino" value="<%=notice.getNoti_no()%>">
	<table>
	<tr>
		<td>제목</td>
	<td><input type="text" name="title" value="<%=notice.getNoti_title()%>"></td>
	</tr>
	<tr>
	<td>내용</td>
	<td><textarea name="content" class="textarea"><%=notice.getNoti_content()%> </textarea></td>
	</tr>
	<tr>
	<td>첨부파일</td>
	<td><input type="text" name="notifile" placeholder="<%=notice.getNoti_file()%>"></td>
	</tr>
	</table>
</form>
	<input type="button" value="수정" onClick="noticeUpdate()"> &nbsp;
	<input type="button" value="취소" onClick="noticeView()"> &nbsp;
</body>
</html>