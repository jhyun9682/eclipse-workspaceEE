<%@page import="com.itwill.toy.service.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="login_check.jspf"%>
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("product_list.jsp");
		return;
	}
	/*
	1.파라메타받기(cart_qty,p_no)
	2.장바구니에 제품을담고 cart_view.jsp로redirection
	*/

	String cart_qtyStr=request.getParameter("c_qty");
	String p_noStr=request.getParameter("p_no");
	CartService cartService=new CartService();
	cartService.addCart(Integer.parseInt(cart_qtyStr),Integer.parseInt(p_noStr),sM_id);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
<div style="width:250px ;margin:0 auto;padding: 10px">
	<img src="http://pics.gmkt.kr/pc/ko/item/vip/img_cartplus_n.png" width="33px" height="33px"
		alt="장바구니이미지">
	<strong>상품을 담았습니다.</strong>
	<div  style="margin-top: 15px;margin-left: auto;margin-right: auto;padding: 10px" >
		<div  style="margin: 0 auto;padding: 0px 20px">
			<button onclick="window.close();opener.location.reload();">
				계속 쇼핑
			</button>
			<!-- 
			<button onclick="window.close();opener.location.href='cart_view_select_update_qyt_image.jsp';">
				장바구니로
			</button> 
			-->
			<button onclick="window.close();opener.location.href='cart_view.jsp';">
				장바구니로
			</button>
		</div>
	</div>
</div>
</body>
</html>
