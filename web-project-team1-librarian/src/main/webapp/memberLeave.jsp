<%@page import="com.itwill.librarian.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="memberLoginCheck.jspf" %>  
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("index.jsp");
		return;
	}
	
	MemberService memberService = new MemberService();
	Member member = memberService.getMember(Integer.parseInt(sMemberNo));
	
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>회원 탈퇴</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/user.css" type="text/css">
<script type="text/javascript">
	function memberLeaveAction() {
		if(confirm('정말로 탈퇴 하시겠습니까?')) {
			document.f.action = "memberLeaveAction.jsp";
			document.f.method='POST';
			document.f.submit();
		}
	}

</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="includeCommonTop.jsp"/>
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="includeCommonLeft.jsp"/>
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->

			<!-- include_content.jsp start-->
			<div id="content">

				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td>
							<!--contents--> <br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">
										&nbsp;&nbsp;<b>내정보 관리 - 회원 탈퇴</b>
									</td>
								</tr>
							</table> <!-- update Form  -->
							<form name="f" method="post">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">
											사용자 아이디
										</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><%= member.getMemberId() %>
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">
											의견
										</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><%-- <input type="text" style="width: 150px"
											name="name" value="<%= member.getMemberName() %>"> --%>
											<textarea name="opinion" style="resize: none;"
											cols="30" rows="10" 
											placeholder="탈퇴를 하시며 의견을 나눠 주신다면 저희에게 큰 도움이 됩니다"></textarea>
										</td>
									</tr>
								</table>
							</form> <br>
							<table width=590 border=0 cellpadding=0 cellspacing=0>
								<tr>
									<td align=center><input type="button" value="회원 탈퇴"
										onClick="memberLeaveAction();"> &nbsp;</td>
								</tr>
							</table>
						
						</td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="includeCommonBottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>
