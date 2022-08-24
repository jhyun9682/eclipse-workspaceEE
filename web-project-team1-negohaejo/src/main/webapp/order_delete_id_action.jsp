<%@page import="com.itwill.shop.dto.Purchase"%>
<%@page import="com.itwill.shop.service.PurchaseService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf"%>
    <%
    PurchaseService purchaseService = new PurchaseService();
    purchaseService.p_deleteById(s_u_id);
    response.sendRedirect("order_list.jsp");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>u_id delete</h1>
해당 아이디 주문목록 전체 삭제 : <%=s_u_id%>

</body>
</html>