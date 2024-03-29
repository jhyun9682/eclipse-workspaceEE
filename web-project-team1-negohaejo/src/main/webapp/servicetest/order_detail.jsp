<%@page import="com.itwill.shop.service.UserService"%>
<%@page import="com.itwill.shop.dto.User"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.itwill.shop.dto.Purchase_Item"%>
<%@page import="com.itwill.shop.dto.Purchase"%>
<%@page import="com.itwill.shop.service.PurchaseService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String o_noStr=request.getParameter("o_no");
    if (o_noStr == null || o_noStr.equals("")) {
    	response.sendRedirect("order_list.jsp");
    	return;
    }
    PurchaseService purchaseService = new PurchaseService();
    UserService userService = new UserService();
    
    //Purchase purchase = purchaseService.p_Detail(3);
    Purchase purchase = purchaseService.p_Detail(Integer.parseInt(o_noStr));
    User user = userService.findUser(purchase.getU_ID());
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쇼핑몰 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css"> 

<style type="text/css" media="screen">
/*
form > table tr td{
	border: 0.1px solid black;
}
*/
</style>
<script type="text/javascript">
	
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="include_common_left.jsp" />
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp" />
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
											주문상세조회</b></td>
								</tr>
							</table> <!--form-->
							<form name="f" method="post" action="order_delete_action.jsp">
								<input type="hidden" name="j_no" value="<%=purchase.getO_No()%>">
								<table align="center" width="80%" border="0" cellpadding="0"
									cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;">주문상세정보</caption>
									<tr>
										<td width=290 height=25 bgcolor="E6ECDE" align=center class=t1><font>주문번호</font></td>
										<td width=112 height=25 bgcolor="E6ECDE" align=center class=t1><font>결제수단</font></td>
										<td width=166 height=25 bgcolor="E6ECDE" align=center class=t1><font>아이디 / 주문자 성명</font></td>
										<td width=50 height=25 bgcolor="E6ECDE" align=center class=t1><font>비 고</font></td>
									</tr>


									<tr>
										<td width=290 height=26 align=center bgcolor="ffffff" class=t1><%=purchase.getO_No()%></td>
										<td width=112 height=26 align=center bgcolor="ffffff" class=t1><%=purchase.getO_PaySelect()%></td>
										<td width=166 height=26 align=center bgcolor="ffffff" class=t1><%=purchase.getU_ID()%> / <%=user.getU_name() %></td>
										<td width=50 height=26 align=center bgcolor="ffffff" class=t1>
											<input type="submit" value="삭제">
										</td>
									</tr>
								</table>

								<br />
								<table align=center width=80% border="0" cellpadding="0"
									cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;">주문제품목록</caption>
									<tr style="border: 0.1px solid">
										<td width=290 height=25 align=center bgcolor="E6ECDE" class=t1>제품
											이름</td>
										<td width=112 height=25 align=center bgcolor="E6ECDE" class=t1>수
											량</td>
										<td width=166 height=25 align=center bgcolor="E6ECDE" class=t1>가
											격</td>
										<td width=50 height=25 align=center bgcolor="E6ECDE" class=t1>비
											고</td>
									</tr>

									<!-- orer item start -->
									<%
									int tot_price = 0;
									for (Purchase_Item purchaseItem : purchase.getPurchase_Itemlist()) {
										tot_price += purchaseItem.getOi_Qty() * purchaseItem.getProduct().getP_price();
									%>
									<tr>
										<td width=290 height=26 align=center bgcolor="ffffff" class=t1>
											<a
											href='product_detail.jsp?p_no=<%=purchaseItem.getProduct().getP_no()%>'>
												<%=purchaseItem.getProduct().getP_name()%></a>
										</td>

										<td width=112 height=26 align=center bgcolor="ffffff" class=t1>
											<%=purchaseItem.getOi_Qty()%>
										</td>

										<td width=166 height=26 align=center bgcolor="ffffff" class=t1>
											<%=new DecimalFormat("#,###").format(purchaseItem.getOi_Qty() * purchaseItem.getProduct().getP_price())%>
										</td>
										<td width=50 height=26 align=center class=t1 bgcolor="ffffff"></td>
									</tr>
									<%}%>
									<!-- cart item end -->
									<tr>
										<td width=640 colspan=4 height=26 bgcolor="ffffff" class=t1>

											<p align=right style="padding-top: 10px">
												<font color=#FF0000>총 주문 금액 : <%=new DecimalFormat("#,###.0").format(tot_price)%>
													원
												</font>
											</p>
										</td>
									</tr>
								</table>
							</form> <br />
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center>&nbsp;&nbsp;<a href=order_list.jsp
										class=m1>주문목록</a> &nbsp;&nbsp;<a href=product_list.jsp
										class=m1>계속 쇼핑하기</a>

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
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="include_common_bottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>