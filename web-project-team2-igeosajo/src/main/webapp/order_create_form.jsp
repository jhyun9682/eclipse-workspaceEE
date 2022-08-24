<%@page import="com.itwill.toy.domain.Product"%>
<%@page import="com.itwill.toy.domain.Member"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.itwill.toy.domain.Cart"%>
<%@page import="com.itwill.toy.service.ProductService"%>
<%@page import="com.itwill.toy.service.MemberService"%>
<%@page import="com.itwill.toy.service.CartService"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf"%>
<%
if (request.getMethod().equalsIgnoreCase("GET")) {
	response.sendRedirect("order_list.jsp");
	return;
}

String buyType = request.getParameter("buyType");
String p_noStr = request.getParameter("c_no");
String p_qtyStr = request.getParameter("c_qty");
String[] cart_item_noStr_array = request.getParameterValues("cart_no");

System.out.println(buyType);
System.out.println(p_noStr);
System.out.println(p_qtyStr);

if(buyType==null)buyType="";
if(p_noStr==null)p_noStr="";
if(p_qtyStr==null)p_qtyStr="";
if(cart_item_noStr_array==null)cart_item_noStr_array=new String[]{};

CartService cartService = new CartService();
MemberService memberService = new MemberService();
ProductService productService = new ProductService();
ArrayList<Cart> cartItemList = new ArrayList<>();
Member member = memberService.findMember(sM_id); 
int m_point = member.getM_point();

if (buyType.equals("cart_select")) {
	for (String cart_item_noStr : cart_item_noStr_array) {
		cartItemList.add(cartService.getCartItemByCartNo(Integer.parseInt(cart_item_noStr)));
	}
} else if (buyType.equals("direct")) {
	Product product = productService.getProduct(Integer.parseInt(p_noStr));
	cartItemList.add(new Cart(0, Integer.parseInt(p_qtyStr), product, member));
}

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>쇼핑몰 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">

