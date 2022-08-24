<%@page import="com.itwill.shop.dto.Cart"%>
<%@page import="com.itwill.shop.service.CartService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.shop.dto.Review"%>
<%@page import="javax.websocket.SendResult"%>
<%@page import="com.itwill.shop.dto.Product"%>
<%@page import="com.itwill.shop.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>한셈몰상품정보</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<style type="text/css" media="screen">
</style>
<script type="text/javascript">

	function add_cart(){
		<%
		 /*
		   중복체크기능 있는버전 뒤로가기 시 jsp가 작동하지 않아서 문제
		    */
		ProductService productService= new ProductService();
		CartService cartService=new CartService();
		String p_noStr=request.getParameter("p_no");
		if(p_noStr==null){
			response.sendRedirect("product_list.jsp");
			return;
		}
		int p_no = Integer.parseInt(p_noStr);
		Product product= productService.getProductByNo(p_no);
		boolean isLogin=false;
		if(session.getAttribute("s_u_id")!=null){
			isLogin=true;
		}
		String thename="";
		boolean isInCart=false;
		List<Cart> cartList=cartService.getCartList((String)session.getAttribute("s_u_id"));
		for(Cart cart :cartList){
			if(cart.getProduct().getP_no()==p_no){
				isInCart=true;
				thename=cart.getProduct().getP_name();
			}
		}
			System.out.println(isInCart);
		
		
		%>
		
		if (<%=!isLogin%>) {
			alert('로그인 하세요');
			location.href = 'user_login_form.jsp';
		}else if(<%=isInCart%>){
			alert('이미<%=thename%>이 있습니다. 추가합니다.');
			document.add_cart_form.action = 'cart_add_action.jsp';
			document.add_cart_form.method = 'post';
			document.add_cart_form.submit();
		} else {
			document.add_cart_form.action = 'cart_add_action.jsp';
			document.add_cart_form.method = 'post';
			document.add_cart_form.submit();
		}
		
	}

	function order_create_form() {
		if (<%=!isLogin%>) {
			alert('로그인 하세요');
			location.href = 'user_login_form.jsp';
		} else {
			document.product_detail_form.method = 'post';
			document.product_detail_form.action = 'order_create_form.jsp';
			document.product_detail_form.submit();
		}
	}
	function productList() {
		location.href = 'product_list.jsp';
	}
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<form name="product_detail_form">
		<input type="hidden" name="p_no" value="<%=product.getP_no()%>">
		<input type="hidden" name="c_qty" value="1"> <input
			type="hidden" name="buyType" value="direct">
	</form>
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
											상품상세보기</b></td>
								</tr>
							</table> <!-- 
							<form name="f" method="post">
							-->
							<table style="margin-left: 10px" border=0 width=80% height=376
								align=center>
								<tr valign=bottom>
									<td width=30% align=center class=t1><font size=2
										color=#0000FF><b>주문</b></font></td>
									<td width=40% align=center class=t1><font size=2
										color=#0000FF><b>상품명</b></font></td>
									<td width=30% align=center class=t1><font size=2
										color=#0000FF><b>상품소개</b></font></td>
									
								</tr>
								<tr width=100%>
									<td colspan=3 height=5><hr color=#556b2f></td>
								</tr>
								<tr width=100%>
									<td width=30% height=200 align=center class=t1>
										<form name="add_cart_form" method="post" action="cart_view.jsp"  onsubmit="add_cart();">
											수량 :
											<!-- 
											 <input type=text name="cart_qty" value=1 size=4 class=TXTFLD>  
											-->
											<select name="c_qty">
												<option value="1">1
												<option value="2">2
												<option value="3">3
												<option value="4">4
												<option value="5">5
												<option value="6">6
												<option value="7">7 
												<option value="8">8
												<option value="9">9
												<option value="10">10
											</select> 개<br><br> 
												<input type=button value="장바구니에담기[장바구니보여주기]" onclick="add_cart();"/><br><br> 
												
												<input type="hidden" name=p_no value="<%=product.getP_no()%>">
										</form>
									</td>
									<td width=40% height=200 align=center><img border=0
										src='image/<%=product.getP_img()%>' width=120 height=200></td>
									<td width=30% height=200 class=t1>
										<ol type="disc">
											<li><b><font color=#FF0000>상품 <%=product.getP_name()%>&nbsp;&nbsp;&nbsp;
											</b></font></li>
											<li><font color=#0000FF>가격 : <%=product.getP_price()%>&nbsp;&nbsp;&nbsp;
											</font></li>
											<li><font color=#0000FF><%=product.getP_desc()%></font></li>
										</ol>
									</td>
								</tr>
								<tr>
									<td colSpan=3 height=21><hr color=#556b2f></td>
								</tr>
							</table> <!-- 
							</form>
							-->
							<table border="0" cellpadding="0" cellspacing="1">
								<tr>
									<td align=center> <input
										type="button" value="상품리스트" onClick="productList();"></td>
								</tr>
								<tr>
									<td align=center><font color="#FF0000"> 리퓨평점 <%=product.getReviewScoreAvg()%> </td>
								</tr>
							</table>
		<table style="margin-left: 10px" border=0 width=80% height=50
								align=center>
								<tr valign=bottom>
									<td width=30% align=center class=t1><font size=2
										color=#0000FF><b>점수</b></font></td>
									<td width=40% align=center class=t1><font size=2
										color=#0000FF><b>리뷰내용</b></font></td>
									<td width=30% align=center class=t1><font size=2
										color=#0000FF><b>작성자</b></font></td>
									</tr>
								
<%if(product.getReviewList().size()!=0){
									
				List<Review> reviewList = product.getReviewList();
				for(Review review : reviewList){
			%>
								<tr width=100%>
							<td width=10% height=50 align=center class=t1><%=review.getR_score() %></td>           
							<td width=30% height=50 align=center class=t1><%=review.getReviewdesc() %></td>           
							<td width=30% height=50 align=center class=t1><%=review.getU_id() %></td>           
								</tr>
				<%}%>
				</table>

<% } else { %>
		<tr width=100%>
							<td width=100% height=50 align=center class=t1>리뷰가 없습니다.</td>                                         
								</tr>
			</table>
			<%} %>
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