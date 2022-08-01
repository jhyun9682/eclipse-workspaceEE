<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	/*
	0.요청객체 인코딩설정
	*/
	request.setCharacterEncoding("UTF-8");
	/*
	1.요청시전송되는 파라메타받기 
		- 파라메타의이름은 input element의 name속성과일치 
	  	아이디:<input type="text" name="id">
		패에쓰:<input type="password" name="pass">
	 */
	String id=request.getParameter("id");
	String pass=request.getParameter("pass");
	/*
	 * 2.업무실행(DB)
	 *  id |pass
	 *  ---------
	 *  xxx|1111
	 *  yyy|2222
	 */
	boolean isMember1=id.equals("xxx")&& pass.equals("1111");
	boolean isMember2=id.equals("yyy")&& pass.equals("2222");
	/*
	 * 3.클라이언트로 결과전송
	 */
	out.println("<h1>GET로그인결과</h1><hr/>");
	if(!(isMember1 || isMember2)){
		//로그인실패
		out.println("<h3>"+id+" 님 로그인 실패<h3>");
		out.println("<a href='4.login_get_form.jsp'>다시로그인</a>");
		return;
	}
	//로그인성공
	out.println("<h3>"+id+" 님 로그인성공</h3>");
	out.println("<a href=\"index.jsp\">메인으로</a>");
%>    















