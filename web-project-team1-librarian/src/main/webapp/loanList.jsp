<%@page import="java.util.Calendar"%>
<%@page import="com.itwill.librarian.domain.Loan"%>
<%@page import="com.itwill.librarian.service.LoanService"%>
<%@page import="com.itwill.librarian.domain.Member"%>
<%@page import="com.itwill.librarian.dao.MemberDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.librarian.domain.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="memberLoginCheck.jspf"%>
<%
	LoanService loanService = new LoanService();
	ArrayList<Book> loanBookList = loanService.getLoanList(Integer.parseInt(sMemberNo));
	ArrayList<Loan> loanList = loanService.getLoanList(Integer.parseInt(sMemberNo), true);
	Calendar calendar = Calendar.getInstance();
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 대출 목록</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<link rel=stylesheet href="css/cart.css" type="text/css">
<style type="text/css" media="screen"></style>
<script type="text/javascript">
	function loanReturnAction(loanNo, bookNo, bookTitle) {
		if(confirm('정말로 ' + bookTitle + ' 도서를 반납 하시겠습니까?')){
			location.href='loanReturnAction.jsp?loanNo='.concat(loanNo, '&bookNo=', bookNo);
		}
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
				<div>
				<%
				if (loanBookList == null || loanBookList.size() == 0) {
				%>
					<h2>&nbsp;&nbsp;[대출된 도서가 없습니다.]</h2>
					<br>
					&nbsp;&nbsp;<input type="button" value="돌아가기" onclick="location.href='index.jsp'">
				<%
				} else {
				%>
				<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
					codebase="http://active.macromedia.com/flash4/cabs/swflash.cab#version=4,0,0,0"
					width="540px" height="350px">
					
					<h2>&nbsp;&nbsp;[<%=sMember.getMemberName() %> 님 도서 대출 목록]</h2>
					<table style="padding-left: 10px" border=0 cellpadding=0 cellspacing=0>
						<tr>
							<td bgcolor="f4f4f4" height="22" align="center">
								<b>대출 도서 목록</b>
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td height="20" class="t1" align="right" valign="bottom">♠
								총 <font color="#FF0000"><%= loanBookList.size() %></font>건
							</td>
						</tr>
					</table>
					<hr>
					<%
					int sizeCnt = 0;
					for (Book book : loanBookList) {
						if (book.getBookImageURL() == null) {
		                    book.setBookImageURL("image/noimg.png");
		                }
					%>
					<table style="margin-left: 20px;"><!-- border="1" -->
						<!-- 책정보 시작 -->
						<tr>
							<td rowspan="4" width="100px">
								<a href='bookDetail.jsp?bookNo=<%=book.getBookNo()%>'>
									<img alt='bookcover' src='<%=book.getBookImageURL()%>' width="100px" height="140px">
								</a> 
								<input type="hidden" name="bookNo" value="<%=book.getBookNo()%>">
							</td>
							<td>[<%=book.getBookCategory()%>]
								<a href='bookDetail.jsp?bookNo=<%=book.getBookNo()%>'><%=book.getBookTitle()%></a>
							</td>
						</tr>
						<tr>
							<td>저자:<%=book.getBookAuthor()%>&nbsp;&nbsp; 출판사:<%=book.getBookPublisher()%></td>
						</tr>
						<tr>
							<td>대출일: <%=loanList.get(sizeCnt).getLoanRegDate()%>&nbsp;&nbsp;
							<%
							calendar.setTime(loanList.get(sizeCnt).getLoanRegDate());
							calendar.add(Calendar.DATE, Loan.LOAN_TERM);
							%>
							반납 예정일: <%=calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1) + "-"+calendar.get(Calendar.DATE)%></td>
						</tr>
						<tr>
							<td>
								<input type="button" value="도서 반납"
								onclick="loanReturnAction(<%=loanList.get(sizeCnt).getLoanNo()%>, <%=book.getBookNo()%>, '<%=book.getBookTitle()%>')">
								&nbsp;
							</td>
						</tr>
						<!-- 책정보 끝 -->
					</table>
					<hr>
					<% 
						sizeCnt++;
					}
					%>
				</object>
				<% 
				}
				%>
			</div>
			<!-- include_content.jsp end-->
			</div>
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="includeCommonBottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->

</body>
</html>