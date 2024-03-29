<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String msg = request.getParameter("msg");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/user.css" type="text/css">
<script type="text/javascript">
	function userCreate() {
		f.action = "memberJoin.jsp";
		f.submit();
	}
	
	function login() {
		if (f.memberId.value == "") {
			alert("사용자 아이디를 입력하십시요.");
			f.memberId.focus();
			return false;
		}
		
		if (f.password.value == "") {
			alert("비밀번호를 입력하십시요.");
			f.password.focus();
			return false;
		}
		
		f.action = "memberLoginAction.jsp";
		f.submit();
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

				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">
										&nbsp;&nbsp;<b>사용자 관리 - 로그인</b>
									</td>
								</tr>
								<%
								if (msg != null){
								%>
								<tr>
									<td height="22">
									&nbsp;&nbsp;<font color="red"><b><%= msg %></b></font>
									</td>
								</tr>
								<%
								}
								%>
							</table> <!-- login Form  -->
							<form name="f" method="post">
								<table border="0" cellpadding="0" cellspacing="1"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">사용자
											아이디</td>
										<td width=490 align="left" bgcolor="ffffff" style="padding-left: 10px">
											<input type="text"
											style="width: 150" name="memberId"
											value="">&nbsp;&nbsp;<font
											color="red"></font>
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
										<td width=490 align="left" bgcolor="ffffff" style="padding-left: 10px">
											<input type="password"
											style="width: 150" name="password"
											value="">&nbsp;&nbsp;<font
											color="red"></font>
										</td>
									</tr>
								</table>
							</form> <br />
							<table border="0" cellpadding="0" cellspacing="1">
								<tr>
									<td align=center>
										<input type="button" value="로그인" onClick="login()">
										&nbsp;
										<input type="button" value="회원가입" onClick="userCreate()">
									</td>
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
			<jsp:include page="includeCommonBottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>
