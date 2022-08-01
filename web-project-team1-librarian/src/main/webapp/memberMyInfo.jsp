<%@page import="com.itwill.librarian.domain.Member"%>
<%@page import="com.itwill.librarian.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="memberLoginCheck.jspf" %>      
<%
	MemberService memberService = new MemberService();
	Member member = memberService.getMember(Integer.parseInt(sMemberNo));
	
	//Member member = (Member)session.getAttribute("sMember");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>내정보</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/user.css" type="text/css">
<link rel=stylesheet href="css/cart.css" type="text/css">
<script type="text/javascript">
	function memberModify() {
		document.f.action = "memberMyInfoModify.jsp";
		document.f.method = "POST";
		document.f.submit();
	}
	function memberRemove() {
		//if (confirm("정말 삭제하시겠습니까?")) {
		document.f.action = "memberLeave.jsp";
		document.f.method='POST';
		document.f.submit();
		//}
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
										&nbsp;&nbsp;<b>내정보 관리 - 내정보보기</b>
									</td>
								</tr>
							</table> <!-- view Form  -->
							<form name="f" method="post">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">
											사용자 아이디
										</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10">
											<%= member.getMemberId() %>
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">
											이름
										</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10">
											<%= member.getMemberName() %>
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">
											이메일 주소
										</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10">
											<%= member.getMemberEmail() %>
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">
											대출 가능 수
										</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10">
											<%= Member.MAX_LOAN_CNT - member.getMemberLoan() %>
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">
											예약 가능 수
										</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10">
											<%= Member.MAX_RESERVE_CNT - member.getMemberReservation() %>
										</td>
									</tr>
								</table>
							</form> <br />
							<table border="0" cellpadding="0" cellspacing="1">
								<tr>
									<td align=center>
									<input type="button" value="내정보수정" onClick="memberModify()">&nbsp; 
									<input type="button" value="탈퇴" onClick="memberRemove()">&nbsp;
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
			<jsp:include page="includeCommonBottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>
