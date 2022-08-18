package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestMainServlet
 */
@WebServlet("/guest_view.do")
public class GuestViewServlet extends HttpServlet {
	private GuestService guestService;
	public GuestViewServlet() {
		guestService=new GuestService();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 0.요청객체encoding설정
		 * 1.파라메타받기
		 * 2.GuestService객체생성
		 * 3.GuestService객체 selectByNo() 메쏘드호출
		 * 4.Guest 객체 얻기
		 */
		String forwardPath="";
		try {
			 String guest_noStr=request.getParameter("guest_no");
			 if(guest_noStr==null ||guest_noStr.equals("")){
				 /*
				 response.sendRedirect("guest_main.do");
				 return;
				 */
				 forwardPath="redirect:guest_main.do";
			 }else {
				 Guest guest=guestService.selectByNo(Integer.parseInt(guest_noStr));
				 request.setAttribute("guest", guest);
				 forwardPath="forward:/WEB-INF/views/guest_view.jsp";
			 }
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		
		/********************forward,redirect**************/
		/*
			forward --> forward:/WEB-INF/views/guest_xxx.jsp
			redirect--> redirect:guest_xxx.do
		 */
		String[] pathArray=forwardPath.split(":");
		String forwardOrRedirect = pathArray[0];
		String path=pathArray[1];
		if(forwardOrRedirect.equals("redirect")) {
			response.sendRedirect(path);
		}else if(forwardOrRedirect.equals("forward")){	
			RequestDispatcher rd=
					request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
		/*************************************************/
		
	}

}
