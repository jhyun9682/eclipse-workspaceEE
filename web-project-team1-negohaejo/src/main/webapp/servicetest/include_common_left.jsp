<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>	
<%
boolean isLogin=false;
String sUserId= "박유홍";
//(String)session.getAttribute("sUserId");
/*
if(sUserId==null){
	isLogin=false;
}else if(sUserId!=null){
	isLogin=true;
}
*/
%>    		
<p>
	<strong>메 뉴</strong>
</p>
<ul>
			
			<li><a href="product_list.jsp">전체</a></li>
			<li><a href="product_list.jsp?p_cat=chair">의자</a></li>
			<li><a href="product_list.jsp?p_cat=desk">책상</a></li>
			<li><a href="product_list.jsp?p_cat=bed">침대</a></li>
</ul>
