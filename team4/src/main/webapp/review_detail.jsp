<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>SEOUL BAGUETTE</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/menu.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
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
			<jsp:include page="include_common_top.jsp" />
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />

							<form name="f" method="post" action="order_delete_action.jsp"
								onsubmit="return check_delete_order()">
								<input type="hidden" name="o_no" value="131">
								<table align="center" width="80%" border="0" cellpadding="0"
									cellspacing="1" bgcolor="#FFFFFF">
									<caption
										style="text-align: left; font-weight: bold; padding-bottom: 7px">
										<span style="border-left: 4px solid #888888;"></span>&nbsp;&nbsp;리뷰1개상세보기
									</caption>
									<tr>
										<td width="81px" height="83px" align=center bgcolor="#FFFFFF" class=t1 style="border: 1px solid #aaa;">
											<img src="image/0700000065562.jpg" width="80px" height="80px">
										</td>
										<td width=602 
											height=80 
											align=left 
											bgcolor="ffffff" 
											class=t1
											style="padding-left: 20px; font-size: 10pt; font-weight: bold">
											곰돌이
										</td>
										
									</tr>
								</table>
								<br>

								<table align=center width=80% border="0" cellpadding="0"
									cellspacing="1" bgcolor="BBBBBB">
									<!-- order item start -->
									<tr>
										<td width=30 height=50 align=left bgcolor="ffffff" class=t1 colspan="5" style="font-size: 10pt;font-weight: bold">
											&nbsp;&nbsp;&nbsp;리뷰제목~~~
										</td>
										

									</tr>
									<tr>
										<td width=100 height=40 align=center bgcolor="ffffff" class=t1>
											별점(★★★)
										</td>
										<td width=260 height=40 align=center bgcolor="ffffff" class=t1>
											작성자
										</td>
										<td width=109 height=40 align=center bgcolor="ffffff" class=t1 colspan="3">작성일자</td>
									</tr>
									<tr>
										<td width=30 height=80 align=left bgcolor="ffffff" class=t1 colspan="5">
											&nbsp;&nbsp;&nbsp;리뷰내용!!!!!
										</td>
										

									</tr>
									<!-- order item end -->
								</table>

							</form> <br /> <br /> <br />
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center>
										<input type="button" value="뒤로가기">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										<input type="button" value="삭제">
										<input type="button" value="수정">
									</td>
								</tr>
							</table></td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->

	</div>
	<!--container end-->
</body>
</html>
