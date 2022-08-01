package com.itwill.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloTextServlet extends HttpServlet {
 	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/plain;charset=UTF-8");
 		PrintWriter out = response.getWriter();
		out.println("Hello text[dynamic resouce1] !!!");
		out.println("Hello text[dynamic resouce2] !!!");
		out.println("Hello text[dynamic resouce3] !!!");
		return;
	}

}
