<%@page import="com.itwill.shop.dto.Notice"%>
<%@page import="com.itwill.shop.service.NoticeService"%>
<%@page import="com.itwill.shop.service.PurchaseService"%>
<%@page import="com.itwill.shop.service.UserService"%>
<%@page import="com.itwill.shop.dto.User"%>
<%@page import="com.itwill.shop.service.CartService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script type="text/javascript" src="js/common.js"></script>
<%
	String sUserId=(String)session.getAttribute("s_u_id");

%>

<div id="menu">
	<ul>
<li><%if(sUserId==null) {%>
		<li id="m_login"><a href="user_login_form.jsp">로그인</a></li>
		<li id="m_join"><li><a href="user_write_form.jsp">회원가입</a></li></li>
		<li id="m_mypage"><a href="javascript:login_message();">장바구니</a></li>
		<li id="m_order"><a href="javascript:login_message();">주문목록</a></li>
		<%}else{
		User sUser=new UserService().findUser(sUserId);
		CartService cartService=new CartService();
		int cart_item_count=cartService.getCartList(sUserId).size();
		PurchaseService purchaseService = new PurchaseService();
		int order_item_count=purchaseService.p_list(sUserId).size();
		NoticeService noticeService = new NoticeService();
		%>
		<li><a href="user_view.jsp"><%=sUser.getU_name()+"님"%></a></li>
		<li><a href="user_logout_action.jsp">로그아웃</a></li>
		<li><a href="user_modify_password_form.jsp">비밀번호 변경</a></li>
		<li><a href="cart_view.jsp">장바구니<span class="w3-badge w3-badge-menu w3-green cart_item_count"><%=cart_item_count%></span></a></li>
		<li id="m_order"><a href="order_list.jsp">주문목록<span class="w3-badge w3-badge-menu w3-green order_item_count"><%=order_item_count%></span></a></li>
		<%}%>
		<li id="m_customer"><a href="notice_list.jsp">공지사항</a></li>
		<a href="main.jsp"><li id="logo"><img src="image/메인로고.jpeg"></li></a>


	</ul>
<ul id="sub_menu">
	<li id="search_form">
			<form style="margin: 10px" action="product_list.jsp">
				<select name="p_cat">
					<option value="">전체검색</option>
					<option value="chair">의자</option>
					<option value="bed">침대</option>
					<option value="desk">책상</option>
				</select>
				<input type="search" name="keyword" onmousedown="space_not()">&nbsp;&nbsp;&nbsp;<input type="submit" value="검색">
			</form>
		</li>
	</ul>
</div>