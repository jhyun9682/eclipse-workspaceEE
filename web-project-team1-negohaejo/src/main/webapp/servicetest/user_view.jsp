<%@page import="com.itwill.shop.dto.User"%>
<%@page import="com.itwill.shop.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String u_id = "test3";
    //로그인 정보 들어와야함
    UserService userService = new UserService();
    User loguser = userService.findUser(u_id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user_view.jsp</title>
</head>
<body>
<form action="user_write_action_test.jsp">
		아이디	<input type="text" name="u_id" value=<%=loguser.getU_id() %>><br>
		패스워드<input type="text" name="u_password" value=<%=loguser.getU_password() %>><br>
		이름	<input type="text" name="u_name" value=<%=loguser.getU_name() %>><br>
		휴대번호<input type="text" name="u_phone" value=<%=loguser.getU_phone() %>><br>
		생년월일<input type="text" name="u_birth" value=<%=loguser.getU_birth() %>><br>
		성별	<input type="text" name="u_gender" value=<%=loguser.getU_gender() %>><br>
		주소	<input type="text" name="u_address" value=<%=loguser.getU_address() %>><br>
		<input type="submit">
		
		

</form>
</body>
</html>