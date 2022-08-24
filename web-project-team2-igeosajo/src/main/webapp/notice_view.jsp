<%@page import="com.itwill.toy.domain.Notice"%>
<%@page import="com.itwill.toy.service.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Integer noticeno = null;
int pageno = 1;

try {
	noticeno = Integer.parseInt(request.getParameter("noticeno"));
	pageno = Integer.parseInt(request.getParameter("pageno"));
} catch (Exception e) {
	
}

// 번호가 없으면 목록으로 이동 
if (noticeno == null){
	response.sendRedirect("notice_list.jsp?pageno="+pageno);
	return;
}

NoticeService noticeService = new NoticeService();
Notice notice = noticeService.selectNoticeDetail(noticeno);
// 게시글이 없으면 목록으로 이동
if (notice == null){
	response.sendRedirect("notice_list.jsp?pageno="+pageno);
}

// 조회수 증가
noticeService.updateNoticeReadCount(noticeno);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/board.css" type="text/css">
<title>공지사항</title>
<script type="text/javascript">
	function noticeList() {
		location.href='notice_list.jsp?pageno=<%=pageno%>';
		return;
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
						<td><br>
							<table style="padding-left: 10px" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>공지사항 보기</b></td>
								</tr>
							</table><br>
							
							<form name="f" method="post">
								<input type="hidden" name="noticeno" value="<%=notice.getN_no()%>">
								<input type="hidden" name="pageno" value="<%=pageno%>">
								<table border="0" cellpadding="0" cellspacing="1" width="590px" bgcolor="BBBBBB">
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">제목</td>
										<td width="490" bgcolor="ffffff" style="padding-left: 10px" align="left">
											<%=notice.getN_title()%></td> 
									</tr>
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">등록일</td>
										<td width="490" bgcolor="ffffff" style="padding-left: 10px" align="left">
											<%=notice.getN_date().toString().substring(0, 10)%></td>
									</tr>
									<%--if(notice.getNoticeFile() != null){ --%>
									<!-- 
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">첨부파일</td>
										<td width="490" bgcolor="ffffff" style="padding-left: 10px" align="left">
											<%--=notice.getNoticeFile()--%></td>
									</tr>
									<%--} --%>
									 -->
									<tr>
										<td width="100" align="center" bgcolor="E6ECDE" height="22">내용</td>
										<td width="490" bgcolor="ffffff" height="180px" style="padding-left: 10px" align="left">
											<%=notice.getN_content().replace("\n", "<br/>")%></td>
									</tr>
								</table>
							</form>
							
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td align="center">
									<%--
									Member sMember = (Member)session.getAttribute("sMember");
									if(sMember != null && sMember.getMemberNo() == 1) {
									--%>
									<%--}--%>
									<input type="button" value="목록" onclick="noticeList()">
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
			<jsp:include page="include_common_bottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->				
</body>
</html>