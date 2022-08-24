<%@page import="com.itwill.librarian.service.FavoriteService"%>
<%@page import="com.itwill.librarian.domain.Member"%>
<%@page import="com.itwill.librarian.dao.MemberDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.librarian.domain.Book"%>
<%@page import="com.itwill.librarian.domain.Reservation"%>
<%@page import="com.itwill.librarian.service.ReservationService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="memberLoginCheck.jspf"%>
<%
	
		if (sMemberNo == null || sMemberNo.equals("")) {
			response.sendRedirect("bookSearchResult.jsp");
			return;
		}
			
	FavoriteService fs = new FavoriteService();
	ArrayList<Book> favoriteLise = fs.getFavoriteBookList(sMember.getMemberNo());

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관심 도서 목록</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<link rel=stylesheet href="css/cart.css" type="text/css">
<style type="text/css" media="screen">
</style>
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
				<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
					codebase="http://active.macromedia.com/flash4/cabs/swflash.cab#version=4,0,0,0"
					width="540px" height="350px">
					<script type="text/javascript">
				function removeFavorite() {
					f.action = "favoriteRemoveAction.jsp";
					f.submit();
				}
				function addReservation() {
					f.action = "reservationAddAction.jsp";
					f.submit();
				}
			</script>

					<h2>&nbsp;[<%=sMember.getMemberName() %> 님 관심 도서 상세보기]</h2>
					<hr>
					<table style="padding-left: 10px" border=0 cellpadding=0 cellspacing=0>
						<tr>
							<td bgcolor="f4f4f4" height="22" align="center">&nbsp;&nbsp;&nbsp;&nbsp;
								<b>책 목록</b>&nbsp;&nbsp;&nbsp;&nbsp;
							</td>
						</tr>
						<tr bgcolor="#FFFFFF">
							<td height="20" class="t1" align="right" valign="bottom">♠ 총
								<font color="#FF0000"><%=fs.getFavoriteCount(sMember.getMemberNo())%></font>건
							</td>
						</tr>
					</table>

						<table>
							<%
					for (Book book : favoriteLise) {
					%>
							<!-- 책정보 시작 -->
							<tr>
								<td rowspan="4"><a
									href='bookDetail.jsp?bookNo=<%=book.getBookNo()%>>'>
									<img alt='bookcover' src='<%=book.getBookImageURL()%>'
										width="100px" height="140px"></a> <input type="hidden"
										name="bookNo" value="<%=book.getBookNo()%>">
								</td>
								<td><%=book.getBookCategory()%>&nbsp;&nbsp;&nbsp;
									<a href='bookDetail.jsp?bookNo=<%=book.getBookNo()%>'><%=book.getBookTitle()%></a>
								</td>
							</tr>
							<tr>
								<td>저자:<%=book.getBookAuthor()%>&nbsp;&nbsp; 출판사:<%=book.getBookPublisher()%>
							</tr>
							<tr>
								<td>대출&nbsp;<%=book.getBookLoan()%>/<%=book.getBookHoldings()%>
									&nbsp;예약&nbsp;<%=book.getBookReservation()%>/<%=book.getBookHoldings()%>
							</tr>
							<tr>
								<td><input type="button" value="대출신청" onclick="location.href='loanAddAction.jsp?bookNo=<%=book.getBookNo()%>'">&nbsp;
									<input type="button" value="예약신청" onclick="location.href='reservationAddAction.jsp?bookNo=<%=book.getBookNo()%>'">&nbsp; 
									<input type="button" value="관심도서 삭제" onclick="location.href='favoriteRemoveAction.jsp?bookNo=<%=book.getBookNo()%>'"><br><br><hr> 
								</td>
							</tr>
							<!-- 책정보 끝 -->
							<%}%>
						</table>
				</object>
			</div>
			<!-- include_content.jsp end-->
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