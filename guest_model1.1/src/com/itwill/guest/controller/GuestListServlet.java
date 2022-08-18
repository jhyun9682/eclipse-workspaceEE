package com.itwill.guest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/**
 * Servlet implementation class GuestListServlet
 */
@WebServlet("/guest_list.do")
public class GuestListServlet extends HttpServlet {
	private GuestService guestService;
	public GuestListServlet() {
		guestService=new GuestService();
	}
	

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPath = "";
		try {
			
			/*
			 0.요청객체encoding설정
			 1.파라메타받기
			 2.GuestService객체생성
			 3.GuestService객체 selectAll() 메쏘드호출
			 4.ArrayList<Guest> 리스트얻기
			*/
			 List<Guest> guestList=guestService.selectAll();
			 request.setAttribute("guestList", guestList);
			 forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
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
