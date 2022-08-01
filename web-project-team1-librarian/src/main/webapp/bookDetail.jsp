<%@page import="com.itwill.librarian.common.Librarian"%>
<%@page import="com.itwill.librarian.domain.Book"%>
<%@page import="com.itwill.librarian.service.BookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String bookNo = request.getParameter("bookNo");
if (bookNo == null || bookNo.equals("")) {
	response.sendRedirect("bookSearchForm.jsp");
	return;
}
BookService bookService = new BookService();
Book book = bookService.getBookByNo(bookNo);
String bookInfo = book.getBookInfo().replaceAll("\r\n|\r|\n|\n\r", "<br>");
String bookIndex = book.getBookIndex().replaceAll("\r\n|\r|\n|\n\r", "<br>");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 상세보기</title>
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
				<div style="margin: 10px;">
					<table style="padding-left: 10px" border=0 cellpadding=0 cellspacing=0>
						<tr>
							<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp; <b>책 상세정보</b>
							</td>
						</tr>
					</table>
					<br />
					<%
					if (book.getBookImageURL() == null) {
						book.setBookImageURL("image/noimg.png");
					}
					%>

					<table style="border: 2px solid; border-radius: 10px;">
							<colgroup>
								<col width="190px">
								<col width="60px">
								<col width="280px">
							</colgroup>
							<tbody>
								<tr>
									<td rowspan="5"><img alt='bookcover' src='<%=book.getBookImageURL()%>' width="172px" height="212px" style="box-shadow: 4px 4px 4px rgb(165, 165, 165);"></td>
								</tr>
								<tr>
									<th scope="row"><%=book.getBookCategory()%></th>
									<td style="font-size: 15px; font-weight: bold;"><%=book.getBookTitle()%></td>
								</tr>
								<tr>
									<th scope="row">저자</th>
									<td><%=book.getBookAuthor()%></td>
								</tr>
								<tr>
									<th scope="row">출판사</th>
									<td><%=book.getBookPublisher()%></td>
								</tr>
								<tr>
									<th scope="row">이용현황</th>
									<td>대출 &nbsp;<%=book.getBookLoan()%>/<%=book.getBookHoldings()%> &nbsp; 예약 &nbsp;<%=book.getBookReservation()%>/<%=book.getBookHoldings()%></td>
								</tr>
					
							</tbody>

					</table>
						<br />
						<div class='book-detail-button' style="margin: auto;">
							<%
							//if (book.getBookLoan() < book.getBookHoldings()) {
							%>
							<input class="btn-action" type="button" value="대출신청" onclick="location.href='loanAddAction.jsp?bookNo=<%=book.getBookNo()%>'">
							<%
							//} else {
							%>
							<input class="btn-action" type="button" value="예약신청" onclick="location.href='reservationAddAction.jsp?bookNo=<%=book.getBookNo()%>'">
							<%
							//}
							%>
							<input class="favorite" type="button" value="관심도서 등록" onclick="location.href='favoriteAddAction.jsp?bookNo=<%=book.getBookNo()%>'">
							<br />
							<br />
							<input type="button" value="목록으로" onclick="window.history.back()">
							<hr>
						</div>
						<h3>상세정보</h3>
						<hr>
						<div><p><%=bookInfo%></p></div>
						<hr>
						<h3>목차</h3>
						<hr>
						<div><p><%=bookIndex%></p></div>
						<hr>
						<div class="book-detail-button">
						<input type="button" value="목록으로" onclick="window.history.back()">
						</div>
				</div>

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