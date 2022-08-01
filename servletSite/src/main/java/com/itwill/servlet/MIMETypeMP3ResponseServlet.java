package com.itwill.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/response_mp3.do")
public class MIMETypeMP3ResponseServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1.응답객체MIME타입설정  
		 */
		response.setContentType("audio/mpeg");
		/*
		 * 2.부라우져와연결된 출력스트림생성
		 */
		OutputStream out=response.getOutputStream();
		/*
		 * servletSite context 의 실제경로
		 */
		ServletContext servletContext=this.getServletContext();
		String fileRealPath=servletContext.getRealPath("images/test.mp3");
		FileInputStream fis=new FileInputStream(fileRealPath);
		while(true) {
			int readByte=fis.read();
			if(readByte==-1)break;
			out.write(readByte);
		}
		fis.close();
		out.close();
	}

}
