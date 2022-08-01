<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<title>회원 가입</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	/*
	selector
	   1. tag selector
	       -selector로 기술된 모든 태그에 css속성적용
	*/
	body {
		background-color: aliceblue;
		color:#555555;
	}
	h1,h2,h3{
		color: maroon;
	}
	form{
		color: navy;
		border: 1px dotted black;
		width: 600px;
		margin: 0 auto;
	}
	/*
		2. class selector
		  - tag의 class속성과 일치하는 tag에적용
		  - selector 이름앞에 .을기술
	*/
	.txtfld{
		color:blue;
		border: 1px solid blue;
	}
	.passfld{
		color:red;
		border: 1px dotted red;
	}
	/*
		3. id selector
		  - tag의 id속성과 일치하는 태그에적용
		  - selector 이름앞에  #을 기술
	*/
	
	#jointbl{
		width: 400px;
		background-color: mistyrose;
		padding-top: 10px;
		padding-left: 10px;
	}
	#first-tr{
		color:orange;
		background-color: gray;
	}
	
	
</style>
</head>
<body>
	<h3 align="center">◆◆◆ 회원가입 ◆◆◆</h3>
	<form name="join" method="POST" action="4.join2.jsp">
		<table id="jointbl" bgcolor="black" cellspacing="1" cellpadding="5" align="center">
			<tr id="first-tr">
				<th ><font size="2">아이디</font></th>
				<td  width="300"><input type="text" size="10"
					name="id" class="txtfld"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">비밀번호</font></th>
				<td bgcolor="white" width="300"><input type="password"
					size="10" name="pass" class="passfld"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">비밀번호확인</font></th>
				<td bgcolor="white" width="300"><input type="password"
					size="10" name="repass" class="passfld"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">이름</font></th>
				<td bgcolor="white" width="300"><input type="text" size="10"
					name="name" class="txtfld"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">주소</font></th>
				<td bgcolor="white" width="300"><input type="text" size="30"
					name="addr" class="txtfld"></td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">성별</font></th>
				<td bgcolor="white" width="300">
				<input type="radio" name="gender" value="M">
				<font size="2">남자</font> 
				<input type="radio" name="gender" value="F" checked="checked">
				<font size="2">여자</font>
				</td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">직업</font></th>
				<td bgcolor="white" width="300">
				<select name="job" size="1">
						<option>학생</option>
						<option value="주부">주부</option>
						<option value="회사원">회사원</option>
						<option value="사장">사장</option>
						<option value="기타">기타</option>
				</select>
				</td>
			</tr>
			<tr>
				<th bgcolor="44ff44"><font size="2">취미</font></th>
				<td bgcolor="white" width="300">
				<input type="checkbox" name="hobby" checked="checked" value="낮잠">낮잠
				<input type="checkbox" name="hobby" value="연애">연애
				<input type="checkbox" name="hobby" value="운동">운동 
				<input type="checkbox" name="hobby" value="사이클">사이클 
				<input type="checkbox" name="hobby" value="기타">기타
				</td>
			</tr>
			<tr>
			<th colspan="2" bgcolor="ff8888">
				<input type="submit" value="가입">
				<input type="reset" value="취소"></th>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<%@include file="5-6.directive_included_file.jspf" %>
</body>
</html>
