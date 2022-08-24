<%@page import="com.itwill.shop.dto.Product"%>
<%@page import="com.itwill.shop.service.ProductService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //int p_no=Integer.parseInt(request.getParameter("p_no"));
   int p_no=3;
    ProductService productService = new ProductService();
    Product product=productService.getProductByNo(p_no);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p><%=product%></p>
</body>
</html>