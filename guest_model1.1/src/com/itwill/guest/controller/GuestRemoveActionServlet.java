package com.itwill.guest.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestMainServlet
 */
@WebServlet("/guest_remove_action.do")
public class GuestRemoveActionServlet extends HttpServlet {
	private GuestService guestService;
	public GuestRemoveActionServlet() {
		guestService=new GuestService();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forwardPath="";
		
		
		/*
		GET방식이면 guest_main.do redirection
		
		0.요청객체encoding설정
		1.파라메타받기(guest_no)
		2.GuestService객체생성
		3.GuestService객체 deleteGuest(guest_no) 메쏘드호출
		4.guest_list.do로 redirection
		*/
		try {
			if(request.getMethod().equalsIgnoreCase("GET")){
				/*
				response.sendRedirect("guest_main.do");
				return;
				*/	
				forwardPath="redirect:guest_main.do";
			}else {
				String guest_noStr =request.getParameter("guest_no");
				int rowCount=guestService.deleteGuest(Integer.parseInt(guest_noStr));
				//response.sendRedirect("guest_list.do");
				forwardPath="redirect:guest_list.do";
			}
		}catch(Exception e) {
			e.printStackTrace();
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
