<%@page import="com.itwill.shop.dto.Notice"%>
<%@page import="com.itwill.shop.service.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
Integer notino = null;
try {
	notino = Integer.valueOf(request.getParameter("notino"));
} catch (Exception e) {

}
if (notino == null) {
	response.sendRedirect("notice_list.jsp");
	return;
}
NoticeService noticeService = new NoticeService();
Notice notice = noticeService.selectByNo(notino);
if (notice == null) {
	response.sendRedirect("notice_list.jsp");
	return;
}
String pageno = "1";
if (request.getParameter("pageno") != null) {
	pageno = request.getParameter("pageno");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지수정</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/board.css" type="text/css">
<script>
	function noticeUpdate() {
		if (f.title.value == "") {
			alert("제목을 입력하십시요.");
			f.title.focus();
			return false;
		}
		if (f.content.value == "") {
			alert("내용을 입력하십시요.");
			f.content.focus();
			return false;
		}

		f.action = "notice_update_action.jsp";
		f.method = "post"
		f.submit();
	}
	function noticeView() {
		f.action = "notice_view.jsp?notino=" + notino;
		f.submit();
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_top.jsp" />
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp" />
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp; <b>공지사항 - 수정</b>
									</td>
								</tr>
							</table> <br> <!-- modify Form  -->
							<form name="f" method="post">
								<input type="hidden" name="pageno" value="<%=pageno%>" /> 
								<input type="hidden" name="notino" value="<%=notice.getNoti_no()%>">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">제목</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="text" name="title"
											value=<%=notice.getNoti_title()%>></td>
									</tr>
									<tr>
									<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><textarea name="content"
												style="width: 350px" rows="14"><%=notice.getNoti_content()%> </textarea></td>
									</tr>
									<tr>
										<td>첨부파일</td>
										<td><input type="text" name="notifile" placeholder="<%=notice.getNoti_file()%>"></td>
									</tr>
								</table>
							</form>

							<table width=590 border=0 cellpadding=0 cellspacing=0>
								<tr>
									<td align=center>
									<input type="button" value="수정" onClick="noticeUpdate()"> &nbsp; 
									<input type="button" value="취소" onClick="noticeView()"> &nbsp;
									</td>
								</tr>
							</table>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>