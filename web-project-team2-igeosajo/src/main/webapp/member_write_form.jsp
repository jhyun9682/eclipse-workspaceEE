<%@page import="com.itwill.toy.domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg=(String)request.getAttribute("msg");
	if(msg==null){
		  msg="";
	}
	Member fmember=(Member)request.getAttribute("fmember");
	if(fmember==null){
		fmember=new Member("","","","","","","","",0);
	}
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>사용자 관리</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/member.css" type="text/css">
 
<style type="text/css" media="screen">
</style>
<script type="text/javascript">
	function userCreate() {
		if (document.f.m_id.value == "") {
			alert("사용자 아이디를 입력하십시요.");
			f.m_id.focus();
			return false;
		}
		if (f.m_password.value == "") {
			alert("비밀번호를 입력하십시요.");
			f.m_password.focus();
			return false;
		}
		
		if (f.m_name.value == "") {
			alert("이름을 입력하십시요.");
			f.m_name.focus();
			return false;
		}
		if (f.m_email.value == "") {
			alert("이메일 주소를 입력하십시요.");
			f.m_email.focus();
			return false;
		}
		if (f.m_birth.value == "") {
			alert("생년월일을 입력하십시요.");
			f.m_birth.focus();
			return false;
		}
		if (f.m_gender.value != "M" && f.m_gender.value != "F" ) {
			alert("(남성은 M,여성은 F)만 입력 가능합니다.");
			f.m_gender.focus();
			return false;
		}
		if (f.m_address.value == "") {
			alert("주소를 입력하십시요.");
			f.m_address.focus();
			return false;
		}
		if (f.m_phone.value == "") {
			alert("휴대폰 번호를 입력하십시요.");
			f.m_phone.focus();
			return false;
		}
		if (f.m_point.value != "1000") {
			alert("포인트는 변경 불가합니다.");
			f.m_point.focus();
			return false;
		}
		
		f.action = "member_write_action.jsp";
		f.method='POST';
		f.submit();
	}
	function memberList() {
		f.action = "member_list.jsp";
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
			<jsp:include page="include_common_top.jsp"/>
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="include_common_left.jsp"/>
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content.jsp start-->
			<div id="content">
				<table width=0 border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td>
							<!--contents--> <br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리
											- 회원 가입</b></td>
								</tr>
							</table> <!-- write Form  -->
							<form name="f" method="post">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">사용자
											아이디</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="m_id"
											value="<%=fmember.getM_id()%>">&nbsp;&nbsp;<font color="red"><%=msg%></font>
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="password" style="width: 150px" name="m_password"
											value="<%=fmember.getM_password()%>">
										</td>
									</tr>
									
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이름</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="m_name"
											value="<%=fmember.getM_name()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">이메일
											주소</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="m_email"
											value="<%=fmember.getM_email()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">생년월일 ex)951004
											</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="m_birth"
											value="<%=fmember.getM_birth()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">성별 ex)남성M,여성F
											</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="m_gender"
											value="<%=fmember.getM_gender()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">주소
											</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="m_address"
											value="<%=fmember.getM_address()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">휴대폰번호(-제외)
											</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="text" style="width: 150px" name="m_phone"
											value="<%=fmember.getM_phone()%>">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">포인트
											</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
											<input type="hidden" style="width: 150px" name="m_point"
											value="1000" >1000
										</td>
									</tr>
								</table>
							</form> <br />

							<table border=0 cellpadding=0 cellspacing=1>
								<tr>
									<td align=center><input type="button" value="회원 가입"
										onclick="userCreate();">
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
			<jsp:include page="include_common_bottom.jsp"/>
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>