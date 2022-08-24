<%@page import="com.itwill.toy.service.QnaService"%>
<%@page import="com.itwill.toy.domain.Qna"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>   
<%
	if (request.getMethod().equalsIgnoreCase("GET")) {
		response.sendRedirect("qna_list.jsp");
	}

	Integer qnano = null;
	try {
		qnano = Integer.valueOf(request.getParameter("qnano"));
	} catch (Exception ex) {
	}
	//글번호가 없다면
	if (qnano == null) {
		//목록으로 이동
		response.sendRedirect("qna_list.jsp");
		return;
	}
	Qna qna = new QnaService().selectQna(qnano);
	if (qna == null) {
		response.sendRedirect("qna_list.jsp");
		return;
	}
	String pageno = "1";
	if (request.getParameter("pageno") != null) {
		pageno = request.getParameter("pageno");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>게시판</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/board.css" type="text/css">
 
<script type="text/javascript">
	function qnaUpdate() {
		if (f.title.value == "") {
			alert("제목을 입력하십시요.");
			f.title.focus();
			return false;
		}
		if (f.writer.value == "") {
			alert("작성자를 입력하십시요.");
			f.writer.focus();
			return false;
		}
		if (f.content.value == "") {
			alert("내용을 입력하십시요.");
			f.content.focus();
			return false;
		}

		f.action = "qna_modify_action.jsp";
		f.submit();
	}

	function boardList() {
		f.action = "qna_list.jsp";
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
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp; <b>게시판 -
											게시판 수정</b>
									</td>
								</tr>
							</table> <br> <!-- modify Form  -->
							<form name="f" method="post">
								<input type="hidden" name="pageno" value="<%=pageno%>" /> <input
									type="hidden" name="qnano" value="<%=qna.getQ_no()%>" />
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">제목</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="text" style="width: 150"
											name="title" value="<%=qna.getQ_title()%>"></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">작성자</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="text" style="width: 150"
											name="writer" value="<%=qna.getM_id()%>" readonly></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><textarea name="content"
												style="width: 350px" rows="14"><%=qna.getQ_content().replace("\n", ">>").trim()%></textarea></td>
									</tr>

								</table>
							</form>  

							<table width=590 border=0 cellpadding=0 cellspacing=0>
								<tr>
									<td align=center><input type="button" value="수정"
										onClick="qnaUpdate()"> &nbsp; <input type="button"
										value="리스트" onClick="boardList()"></td>
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