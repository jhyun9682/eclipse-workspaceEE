package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/search.do")
public class SearchServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		/*
		 * 클라이언트 요청URL
		 *   http:/localhost/servletSite/search.do?searchkeyword=java
		 */
		/*
		 * 1.요청객체를사용해서 요청시 전송되는 쿼리스트링에 있는 파라메타받기
		 *    - 파라메타이름은 input element의 name속성과일치
		 *       <input type="text" name="searchkeyword">
		 *    - search.do?searchkeyword=java   
		 */
		String searchkeyword = request.getParameter("searchkeyword");
		
		if(searchkeyword==null || searchkeyword.equals("")) {
			/*
			 * searchkeyword 가 null인경우 ==>http:/localhost/servletSite/search.do
			 * searchkeyword 가 ""  인경우 ==>http:/localhost/servletSite/search.do?searchkeyword=
			 */
			//검색어를 입력하지 않은 경우 재미있는 지식 결과를 랜덤하게 보여드립니다.
			out.println("검색어를 입력하지 않은 경우 <br>재미있는 지식 결과를 랜덤하게 보여드립니다.<hr>");
			out.println("<a href='05-00.search_form.html'>검색홈페이지</a>");
			return;
		}
		
		
		/*
		 * 2.검색업무 실행(DB에서검색)-->Service객체사용
		 */
		
		
		/*
		 * 3.클라이어트로 검색결과 전송(HTML)
		 */
		out.println("<h1>"+request.getRemoteAddr()+" 님 "+ searchkeyword+ "검색결과</h1><hr>");
		out.println("<ol>");
		int searchResultNo=(int)(Math.random()*10);
		for(int i=0;i<searchResultNo;i++) {
			out.println("<li>"+searchkeyword+" 검색결과</li>");
		}
		out.println("</ol>");
		out.println("<a href='05-00.search_form.html'>검색홈페이지</a>");
		return;
	}

}














