<%@page import="com.itwill.librarian.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	boolean isDuplicate = false;
	String msg = "";
	
	String memberId = request.getParameter("memberId");
	
	if(memberId == null || memberId.equals("")){
		//최초윈도우를 띄울때
		memberId = "";
		msg="";
		isDuplicate = false;
	}else{
		MemberService memberService = new MemberService();
		isDuplicate = memberService.isDuplicateId(memberId);
		
		if(isDuplicate) {
			msg = "사용 가능한 아이디 입니다";
		} else {
			msg = "사용 불가능한 아이디입니다.";
		}
	}
	
%>	
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 중복 체크</title>

<style type="text/css">
#wrap {
	width: 490px;
	text-align: center;
	margin: 0 auto 0 auto;
}

#chk {
	text-align: center;
}

#cancelBtn {
	visibility: visible;
}

#useBtn {
	visibility: visible;
}
</style>

<script type="text/javascript">
	// 아이디 중복체크
	function idCheck() {
		var memberId = document.getElementById("memberId").value;
		
		if(memberId == null || memberId == '') {
			alert('검색할아이디를 입력하시고 중복체크를 하세요.');
			return;
		}
		
		document.getElementById('checkForm').action='memberIdCheck.jsp';
		document.getElementById('checkForm').method='POST';
		document.getElementById('checkForm').submit();
	}

	// 사용하기 클릭 시 부모창으로 값 전달 
	function sendCheckValue() {
		// 중복체크 결과인 idCheck 값을 전달한다.
		// 회원가입 화면의 ID입력란에 값을 전달
		opener.document.f.memberId.value = window.document.getElementById('memberId').value;
		window.close();
	}
</script>

</head>
<body>
	<div id="wrap">
		<br> <b><font size="4" color="gray">아이디 중복체크</font></b>
		<hr size="1" width="460">
		<br>
		<div id="chk">
			<form id="checkForm">
				<input type="text" name="memberId" id="memberId" value="<%= memberId %>">
				<input type="button" value="중복확인" onclick="idCheck()">
			</form>
			<div id="msg"><%= msg %></div>
			<br> 
			<input id="cancelBtn" type="button" value="취소" onclick="window.close();"> 
			<% if(isDuplicate) { %>
			<input id="useBtn" type="button" value="사용하기" onclick="sendCheckValue()">
			<% } %>
		</div>
	</div>
</body>
</html>