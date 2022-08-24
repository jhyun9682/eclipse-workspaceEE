<%@page import="com.itwill.shop.dto.User"%>
<%@page import="com.itwill.shop.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    String u_id = "test1";
    //로그인 정보 들어와야함
    UserService userService = new UserService();
    User user = userService.findUser(u_id);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="user_update_all_action.jsp">
		아이디	<input type="text" name="u_id" value=<%=user.getU_id() %>><br>
		패스워드<input type="hidden" name="u_password" value="1234"><br>
		<!-- 이거 히든으로 해야하나 아니면 필요한 정보인가? -->
		이름	<input type="text" name="u_name" value=<%=user.getU_name() %>><br>
		휴대번호<input type="text" name="u_phone" value=<%=user.getU_phone() %>><br>
		생년월일<input type="text" name="u_birth" value=<%=user.getU_birth() %>><br>
		성별	<input type="text" name="u_gender" value=<%=user.getU_gender() %>><br>
		주소	<input type="text" name="u_address" value=<%=user.getU_address() %>><br>
		<input type="submit">
</form>

</body>
</html>