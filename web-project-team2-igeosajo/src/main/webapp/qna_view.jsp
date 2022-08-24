<%@page import="com.itwill.toy.domain.Qna"%>
<%@page import="com.itwill.toy.service.QnaService"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="login_check.jspf"%> 
<%
	Integer qnano = null;
	int pageno = 1;
	
	try {
		qnano = Integer.parseInt(request.getParameter("qnano"));
		pageno = Integer.parseInt(request.getParameter("pageno"));
	}catch(Exception e){
		
	}
	
	if (qnano == null){
		//목록으로 이동
		response.sendRedirect("qna_list.jsp?pageno="+pageno);
		return;
	}
	
	QnaService qnaService = new QnaService();
	Qna qna = qnaService.selectQna(qnano);
	
	//조회수 증가
	qnaService.updateReadCount(qnano);
	
%>    
    
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<link rel=stylesheet href="css/cart.css" type="text/css">
<script language="JavaScript">
	function qnaUpdate() {
		f.action = "qna_modify_form.jsp";
		f.submit();
	}
	
	function qnaDelete() {
		if (confirm("정말 삭제하시겠습니까?")) {
			f.action = "qna_delete_action.jsp";
			f.submit();
		}
	}
	
	function boardReplyCreate() {
		document.f.action = "qna_reply_write.jsp";
		document.f.method='POST';
		document.f.submit();
	}
	
	function qnaList() {
		f.action = "qna_list.jsp?pageno=" +<%=pageno%>;
		f.submit(); 
	}
	
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<form id="xxx">
		<input type="hidden" name="a"> <input type="hidden" name="b">
	</form>
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
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp; <b> 게시물
											내용보기 </b>
									</td>
								</tr>
							</table> <!-- view Form  -->
							<form name="f" method="post">
								<input type="hidden" name="qnano" value="<%=qna.getQ_no()%>"> 
								<input type="hidden" name="memberno" value="<%=qna.getM_id()%>"> 
								<input type="hidden" name="pageno" value="<%=pageno%>">
								<%-- <input type="hidden" name="fileone" value="<%=qna.getQnaFile()%>"> --%>
								<table border="0" cellpadding="0" cellspacing="1" width="590px"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">작성자</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left">
											<%=qna.getM_id() %>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">제목</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><%=qna.getQ_title()%></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">작성일자</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><%=qna.getQ_date().toString().substring(0, 10)%></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
										<td width=490 bgcolor="ffffff" height="180px"
											style="padding-left: 10px" align="left"><%=qna.getQ_content().replace("\n", "<br/>")%><br />

										</td>
									</tr>
								</table>

							</form> 
							<table border=0 cellpadding=0 cellspacing=0>
								<tr>
									<td align=right>
										<%
											if(sM_id.equals(qna.getM_id())){
										%>
											<input type="button" value="수정" onClick="qnaUpdate()"> &nbsp; 
											<input type="button" value="삭제" onClick="qnaDelete()"> &nbsp; 
										<%
											}
										%>
									<input type="button" value="답글쓰기" onClick="boardReplyCreate()"> &nbsp; 
									<input type="button" value="목록" onClick="qnaList()"></td>
								</tr>
							</table>
							<br>
	
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