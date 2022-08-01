<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="memberLoginCheck.jspf"%>
<!DOCTYPE html>
<html>
<head>
<title>게시판쓰기</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<link rel=stylesheet href="css/cart.css" type="text/css">
<script type="text/javascript">
function qnaCreate() {
	if (f.title.value == "") {
		alert("제목을 입력하십시요.");
		f.title.focus();
		return false;
	}

	if (f.content.value == "") {
		alert("내용을 입력하십시요.");
		f.content.focus();
		return false;
	}
			
	f.action = "qnaWriteAction.jsp";
	f.submit();
	}

	function qnaList() {
		f.action = "qnaList.jsp";
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
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>게시판 -
											게시판 쓰기</b></td>
								</tr>
							</table> <br> <!-- write Form  -->
							<form name="f" method="post" enctype="multipart/form-data">
								<table border="0" cellpadding="0" cellspacing="1" width="590"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">제목</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><input type="text" style="width: 150px"
											name="title"></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">비밀글 여부</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
										<input type="radio"  name="open" value="1" checked="checked">공개
										<input type="radio"  name="open" value="0" >비공개</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">파일 첨부</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px" align="left">
										<input type=file  name=fileone size=50 class="TXTFLD">
										</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE">내용</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><textarea name="content" class="textarea"
												style="width: 350px" rows="14"></textarea></td>
									</tr>
								</table>
							</form> <br>
							<table width=590 border=0 cellpadding=0 cellspacing=0>
								<tr>
									<td align=center><input type="button" value="게시판 쓰기"
										onClick="qnaCreate();"> &nbsp; <input type="button"
										value="게시판 목록" onClick="qnaList();"></td>
								</tr>
							</table><br></td>
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