<script type="text/javascript">
	function use_point_func(){
		if(parseInt(point1.value) > parseInt(point2.value)){
			point1.value = "";
			alert("사용 가능한 적립금을 초과하였습니다");
		}
		if(point1.value == "") {
			point2.value = <%=m_point%>;
		}
		if(isNaN(point1.value)) {
			point1.value = "";
			alert("숫자만 입력 가능합니다");
		}
		point2.value = <%=m_point%>; 
		point2.value -= point1.value; 
	}
	
	function order_create_form_submit() {
		if(rv_n.value == "" || rv_p.value == "" || rv_a.value == "" || rv_m.value == ""){
			alert("배송지 정보를 모두 입력해주세요");
			return;
		}
		document.order_create_form.method = 'POST';
		document.order_create_form.action = 'order_create_action.jsp';
		document.order_create_form.submit();
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
			<jsp:include page="include_common_top.jsp" />
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
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>
											주문서작성</b></td>
								</tr>
							</table> <!--form-->
							<form name="order_create_form">
									<input type="hidden" name="buyType" value="<%=buyType%>"> <input
											type="hidden" name="p_no" value="<%=p_noStr%>"> <input
											type="hidden" name="p_qty" value="<%=p_qtyStr%>">
										<%
										for (String cart_item_noStr : cart_item_noStr_array) {
										%>
										<input type="hidden" name="cart_item_no" value="<%=cart_item_noStr%>">
										<%
										}
										%>
								<table align=center width=80% border="0" cellpadding="0"
									cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;font-weight:bold;padding-bottom: 7px"><span style="border-left: 4px solid #888888;"></span>&nbsp;&nbsp;주문할상품</caption>
									<tr style="border: 0.1px solid">
										<td width=30 height=25 bgcolor="E6ECDE" align=center class=t1></td>
										<td width=260 height=25 bgcolor="E6ECDE" align=center class=t1>구입상품명</td>
										<td width=112 height=25 bgcolor="E6ECDE" align=center class=t1>수량</td>
										<td width=166 height=25 bgcolor="E6ECDE" align=center class=t1>가격</td>
									</tr>
									<% 
									int tot_price = 0;
									for (Cart cart : cartItemList) {
										tot_price += cart.getC_qty() * cart.getProduct().getP_price();
									%>
									<!-- cart item start -->
									<tr>
										<td width=30 height=26 align=center bgcolor="ffffff" class=t1>
											<a
											href='product_detail.jsp?p_no=<%=cart.getProduct().getP_no()%>'><img width="30"  height="26" src="image/<%=cart.getProduct().getP_image()%>"></a>
										</td>
										<td width=260 height=26 align=center bgcolor="ffffff" class=t1>
											<a
											href='product_detail.jsp?p_no=<%=cart.getProduct().getP_no()%>'><%=cart.getProduct().getP_name()%></a>
										</td>
										<td width=112 height=26 align=center bgcolor="ffffff" class=t1><%=cart.getC_qty()%></td>
										<td width=166 height=26 align=center bgcolor="ffffff" class=t1>
											<%=new DecimalFormat("#,###").format(cart.getC_qty() * cart.getProduct().getP_price())%>
										</td>
									</tr>
									<!-- cart item end -->
									<%}%>
									<input type="hidden" name="t_price" value="<%=tot_price %>" />
									<tr>
										<td width=640 colspan=5 height=26 bgcolor="ffffff" class=t1>
											<p align=right style="padding-top: 10px">
												<font color=#FF0000>총 주문 금액 : <%=new DecimalFormat("#,###").format(tot_price)%>
												</font>
											</p>
										</td>
									</tr>
								</table>
								<br/>
								<table align=center width=80% border="0" cellpadding="0" cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;font-weight:bold;padding-bottom: 7px"><span style="border-left: 4px solid #888888;"></span>&nbsp;&nbsp;주문자정보</caption>
									<tr>
										<td width="86px" bgcolor="E6ECDE" height=26 align=center bgcolor="ffffff" class=t1>이름</td>
										<td height=26 align="left"  bgcolor="ffffff" class=t1 colspan="3" >&nbsp;&nbsp;<%=member.getM_name()%></td>
									</tr>	
									<tr>
										<td width="86px" bgcolor="E6ECDE"  height=26 align=center bgcolor="ffffff" class=t1>이메일</td>
										<td  height=26 align=left bgcolor="ffffff" class=t1>
											&nbsp;&nbsp;<%=member.getM_email()%>
										</td>
										<td bgcolor="E6ECDE"  width="10%"  height=26 align=center bgcolor="ffffff" class=t1>연락처</td>
										<td  height=26 align=left bgcolor="ffffff" class=t1>
										&nbsp;&nbsp;<%=member.getM_phone()%>
										</td>
									</tr>
									
								</table>

								<br />
								<table align=center width=80% border="0" cellpadding="0"
									cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;font-weight:bold;padding-bottom: 7px"><span style="border-left: 4px solid #888888;"></span>&nbsp;&nbsp;배송지정보</caption>

									<tr>
										<td bgcolor="E6ECDE" height=26 align=center bgcolor="ffffff" class=t1>이름</td>
										<td height=26 align="center"  bgcolor="ffffff" class=t1 >
											<input type="text" style="width:100px" id="rv_n" name="rv_name"/>
										</td>
										<td bgcolor="E6ECDE" height=26 align=center bgcolor="ffffff" class=t1>연락처</td>
										<td height=26 align="center"  bgcolor="ffffff" class=t1 >
											<input type="text" style="width:150px" id="rv_p" name="rv_phone" />
										</td>
									</tr>	
									<tr>
										<td bgcolor="E6ECDE"  height=26 align=center bgcolor="ffffff" class=t1 rowspan="4">주소</td>
									</tr>
									<tr>
										
										<td height=26 align=left bgcolor="ffffff" class=t1  colspan="5">
											&nbsp;&nbsp;[전체주소]&nbsp;&nbsp;<input type="text" style="width:180px" id="rv_a" name="rv_addr"><br>
										</td>
									</tr>
									<tr>
										<td bgcolor="E6ECDE"   height=26 align=center bgcolor="ffffff" class=t1>주문메세지<br>(100자내외)</td>
										<td height=26 align=left bgcolor="ffffff" class=t1 colspan="5" style="padding-top: 5px">
											&nbsp;&nbsp;<textarea rows="3" cols="80" id="rv_m" name="rv_message"></textarea>
										</td>
									</tr>
									
								</table>
								<br>
								<table align=center width=80% border="0" cellpadding="0" cellspacing="1" bgcolor="BBBBBB">
									<caption style="text-align: left;font-weight:bold;padding-bottom: 7px"><span style="border-left: 4px solid #888888;"></span>&nbsp;&nbsp;적립금사용</caption>
									<tr>
										<td height=26 align="left"  bgcolor="ffffff" class=t1 colspan="3" >&nbsp;&nbsp;<input type="text" id="point1" name="use_point" onkeyup="use_point_func()" />원<font color="red"> ←</font><input type="text" readonly id="point2" value="<%=m_point %>"/>원(사용가능 적립금)</td>
									</tr>	
									
								</table>
							</form>
							<br />
							<table border="0" cellpadding="0" cellspacing="1" width="590">
								<tr>
									<td align=center>&nbsp;&nbsp; <a
										href="javascript:order_create_form_submit();" class=m1>구매/결재하기</a>
										&nbsp;&nbsp;<a href=product_list.jsp class=m1>계속 쇼핑하기</a>

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