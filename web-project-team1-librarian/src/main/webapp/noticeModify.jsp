<%@page import="com.itwill.librarian.service.NoticeService"%>
<%@page import="com.itwill.librarian.domain.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Integer noticeno = null;

try {
	noticeno = Integer.valueOf(request.getParameter("noticeno"));
} catch (Exception e) {
	
}

// 번호가 없으면 목록으로 이동
if (noticeno == null) {
	response.sendRedirect("noticeList.jsp");
	return;
}

Notice notice = NoticeService.getInstance().getNoticeDetail(noticeno);
// 게시글이 없으면 목록으로 이동
if (notice == null) {
	response.sendRedirect("noticeList.jsp");
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
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/board.css" type="text/css">
<title>공지사항 수정</title>
<script type="text/javascript">
	function noticeUpdate() {
		if (f.title.value == "") {
			alert("제목을 입력하십시오.");
			f.title.focus();
			return false;
		}
		if (f.content.value == "") {
			alert("내용을 입력하십시오.");
			f.content.focus();
			return false;
		}
		f.action = "noticeModifyAction.jsp?noticeno="+<%=noticeno%>+"&pageno="+<%=pageno%>;
		f.submit();
		}

	function noticeList() {
		f.action = "noticeList.jsp";
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
			<jsp:include page="includeCommonTop.jsp" />
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="includeCommonLeft.jsp" />
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
						<td><br>
							<table style="padding-left: 10px" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>공지사항 수정</b></td>
								</tr>
							</table><br>
							
							<form name="f" method="post">
								<input type="hidden" name="noticeno" value="<%=notice.getNoticeNo()%>"> 
								<input type="hidden" name="pageno" value="<%=pageno%>">
								<table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">제목</td>
										<td width="490" bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="title" value="<%=notice.getNoticeTitle()%>"></td>
									</tr>
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">파일 첨부</td>
										<td width="490" bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="file"  name="fileone" size=50 class="TXTFLD"></td>
									</tr>
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE">내용</td>
										<td width="490" bgcolor="ffffff" style="padding-left: 10px" align="left">
											<textarea name="content" class="textarea" style="width: 350px" rows="14">
											<%=notice.getNoticeContent()%></textarea></td>
									</tr>
								</table>
							</form>
							
							<table width="590" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td align="center">
									<input type="button" value="수정" onClick="noticeUpdate();"> &nbsp;
									<input type="button" value="목록" onClick="noticeList()">
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table><br>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="includeCommonBottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->		
</body>
</html>