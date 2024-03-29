<%@page import="com.itwill.librarian.domain.*"%>
<%@page import="com.itwill.librarian.service.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String pageno=request.getParameter("pageno");
if(pageno==null||pageno.equals("")){
	pageno="1";
}
PageMakerDto<Notice> noticeListPage = new NoticeService().getNoticeList(Integer.parseInt(pageno));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/board.css" type="text/css">
<title>공지사항</title>
<script type="text/javascript">
	function noticeWrite() {
	f.action = "noticeWrite.jsp";
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
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>공지사항</b></td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="20" class="t1" align="right" valign="bottom">♠
										총 <font color="#FF0000"><%=noticeListPage.totRecordCount%></font>건
										 | 현재페이지( <font color="#FF0000"><%=noticeListPage.pageMaker.getCurPage()%></font>
										/ <font color="#0000FF"><%=noticeListPage.pageMaker.getTotPage()%></font>)
									</td>
								</tr>
							</table><br>
							
							<form name="f" method="post" action="">
							<table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
								<tr>
									<td width="70" align="center" bgcolor="E6ECDE">번호</td>
									<td width="360" align="center" bgcolor="E6ECDE">제목</td>
									<td width="120" align="center" bgcolor="E6ECDE">등록일</td>
									<td width="80" align="center" bgcolor="E6ECDE">조회수</td>
								</tr>
								<%for (Notice notice : noticeListPage.itemList) {%>
								<tr>
									<td width="60" align="center" bgcolor="ffffff"><%=notice.getNoticeNo()%></td>
									<td width="360" bgcolor="ffffff" style="padding-left: 10px" align="left">
										<a href="noticeView.jsp?noticeno=<%=notice.getNoticeNo()%>&pageno=<%=noticeListPage.pageMaker.getCurPage()%>">
										<%=notice.getNoticeTitle()%></a></td>
									<td width="120" align="center" bgcolor="ffffff">	<%=notice.getNoticeRegDate().toString().substring(0, 10)%></td>
									<td width="70" align="center" bgcolor="ffffff"><%=notice.getNoticeViews()%></td>
								</tr>
								<%}%>
							</table>
							</form>
							
							<table border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td align="right">
									<%
									Member sMember = (Member)session.getAttribute("sMember");
									if(sMember != null && sMember.getMemberNo() == 1) {
									%>
									<input type="button" value="공지사항 등록" onClick="noticeWrite()"></td>
									<%}%>
								</tr>
							</table><br>
							
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align="center">
										<%if (noticeListPage.pageMaker.getPrevGroupStartPage()>0) {%>
											<a href="./noticeList.jsp?pageno=1">◀◀</a>&nbsp;
										<%}%>
										<%if (noticeListPage.pageMaker.getPrevPage()>0) {%>
											<a href="./noticeList.jsp?pageno=<%=noticeListPage.pageMaker.getPrevPage()%>">◀</a>&nbsp;&nbsp;
										<%}%>
										<%
										 	for (int i = noticeListPage.pageMaker.getBlockBegin(); i <= noticeListPage.pageMaker.getBlockEnd(); i++) {
										 		if (noticeListPage.pageMaker.getCurPage() == i) {
										%>
													<font color="blue"><strong><%=i%></strong></font>&nbsp;
										<%	} else {%>
													<a href="./noticeList.jsp?pageno=<%=i%>"><strong><%=i%></strong></a>&nbsp;
										<%	}
											}%>
										   <%if (noticeListPage.pageMaker.getCurPage() < noticeListPage.pageMaker.getTotPage()) {%>
										   <a href="./noticeList.jsp?pageno=<%=noticeListPage.pageMaker.getNextPage()%>">▶</a>&nbsp;
										<%}%>
										 <%if (noticeListPage.pageMaker.getNextGroupStartPage()< noticeListPage.pageMaker.getTotPage()) {%>
										 <a href="./noticeList.jsp?pageno=<%=noticeListPage.pageMaker.getTotPage()%>">▶▶</a>&nbsp;
										<%}%>
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