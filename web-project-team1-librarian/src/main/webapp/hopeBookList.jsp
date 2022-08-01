<%@page import="com.itwill.librarian.domain.HopeBook"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.librarian.service.HopeBookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="memberLoginCheck.jspf" %>  
<%
	HopeBookService hopeBookService = new HopeBookService();
	ArrayList<HopeBook> hopeBookList = hopeBookService.getHopeBookList(Integer.parseInt(sMemberNo));
	
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>희망 도서 신청 목록</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/user.css" type="text/css">
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
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
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td>
							<!--contents-->
							<br>
							<table style="padding: 0px 0px 10px 10px;" border=0 cellpadding=0 cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">
										&nbsp;&nbsp;<b>희망 도서 신청 목록</b>
									</td>
								</tr>
							</table> <!-- update Form  -->
							<table style="margin-left: 10px" border="0" cellpadding="0" cellspacing="1"
								width="570" bgcolor="BBBBBB">
								<tr>
									<td width=100 align=center bgcolor="E6ECDE" height="22">
										도서 제목
									</td>
									<td width=100 align=center bgcolor="E6ECDE" height="22">
										도서 출판사
									</td>
									<td width=100 align=center bgcolor="E6ECDE" height="22">
										도서 저자
									</td>
									<td width=100 align=center bgcolor="E6ECDE" height="22">
										입고 상태
									</td>
									<td width=100 align=center bgcolor="E6ECDE" height="22">
										신청 날짜
									</td>
								</tr>
								<% for(HopeBook hopeBook : hopeBookList) { %>
								<tr>
									<td width=100 align=center bgcolor="FFFFFF" height="22">
										<%= hopeBook.getBookTitle() %>
									</td>
									<td width=100 align=center bgcolor="FFFFFF" height="22">
										<%= hopeBook.getPublisher() %>
									</td>
									<td width=100 align=center bgcolor="FFFFFF" height="22">
										<%= hopeBook.getAuthor() %>
									</td>
									<td width=100 align=center bgcolor="FFFFFF" height="22">
										<%= hopeBook.getIbStatus() == 0 ? "입고 중" : "입고 완료" %>
									</td>
									<td width=100 align=center bgcolor="FFFFFF" height="22">
										<%= hopeBook.getHopeRegDate() %>
									</td>
								</tr>
								<% } %>
							</table>
							<br>
							<table width=590 border=0 cellpadding=0 cellspacing=0>
								<tr>
									<td align=center><input type="button" value="희망 도서 신청"
										onClick="location.href='hopeBookAdd.jsp';"> &nbsp;</td>
								</tr>
							</table>
						
						</td>
					</tr>
				</table>
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
