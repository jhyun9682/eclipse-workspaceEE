<%@page import="com.itwill.librarian.domain.Faq"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.itwill.librarian.service.FaqService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	FaqService faqService = new FaqService();
	ArrayList<Faq> faqList = faqService.getFaqList();
%>


<!DOCTYPE html>
<html>
<head>
<title>자주 물어보는 질문(FAQ)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/board.css" type="text/css">
<link rel=stylesheet href="css/faq.css" type="text/css">
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="includeCommonTop.jsp" />
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="includeCommonLeft.jsp" />
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content.jsp start-->
			<div id="content">
				<h1>자주 물어보는 질문(FAQ)</h1>
				<ul class="faq">
				<% for(Faq faq : faqList) { %>
		            <li>
						<input type="checkbox" id="faq-<%= faq.getFaqNo() %>">
						<label for="faq-<%= faq.getFaqNo() %>"><%= faq.getFaqQuestion() %></label>
						<div>
							<p><%= faq.getFaqAnswer() %></p>
						</div>
		        	</li>
		        <% } %>
		        </ul>
		    </div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="includeCommonBottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>