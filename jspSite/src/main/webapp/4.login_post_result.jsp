<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (request.getMethod().equalsIgnoreCase("GET")) {
		/*
		 * 클라이언트에서 GET방식의요청으로실행하면 
		 * 4.login_post_form.jsp 으로 redirect(방향재지정)
		 */
		response.sendRedirect("4.login_post_form.jsp");
		return;
	}
	
	/*
	0.요청객체 인코딩설정
	*/
	request.setCharacterEncoding("UTF-8");
	
	/*
	 1.요청시 전송되는 파라메타받기
	 	- 파라메타의 이름은 input element의 name속성과 일치
	 		아이디:<input type="text" name="id"><br>
			패에쓰:<input type="password" name="pass"><br><br>
	 
	 */
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	
	/*
	 * 2.로그인 업무실행(Service객체사용)
	 *  id |pass
	 *  ---------
	 *  xxx|1111
	 *  yyy|2222
	 */
	
	/*
	 * 3.클라이언트로 결과전송
	 */
	boolean isMember1 = id.equals("xxx") && pass.equals("1111");
	boolean isMember2 = id.equals("yyy") && pass.equals("2222");
	out.println("<h1>POST 로그인결과</h1><hr>");
	if (isMember1 || isMember2) {
		//로그인성공
		out.println("<h3>" + id + " 님 로그인성공</h3><hr>");
		out.println("<a href='index.jsp'>메인으로</a>");
	} else {
		//로그인실패
		out.println("<h3>" + id + " 님 로그인실패</h3><hr>");
		out.println("<a href='4.login_post_form.jsp'>다시로그인</a>");
	}
%>
