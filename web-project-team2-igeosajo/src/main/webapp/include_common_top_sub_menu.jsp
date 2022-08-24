<%@page import="com.itwill.toy.service.CartService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String sM_id = (String) session.getAttribute("sM_id");
if (sM_id != null) {
	
}
%>
<div id="cat_menu">
	<ul>
		<li id="cat_menu_01"><a href='product_list1.jsp'></a></li>
		<li id="cat_menu_02"><a href='product_list2.jsp'></a></li>
		<li id="cat_menu_03"><a href='product_list3.jsp'></a></li>
		<li id="cat_menu_04"><a href='product_list4.jsp'></a></li>
		<li id="cat_menu_05"><a href='product_list.jsp'></a></li>
	</ul>
</div>
	