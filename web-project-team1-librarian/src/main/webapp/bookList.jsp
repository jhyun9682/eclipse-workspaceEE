<%@page import="com.itwill.librarian.domain.Book"%>
<%@page import="com.itwill.librarian.domain.PageMakerDto"%>
<%@page import="com.itwill.librarian.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String pageNo = request.getParameter("pageNo");
if (pageNo == null || pageNo.equals("")) {
	pageNo = "1";
}

PageMakerDto<Book> listPage = new BookService().getBookList(Integer.parseInt(pageNo));
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>책 전체 목록</title>
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<link rel=stylesheet href="css/cart.css" type="text/css">
<link rel=stylesheet href="css/book.css" type="text/css">
</head>
<body>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="includeCommonTop.jsp"/>
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="includeCommonLeft.jsp"/>
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content.jsp start-->
			<div id="content">
			<div style="margin: 10px;">
				<table style="padding-left: 10px" border=0 cellpadding=0 cellspacing=0>
				<tr>
					<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp; <b>도서 목록</b>
					</td>
				</tr>
				<tr bgcolor="#FFFFFF">
					<td height="20" class="t1" align="right" valign="bottom">♠ 총 <font color="#FF0000"><%=listPage.totRecordCount%></font>건 | 현재페이지( <font color="#FF0000"><%=listPage.pageMaker.getCurPage()%></font> / <font color="#0000FF"><%=listPage.pageMaker.getTotPage()%></font> )
					</td>
				</tr>
				</table>
			<br />
			<!-- list  -->
			<form name="f">
					<%
					for (Book book : listPage.itemList) {
						if (book.getBookImageURL() == null) {
							book.setBookImageURL("image/noimg.png");
						}
					%>
			<hr>
				<table class='book-list'>
					<!-- 책정보 시작 -->
					
					<tr>
						<td class='book-list-img' rowspan="4"><a href='bookDetail.jsp?bookNo=<%=book.getBookNo()%>'><img alt='bookcover' src='<%=book.getBookImageURL()%>' width="100px" height="140px"></a> <input type="hidden" name="bookNo" value="<%=book.getBookNo()%>"></td>
						<td class='book-td'><span class='bookcategory'><%=book.getBookCategory()%></span>&nbsp;&nbsp;<a href='bookDetail.jsp?bookNo=<%=book.getBookNo()%>'><strong><%=book.getBookTitle()%></strong></a></td>
					</tr>
					<tr>
						<td class='book-td'><strong>저자:</strong><%=book.getBookAuthor()%>&nbsp;&nbsp; <strong>출판사:</strong><%=book.getBookPublisher()%></td>
					</tr>
					<tr>
						<td class='book-td'><strong>대출</strong>&nbsp;<%=book.getBookLoan()%>/<%=book.getBookHoldings()%> &nbsp;<strong>예약</strong>&nbsp;<%=book.getBookReservation()%> /<%=book.getBookHoldings()%></td>
					</tr>
					<tr>
			            <td class='book-td'>
			            <%//if (book.getBookLoan() < book.getBookHoldings()) {%>
			            <input class='btn-action' type="button" value="대출신청" onclick="location.href='loanAddAction.jsp?bookNo=<%=book.getBookNo()%>'">
			            <%//} else { %> 
			            <input class='btn-action' type="button" value="예약신청" onclick="location.href='reservationAddAction.jsp?bookNo=<%=book.getBookNo()%>'">
			            <%//}%>
			            <input class='favorite' type="button" value="관심도서 등록" onclick="location.href='favoriteAddAction.jsp?bookNo=<%=book.getBookNo()%>'">
			            </td>
					</tr>
					<!-- 책정보 끝 -->
				</table>
					<%
					}
					%>
					<hr>
			</form>
			<!-- 페이지 번호 리스트 -->
			<table border="0" cellpadding="0" cellspacing="1" width="590">
				<tr>
					<td align="center">
			     
						 <%if(listPage.pageMaker.getPrevGroupStartPage()>0) {%>    
						    <a href="./bookList.jsp?pageNo=1">◀◀</a>&nbsp;
						 <%}%>
						 <%if(listPage.pageMaker.getPrevPage()>0) {%>    
							<a href="./bookList.jsp?pageNo=<%=listPage.pageMaker.getPrevPage()%>">◀</a>&nbsp;&nbsp;
						 <%}%>
						
						<%
							for (int i = listPage.pageMaker.getBlockBegin(); i <= listPage.pageMaker.getBlockEnd(); i++) {
						 	if (listPage.pageMaker.getCurPage() == i) {
						%>
						 <font color='blue'><strong><%=i%></strong></font>&nbsp;
						<%} else {%>
						<a href="./bookList.jsp?pageNo=<%=i%>"><strong><%=i%></strong></a>&nbsp;
						<%
						   }
						  }%>
						  
						  
						 <%if(listPage.pageMaker.getCurPage() < listPage.pageMaker.getTotPage()){%>
						  <a href="./bookList.jsp?pageNo=<%=listPage.pageMaker.getNextPage()%>">▶&nbsp;</a>
						 <%}%>
						 <%if(listPage.pageMaker.getNextGroupStartPage()< listPage.pageMaker.getTotPage()){%>
						<a
						href="./bookList.jsp?pageNo=<%=listPage.pageMaker.getTotPage()%>">▶▶</a>&nbsp;
						 <%}%>
					</td>
				</tr>
			</table> 
			<!-- 페이지 번호 리스트 -->
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
			</div>
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