<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="com.itwill.librarian.domain.Member"%>
<%@page import="com.itwill.librarian.dao.MemberDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.librarian.domain.Book"%>
<%@page import="com.itwill.librarian.domain.Reservation"%>
<%@page import="com.itwill.librarian.service.ReservationService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="memberLoginCheck.jspf"%>
<%
	ReservationService rs = new ReservationService();

	ArrayList<Reservation> rsList = rs.getReservationsList(Integer.parseInt(sMemberNo));
	ArrayList<Book> reservationList = rs.getReservationBookList(sMember.getMemberNo());
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약 도서 목록</title>
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
				<div>
				<%

				if (reservationList == null || reservationList.isEmpty()) {
					%>
					<h2>&nbsp;&nbsp;[예약된 도서가 없습니다.]</h2>
					<br>
					&nbsp;&nbsp;<input type="button" value="돌아가기" onclick="window.history.back()">
					<%
				} else{
				
				%>
				<object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000"
					codebase="http://active.macromedia.com/flash4/cabs/swflash.cab#version=4,0,0,0"
					width="540px" height="350px">
					

						<h2>&nbsp;[<%=sMember.getMemberName() %> 님 도서 예약 상세보기]</h2>
						<hr>
						<table style="padding-left: 10px" border=0 cellpadding=0 cellspacing=0>
							<tr>
								<td bgcolor="f4f4f4" height="22" align="center">&nbsp;&nbsp;&nbsp;&nbsp;
									<b>예약 도서 목록</b>&nbsp;&nbsp;&nbsp;&nbsp;
								</td>
							</tr>
							<tr bgcolor="#FFFFFF">
								<td height="20" class="t1" align="right" valign="bottom">♠
									총 <font color="#FF0000"><%=rs.getReservationCount(sMember.getMemberNo())%></font>건
								</td>
							</tr>
						</table>
						<hr>
							<table style="margin-left: 20px;">
								<%
								int sizeCnt = 0;
								for (Book book : reservationList) {
									if (book.getBookImageURL() == null) {
										book.setBookImageURL("image/noimg.png");
									}
								 %>
						<!-- 책정보 시작 -->
						<tr>
									<td rowspan="4" width="100px">
										<a href='bookDetail.jsp?bookNo=<%=book.getBookNo()%>'><img alt='bookcover' src='<%=book.getBookImageURL()%>' width="100px" height="140px">
										</a> 
										<input type="hidden" name="bookNo" value="<%=book.getBookNo()%>">
									</td>
									<td>[<%=book.getBookCategory()%>]
										<a href='bookDetail.jsp?bookNo=<%=book.getBookNo()%>'><%=book.getBookTitle()%></a>
										</td>
								</tr>
								<tr>
									<td>저자:<%=book.getBookAuthor()%>&nbsp;&nbsp; 출판사:<%=book.getBookPublisher()%>
								</tr>
								<tr>
									<td>대출&nbsp;<%=book.getBookLoan()%>/<%=book.getBookHoldings()%>&nbsp;
										예약&nbsp;<%=book.getBookReservation()%>/<%=book.getBookHoldings()%><br>
										
										예약일:&nbsp;<%= rsList.get(sizeCnt).getReservationRegDate() %>
										
										<!-- 아니.. 예약일 어떻게 출력하냐고 장난하나.. 
											
											이런 식으로 하면 됩니다 잘 하셨는 걸요?
											근데 태그 정리가 좀 필요한 거 같습니다
										-->
								</tr>
								<tr>
									<td>
										<input type="button" value="대출신청" onclick="location.href='loanAddAction.jsp?bookNo=<%=book.getBookNo()%>'">&nbsp;
										<input type="button" value="예약취소" onclick="location.href='reservationRemoveAction.jsp?bookNo=<%=book.getBookNo()%>'"><br><br><hr>
									</td>
								</tr>
								<!-- 책정보 끝 -->
							<%
								sizeCnt++;
								}
							}
							%>
						</table>
				</object>
				
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