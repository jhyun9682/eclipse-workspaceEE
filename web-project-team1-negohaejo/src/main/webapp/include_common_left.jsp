
<%@page import="com.itwill.shop.dto.User"%>
<%@page import="com.itwill.shop.service.CartService"%>

<%@page import="com.itwill.shop.service.UserService"%>
<%@page import="java.util.ArrayList"%>

<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String sUserId=(String)session.getAttribute("sUserId");
%>	
<script type="text/javascript">
	function login_message() {
		alert('로그인하세요');
		location.href = 'user_login_form.jsp';
	}
</script>
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	
		<li><a href="product_list.jsp">상품리스트</a></li>
		<li><a href="product_list.jsp?p_cat=chair">의자</a></li>
		<li><a href="product_list.jsp?p_cat=bed">침대</a></li>
		<li><a href="product_list.jsp?p_cat=desk">책상</a></li>
		
</ul>
