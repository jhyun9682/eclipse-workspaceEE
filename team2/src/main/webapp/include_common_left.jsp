<%@page import="java.util.ArrayList"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%


	String sUserId=(String)session.getAttribute("sUserId");
%>	
<script type="text/javascript">
	function login_message() {
		alert('로그인하세요');
		location.href = 'userinfo_login_form.jsp';
	}
</script>
<p>
	<strong>메 뉴</strong>
</p>
<ul>
	<%
		if(sUserId==null){
	%>
	    <li><a href="userinfo_login_form.jsp">로그인</a></li>
		<li><a href="userinfo_insert_form.jsp">회원가입</a></li>
		<li><a href=""></a></li>
		<li><a href="book_search_form.jsp">도서 검색</a></li>
		<li><a href="book_list.jsp">도서 목록</a></li>
		<li><a href=""></a></li>
		<li><a href=""></a></li>
		<li><a href="notice_list.jsp">공지사항</a></li>
		<li><a href="qna_list.jsp">QNA</a></li>
		
	<%}else{ %>
		<li><a href="userinfo_view.jsp"><%=sUserId%> 님</a></li>
		<li><a href="userinfo_logout_action.jsp">로그아웃</a></li>
		<li><a href=""></a></li>
		<li><a href="book_search_form.jsp">도서 검색</a></li>
		<li><a href="book_list.jsp">도서 목록</a></li>
		<li><a href="cart_view.jsp">장바구니<span class="w3-badge w3-badge-menu w3-green cart_item_count"></span></a></li>
		<li><a href="order_list.jsp">주문목록</a></li>
		<li><a href=""></a></li>
		<li><a href="notice_list.jsp">공지사항</a></li>
		<li><a href="qna_list.jsp">QNA</a></li>
		<li><a href=""></a></li>
	<%} %>
</ul>
