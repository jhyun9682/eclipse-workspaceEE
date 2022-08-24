
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.itwill.shop.dto.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.itwill.shop.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
ProductService productService = new ProductService();
List<Product> productList= productService.select(null, null, "p_price", "desc");

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>한셈몰 메인</title>
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
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>대표상품</b></td>
								</tr>
							</table>

							<form name="f" method="post">
								<table width="100%" align="center" border="0" cellpadding="10"
									cellspacing="1" bgcolor="BBBBBB">
									
									<!--상품시작 -->
									
								<%
									int product_size=productList.size();
									int product_column_size=4;
									int product_line_count = 1;
									
									
									for (int i=0;i<8;i++) {
											Product product=productList.get(i);
									%>
									<!--상품시작 -->		
									<%
									 if(i%product_column_size==0){
									%>
									<tr>
									<%} %>
									
										<td align="center" width="25%"  bgcolor="ffffff"><a
											href="product_detail.jsp?p_no=<%=product.getP_no()%>"><img width="88px" height="65px"
												src="image/<%=product.getP_img()%>" border="0"></a><br />
											<br /> <b><%=product.getP_name()%></b><br> <font
											color="#FF0000">가격:<%=new DecimalFormat("#,###").format(product.getP_price())%>원
										</font></td>
									<%if(i%product_column_size==3){%>
									</tr>
									<%} %>		
									
								   <!--상품 끝 -->
								   <%} %>
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
