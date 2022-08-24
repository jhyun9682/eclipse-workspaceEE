<%@page import="com.itwill.toy.domain.OrderItem"%>
<%@page import="com.itwill.toy.domain.Order"%>
<%@page import="com.itwill.toy.service.OrderService"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf" %>
<%
	String o_noStr = request.getParameter("o_no");
	if(o_noStr == null || o_noStr.equals("")) {
		response.sendRedirect("order_list.jsp");
		return;
	}
	OrderService orderService = new OrderService();
	Order order = orderService.detail(sM_id, Integer.parseInt(o_noStr));
%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쇼핑몰 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
 
<style type="text/css" media="screen">
</style>
<script type="text/javascript">
	function check_delete_order(){
		return confirm("정말 삭제하시겠습니까?");
	}
</script>
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
											주문상세조회</b></td>
								</tr>
							</table> <!--form-->
							<form name="f" method="post" action="order_delete_action.jsp" onsubmit="return check_delete_order()">
								<input type="hidden" name="o_no" value="<%=order.getO_no()%>">
									<table align="center" width="80%"  border="0" cellpadding="0" cellspacing="1"  bgcolor="BBBBBB" >
										<caption style="text-align: left;font-weight:bold;padding-bottom: 7px"><span style="border-left: 4px solid #888888;"></span>&nbsp;&nbsp;주문자정보</caption>
										
										<tr>
											<td width=150 height=25 bgcolor="E6ECDE" align=center class=t1><font
												>주문번호</font></td>
											<td width=112 height=25 bgcolor="E6ECDE" align=center class=t1><font
												>주문일</font></td>
											<td width=166 height=25 bgcolor="E6ECDE" align=center class=t1><font
												>주문자</font></td>
											<td width=190 height=25 bgcolor="E6ECDE" align=center class=t1><font
												>주문메모</font></td>
											<td width=190 height=25 bgcolor="E6ECDE" align=center class=t1><font
												>비 고</font></td>
										</tr>
										
										
										<tr>
											<td width=150 height=26 align=center bgcolor="ffffff" class=t1><%=order.getO_no()%></td>
											<td width=112 height=26 align=center bgcolor="ffffff" class=t1><%=order.getO_date()%></td>
											<td width=166 height=26 align=center bgcolor="ffffff" class=t1><%=order.getM_Id()%></td>
											<td width=190 height=26 align=center bgcolor="ffffff" class=t1><%=order.getO_message()%></td>
											<td width=190 height=26 align=center bgcolor="ffffff" class=t1><input type="submit" value="삭제"></td>
										</tr>
									</table>
								<br>
								<table align="center" width="80%"  border="0" cellpadding="0" cellspacing="1"  bgcolor="BBBBBB" >
									<caption style="text-align: left;font-weight:bold;padding-bottom: 7px"><span style="border-left: 4px solid #888888;"></span>&nbsp;&nbsp;배송지정보</caption>
									
									<tr>
										<td width=150 height=25 bgcolor="E6ECDE" align=center class=t1><font
											>수취인</font></td>
										<td width=112 height=25 bgcolor="E6ECDE" align=center class=t1><font
											>수취인연락처</font></td>
										<td width=356 height=25 bgcolor="E6ECDE" align=center class=t1 colspan="2"><font
											>주 소</font></td>
										
									</tr>
									
									<tr>
										<td width=150 height=26 align=center bgcolor="ffffff" class=t1><%=order.getO_rv_name() %></td>
										<td width=112 height=26 align=center bgcolor="ffffff" class=t1><%=order.getO_rv_phone() %></td>
										<td width=356 height=26 align=center bgcolor="ffffff" class=t1 colspan="2"><%=order.getO_rv_address() %></td>
										
									</tr>
								</table>	
								<br/>	
								
								<table align=center width=80% border="0" cellpadding="0"
									cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;font-weight:bold;padding-bottom: 7px"><span style="border-left: 4px solid #888888;"></span>&nbsp;&nbsp;주문상품정보</caption>
									<tr style="border: 0.1px solid">
										<td width=30 height=25 bgcolor="E6ECDE" align=center class=t1></td>
										<td width=260 height=25 bgcolor="E6ECDE" align=center class=t1>상품명</td>
										<td width=112 height=25 bgcolor="E6ECDE" align=center class=t1>수 량</td>
										<td width=166 height=25 bgcolor="E6ECDE" align=center class=t1>가 격</td>
										<td width=50 height=25 bgcolor="E6ECDE" align=center class=t1>비 고</td>
									</tr>
									
									<!-- order item start -->
									<%
										int tot_price=0;
										for(OrderItem orderItem : order.getOrderItemList()) {
											tot_price += orderItem.getOi_qty() * orderItem.getProduct().getP_price();
									%>
									<tr>
										<td width=30 height=26 align=center bgcolor="ffffff" class=t1>
											<a
											href='product_detail.jsp?p_no=<%=orderItem.getProduct().getP_no()%>'><img width="30"  height="26" src="image/<%=orderItem.getProduct().getP_image()%>"></a>
										</td>
										<td width=260 height=26 align=center bgcolor="ffffff" class=t1>
											<a
											href='product_detail.jsp?p_no=<%=orderItem.getProduct().getP_no()%>'><%=orderItem.getProduct().getP_name()%></a>
										</td>
										<td width=112 height=26 align=center bgcolor="ffffff" class=t1><%=orderItem.getOi_qty()%></td>
										<td width=166 height=26 align=center bgcolor="ffffff" class=t1>
											<%=new DecimalFormat("#,###").format(orderItem.getOi_qty()*orderItem.getProduct().getP_price())%>
										</td>
										<td width=50 height=26 align=center bgcolor="ffffff" class=t1></td>
										<%}%>
									</tr>
									<!-- order item end -->
									
									<tr>
										<td width=640 colspan=5 height=26 bgcolor="ffffff" class=t1>
											<p align=right style="padding-top: 10px">
												<font color=#FF0000>총 주문 금액 : <%=new DecimalFormat("#,###").format(order.getO_price())%> 
													원
												</font>
											</p>
										</td>
									</tr>
								</table>
							</form> <br />
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center> 
										&nbsp;&nbsp;<a href=order_list.jsp
										class=m1>주문목록</a>
										&nbsp;&nbsp;<a href=product_list.jsp
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
			<jsp:include page="include_common_bottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>