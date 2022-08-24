<%@page import="com.itwill.shop.dto.Purchase"%>
<%@page import="com.itwill.shop.service.PurchaseService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="login_check.jspf"%>    
    <%
    String o_noStr=request.getParameter("o_no");
    PurchaseService purchaseService = new PurchaseService();
    //int o_noStr = 3;
    //purchaseService.p_deleteByNo(o_noStr);
    
   int result = purchaseService.p_deleteByNo(Integer.parseInt(o_noStr));
   response.sendRedirect("order_list.jsp");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 
</head>
<body>
<h1>o_no delete</h1>
삭제 번호: <%=o_noStr%> 

</body>
</html>