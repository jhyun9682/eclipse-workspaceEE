<%@page import="javax.websocket.SendResult"%>
<%@page import="com.itwill.shop.dto.Notice"%>
<%@page import="com.itwill.shop.service.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
if (request.getParameter("notino") == null || request.getParameter("notino") == "") {
	response.sendRedirect("notice_list.jsp");
	return;
}
String pageno = request.getParameter("pageno");
if (pageno == null || pageno.equals("")) {
	pageno = "1";
}
NoticeService noticeService = new NoticeService();
Notice notice = noticeService.selectByNo(Integer.parseInt(request.getParameter("notino")));
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/board.css" type="text/css">
<script type="text/javascript">
	function noticeCreate(){
		f.action="notice_write_form.jsp"
		f.submit();
	}
	function noticeUpdate(){
		f.action = "notice_update_form.jsp";
		f.submit();
	}
	function noticeList(){
		f.action = "notice_list.jsp"
		f.submit();
	}
	function noticeDelete(){
		if(confirm("정말삭제하시겠습니까?")){
		f.action="notice_delete_action.jsp"
		}
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
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp; <b>
											게시글상세 </b>
									</td>
								</tr>
							</table> <br> <!-- view Form  -->

							<form name="f" method="post">
								<input type="hidden" name="notino" value="<%=notice.getNoti_no()%>">
								<input type="hidden" name="pageno" value="<%=pageno%>">
								<table border="0" cellpadding="0" cellspacing="1" width="590" bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">제목</td>
										<td width=490 bgcolor="ffffff" align="left" style="padding-left: 10"><%=notice.getNoti_title()%></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
										<td width=490 bgcolor="ffffff" align="left" style="padding-left: 10"><%=notice.getNoti_content().replace("\n","<br/>")%></td>
										
									</tr>
								</table>
							</form>
							<table width=590 border=0 cellpadding=0 cellspacing=0>
								<tr>
									<td align=center>
									<input type="hidden" value="글쓰기" onClick="noticeCreate()"> &nbsp; 
									<input type="hidden" value="수정" onClick="noticeUpdate()">&nbsp; 
									<input type="hidden" value="삭제" onClick="noticeDelete()">&nbsp; 
									<input type="button" value="리스트" onClick="noticeList()"></td>
								</tr>
							</table></td>
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