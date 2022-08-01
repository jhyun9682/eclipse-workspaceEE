<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쇼핑몰</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
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
			<jsp:include page="include_common_top.jsp"/>
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp"/>
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
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>쇼핑몰 -
											상품리스트</b></td>
								</tr>
							</table>

							<form name="f" method="post">
								<table width="100%" align="center" border="0" cellpadding="10"
									cellspacing="1" bgcolor="BBBBBB">
									
									<!--상품시작 -->
									
									<tr>
									
										<td align="center" width="25%"  bgcolor="ffffff"><a
											href="product_detail.jsp?p_no=1"><img width="88px" height="65px"
												src="image/bigle.png" border="0"></a><br />
											<br /> <b>견종:비글</b><br> <font
											color="#FF0000">가격:550,000원
										</font></td>
										
									
								   <!--상품 끝 -->
								   
									<!--상품시작 -->
									
										<td align="center" width="25%"  bgcolor="ffffff"><a
											href="product_detail.jsp?p_no=2"><img width="88px" height="65px"
												src="image/dalma.jpg" border="0"></a><br />
											<br /> <b>견종:달마시안</b><br> <font
											color="#FF0000">가격:500,000원
										</font></td>
										
									
								   <!--상품 끝 -->
								   
									<!--상품시작 -->
									
										<td align="center" width="25%"  bgcolor="ffffff"><a
											href="product_detail.jsp?p_no=3"><img width="88px" height="65px"
												src="image/pug.jpg" border="0"></a><br />
											<br /> <b>견종:퍼그</b><br> <font
											color="#FF0000">가격:400,000원
										</font></td>
								   <!--상품 끝 -->
								   <!--상품시작 -->
										<td align="center" width="25%"  bgcolor="ffffff"><a
											href="product_detail.jsp?p_no=4"><img width="88px" height="65px"
												src="image/pekiniz.png" border="0"></a><br />
											<br /> <b>견종:페키니즈</b><br> <font
											color="#FF0000">가격:450,000원
										</font></td>
									
									</tr>
										
									
								   <!--상품 끝 -->
								   
									<!--상품시작 -->
									
									<tr>
									
										<td align="center" width="25%"  bgcolor="ffffff"><a
											href="product_detail.jsp?p_no=5"><img width="88px" height="65px"
												src="image/pomeranian.jpg" border="0"></a><br />
											<br /> <b>견종:포메라니안</b><br> <font
											color="#FF0000">가격:800,000원
										</font></td>
										
									
								   <!--상품 끝 -->
								   
									<!--상품시작 -->
									
										<td align="center" width="25%"  bgcolor="ffffff"><a
											href="product_detail.jsp?p_no=6"><img width="88px" height="65px"
												src="image/shaipei.jpg" border="0"></a><br />
											<br /> <b>견종:샤페이</b><br> <font
											color="#FF0000">가격:700,000원
										</font></td>
										
									
								   <!--상품 끝 -->
								   
									<!--상품시작 -->
									
										<td align="center" width="25%"  bgcolor="ffffff"><a
											href="product_detail.jsp?p_no=7"><img width="88px" height="65px"
												src="image/dachshund.jpg" border="0"></a><br />
											<br /> <b>견종:닥스훈트</b><br> <font
											color="#FF0000">가격:800,000원
										</font></td>
										
									
								   <!--상품 끝 -->
								   
									<!--상품시작 -->
									
										<td align="center" width="25%"  bgcolor="ffffff"><a
											href="product_detail.jsp?p_no=8"><img width="88px" height="65px"
												src="image/samoyed.jpg" border="0"></a><br />
											<br /> <b>견종:사모예드</b><br> <font
											color="#FF0000">가격:800,000원
										</font></td>
									
									</tr>
										
									
								   <!--상품 끝 -->
								   	
								</table>
							</form> <br /></td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>