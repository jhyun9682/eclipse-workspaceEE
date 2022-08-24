
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>user_write_test.jsp</h1>
<form action="user_write_action.jsp">
		아이디	<input type="text" name="u_id" value="test1"><br>
		패스워드<input type="text" name="u_password" value="1234"><br>
		이름	<input type="text" name="u_name" value="김테스트"><br>
		휴대번호<input type="text" name="u_phone" value="777-8888"><br>
		생년월일<input type="text" name="u_birth" value="2020/10/10"><br>
		성별	<input type="text" name="u_gender" value="F"><br>
		주소	<input type="text" name="u_address" value="서울시 특별시"><br>
		<input type="submit">
		
		

</form>

</body>
</html>