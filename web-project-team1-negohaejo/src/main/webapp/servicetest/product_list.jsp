<%@page import="com.itwill.shop.service.ProductService"%>
<%@page import="com.itwill.shop.dto.Product"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String keyword=request.getParameter("keyword");
 	String p_cat=request.getParameter("p_cat");
	String ord="p_cat";
	ProductService productService = new ProductService();
	List<Product> productList = productService.select(keyword,p_cat,ord,null);
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product List_메인페이지에 포함</title>
<script type="text/javascript">

</script>
</head>
<body>
<h1>product_list.jsp</h1><hr>
<%for(Product product:productList){ %>
<ol>
	<li><a href='product_detail.jsp?p_no=<%=product.getP_no()%>'><%=product%></a></li>
</ol> 
	<img src="<%=product.getP_img()%>">
<%} %>
</body>
</html>