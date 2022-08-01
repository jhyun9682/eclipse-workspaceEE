package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetLoginServlet
 */
@WebServlet("/post_login.do")
public class PostLoginServlet extends HttpServlet {
	/*
	 * client GET방식요청에의해 실행되는 메쏘드
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 클라이언트에서 GET방식의요청으로실행하면 
		 * 05-02.login_post.html으로 redirect(방향재지정)
		 */
		response.sendRedirect("05-02.login_post.html");
		//response.sendError(403);
	}
	/*
	 * client POST방식요청에의해 실행되는 메쏘드
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		/*
		 1.요청시 전송되는 파라메타받기
		 	- 파라메타의 이름은 input element의 name속성과 일치
		 		아이디:<input type="text" name="id"><br>
				패에쓰:<input type="password" name="pass"><br><br>
		 
		 */
		String id=request.getParameter("id");
		String pass=request.getParameter("pass");
		if( id==null||id.equals("")|| pass==null || pass.equals("")) {
			response.sendRedirect("05-02.login_post.html");
			return;
		}
		
		/*
		 * 2.로그인 업무실행(Service객체사용)
		 *  id |pass
		 *  -------
		 *  xxx|1111
		 *  yyy|2222
		 * 
		 */
		boolean isMember1 = id.equals("xxx")&& pass.equals("1111");
		boolean isMember2 = id.equals("yyy")&& pass.equals("2222");
		out.println("<h1>POST 로그인결과</h1><hr>");
		if(isMember1 || isMember2) {
			//로그인성공
			out.println("<h3>"+id+" 님 로그인성공</h3><hr>");
			out.println("<a href='index.html'>메인으로</a>");
		}else {
			//로그인실패
			out.println("<h3>"+id+" 님 로그인실패</h3><hr>");
			out.println("<a href='05-02.login_post.html'>다시로그인</a>");
		}
		
	}

}

















