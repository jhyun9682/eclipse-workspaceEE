<%@page import="com.itwill.librarian.domain.PageMakerDto"%>
<%@page import="com.itwill.librarian.domain.Member"%>
<%@page import="com.itwill.librarian.service.MemberService"%>
<%@page import="com.itwill.librarian.domain.Qna"%>
<%@page import="com.itwill.librarian.service.QnaService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

String keyword = request.getParameter("keyword");
if (keyword == null) {
	response.sendRedirect("qnaView.jsp");
	return;
}

String pageno = request.getParameter("pageno");
if (pageno == null || pageno.equals("")) {
	pageno = "1";
}


PageMakerDto<Qna> qnaListPage = new QnaService().getQnaListByTitleContent(keyword, (Integer.parseInt(pageno)));
MemberService memberService = new MemberService();
%>


<!DOCTYPE html>
<html>
<head>
<title>게시판리스트(Q&A)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<link rel=stylesheet href="css/cart.css" type="text/css">
<script type="text/javascript">
	function qnaWrite() {
	f.action = "qnaWrite.jsp";
	f.submit();
	}
	
	function keywordCheck() {
		var str_keyword = window.searchform.keyword.value;

		if (!str_keyword || str_keyword === "") {
			window.alert("검색어를 입력하세요.");
			window.searchform.keyword.focus();
			return false;
		}
		window.searchform.submit();
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
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp; <b>게시판-리스트</b>
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
										<td width=70 align=center bgcolor="E6ECDE">첨부파일</td>
										<td width=70 align=center bgcolor="E6ECDE">조회수</td>
									</tr>
									<%
										for (Qna qna : qnaListPage.itemList) {
									%>
									<tr>
										<td width=280 bgcolor="ffffff" style="padding-left: 10px" align="left">
										<a href='qnaView.jsp?qnano=<%=qna.getQnaNo()%>&pageno=<%=qnaListPage.pageMaker.getCurPage()%>' >
												<%=qna.getQnaTitle()%>
												<%if(qna.getQna_reply_count()>0){
													out.print("("+qna.getQna_reply_count()+")");
												}
												%>
												<%if(qna.getQnaVisible()==0){%>
												<img src="image/lockimg.png" width = "15">
												<%
												}
												%>
										</a></td>
										<td width=120 align=center bgcolor="ffffff">
												<%if(qna.getQnaVisible()==1){%>
												<%=memberService.getMember(qna.getMemberNo()).getMemberName().toString().substring(0, 1)%>**
												<%
												}else{
												%>
												비공개
												<%
												}
												%>
										</td>
										<td width=120 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><%=qna.getQnaRegDate().toString().substring(0, 10)%>
										</td>
										<td width=70 align=center bgcolor="ffffff">
												<%if(qna.getQnaFile()!=null){%>
														<img src="image/fileimg.png" width = "15">
												<%}%>
										
										</td>
										<td width=70 align=center bgcolor="ffffff" align="left"><%=qna.getQnaViews()%>
										</td>
									</tr>
									<%
									}
									%>
								</table>
									
								<!-- /list -->
							</form> <br>
							<!-- 검색 창 -->
							<form id='searchform' name='searchform' action="qnaListSearchResult.jsp" onsubmit='return keywordCheck();'>
								<input type="text" placeholder="제목+내용으로 검색" name="keyword" style="height: 20px; width: 200px;">
								<button class="btn-search" type="button" onclick="keywordCheck()">검색</button>
							</form>
							<!-- 검색 창 -->
							
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align="center">
										<%if(qnaListPage.pageMaker.getPrevGroupStartPage()>0) {%>    
										    <a href="./qnaListSearchResult.jsp?pageno=1&keyword=<%=keyword%>">◀◀</a>&nbsp;
										 <%}%>
										 <%if(qnaListPage.pageMaker.getPrevPage()>0) {%>    
											<a href="./qnaListSearchResult.jsp?pageno=<%=qnaListPage.pageMaker.getPrevPage()%>&keyword=<%=keyword%>">◀</a>&nbsp;&nbsp;
										 <%}%>
										
										<%
											for (int i = qnaListPage.pageMaker.getBlockBegin(); i <= qnaListPage.pageMaker.getBlockEnd(); i++) {
										 	if (qnaListPage.pageMaker.getCurPage() == i) {
										%>
										 <font color='blue'><strong><%=i%></strong></font>&nbsp;
										<%} else {%>
										<a href="./qnaListSearchResult.jsp?pageno=<%=i%>&keyword=<%=keyword%>"><strong><%=i%></strong></a>&nbsp;
										<%
										   }
										  }%>
										  
										  
										 <%if(qnaListPage.pageMaker.getCurPage() < qnaListPage.pageMaker.getTotPage()){%>
										  <a href="./qnaListSearchResult.jsp?pageno=<%=qnaListPage.pageMaker.getNextPage()%>&keyword=<%=keyword%>">▶&nbsp;</a>
										 <%}%>
										 <%if(qnaListPage.pageMaker.getNextGroupStartPage()< qnaListPage.pageMaker.getTotPage()){%>
										<a
										href="./qnaListSearchResult.jsp?pageno=<%=qnaListPage.pageMaker.getTotPage()%>&keyword=<%=keyword%>">▶▶</a>&nbsp;
										 <%}%>
									</td>
								</tr>
							</table> <!-- button -->
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align="right"><input type="button" value="게시물 생성"
										onclick="qnaWrite();" /></td>
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
			<jsp:include page="includeCommonBottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>