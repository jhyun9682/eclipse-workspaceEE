<%@page import="com.itwill.toy.domain.Qna"%>
<%@page import="com.itwill.toy.domain.PageMakerDto"%>
<%@page import="com.itwill.toy.service.QnaService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="login_check.jspf"%>
<%!
public String getTitleString(Qna qna) {
		StringBuilder title = new StringBuilder(128);
		String t = qna.getQ_title();
		if (t.length() > 15) {
			//t = t.substring(0,15);
			//t = t+"...";
			t = String.format("%s...", t.substring(0, 15));
		}
		//답글공백삽입
		
		for (int i = 0; i < qna.getQ_depth(); i++) {
			title.append("&nbsp;&nbsp;");
		}
		
		if (qna.getQ_depth() > 0) {
			title.append("<img border='0' src='image/re.gif'/>");
		}
		
		title.append(t.replace(" ", "&nbsp;"));
		
		return title.toString();
}
%>
<%
QnaService qnaService = new QnaService();

String pageno = request.getParameter("pageno");
if (pageno == null || pageno.equals("")) {
	pageno = "1"; 
}

PageMakerDto<Qna> qnaListPage = (new QnaService().selectQnaList(Integer.parseInt(pageno)));
%>

<!DOCTYPE html>
<html>
<head>
<title>Q & A</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<link rel=stylesheet href="css/cart.css" type="text/css">
<style type="text/css" media="screen"></style>
<script type="text/javascript">
	function qnaWrite() {
		f.action = "qna_write_form.jsp";
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
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp; <b>QNA</b>
									</td>
								</tr>
								<tr bgcolor="#FFFFFF">
									<td height="20" class="t1" align="right" valign="bottom">♠
										총 <font color="#FF0000"><%=qnaListPage.totRecordCount%></font>
										건 | 현재페이지( <font color="#FF0000"><%=qnaListPage.pageMaker.getCurPage()%></font>
										/ <font color="#0000FF"><%=qnaListPage.pageMaker.getTotPage()%></font>
										)
									</td>
								</tr>
							</table> <br /> <!-- list -->
							<form name="f" method="post" action="">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">

									<tr>
										<td width=280 align=center bgcolor="E6ECDE">제목</td>
										<td width=120 align=center bgcolor="E6ECDE">작성자</td>
										<td width=120 align=center bgcolor="E6ECDE">작성일</td>
									<!-- 	<td width=70 align=center bgcolor="E6ECDE">첨부파일</td> -->
										<td width=70 align=center bgcolor="E6ECDE">조회수</td>
									</tr>
									<%
										for (Qna qna : qnaListPage.itemList) {
									%>
									<tr>
										<td width=280 bgcolor="ffffff" style="padding-left: 10px" align="left">
										<a href='qna_view.jsp?qnano=<%=qna.getQ_no()%>&pageno=<%=qnaListPage.pageMaker.getCurPage()%>' >
												<%=this.getTitleString(qna)%>
										</a></td>
										<td width=120 align=center bgcolor="ffffff"><%=qna.getM_id() %></td>
										<td width=120 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><%=qna.getQ_date().toString()%> 
										</td>
										<td width=70 align=center bgcolor="ffffff" align="left"><%=qna.getQ_count()%>
										</td>
									</tr>
									<%
									}
									%>
								</table>
								
								
							</form> 
							<!-- button -->
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align="right"><input type="button" value="게시글 쓰기"
										onclick="qnaWrite();" /></td>
								</tr>
							</table>
							
							<!-- /list -->
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align="center">
										<%if(qnaListPage.pageMaker.getPrevGroupStartPage()>0) {%>    
										    <a href="./qna_list.jsp?pageno=1">◀◀</a>&nbsp;
										 <%}%>
										 <%if(qnaListPage.pageMaker.getPrevPage()>0) {%>    
											<a href="./qna_list.jsp?pageno=<%=qnaListPage.pageMaker.getPrevPage()%>">◀</a>&nbsp;&nbsp;
										 <%}%>
										
										<%
											for (int i = qnaListPage.pageMaker.getBlockBegin(); i <= qnaListPage.pageMaker.getBlockEnd(); i++) {
										 	if (qnaListPage.pageMaker.getCurPage() == i) {
										%>
										 <font color='red'><strong><%=i%></strong></font>&nbsp;
										<%} else {%>
										<a href="./qna_list.jsp?pageno=<%=i%>"><strong><%=i%></strong></a>&nbsp;
										<%
										   }
										  }%>
										  
										 <%if(qnaListPage.pageMaker.getCurPage() < qnaListPage.pageMaker.getTotPage()){%>
										  <a href="./qna_list.jsp?pageno=<%=qnaListPage.pageMaker.getNextPage()%>">▶&nbsp;</a>
										 <%}%>
										 <%if(qnaListPage.pageMaker.getNextGroupStartPage()< qnaListPage.pageMaker.getTotPage()){%>
										<a
										href="./qna_list.jsp?pageno=<%=qnaListPage.pageMaker.getTotPage()%>">▶▶</a>&nbsp;
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
			<jsp:include page="include_common_bottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>