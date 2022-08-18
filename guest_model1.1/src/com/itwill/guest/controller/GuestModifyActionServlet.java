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
@WebServlet("/guest_modify_action.do")
public class GuestModifyActionServlet extends HttpServlet {
	private GuestService guestService;
	public GuestModifyActionServlet() {
		guestService=new GuestService();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forwardPath = "";

		/*
		GET방식이면 guest_main.do redirection
		
			0.요청객체encoding설정
			1.파라메타받기(guest_no,guest_name,guest_email,guest_homepage,guest_title,guest_content)
			 Guest객체생성
			2.GuestService객체생성
			3.GuestService객체 updateGuest(Guest객체) 메쏘드호출
			4.guest_view.do로 redirection
		*/
		try {
			if (request.getMethod().equalsIgnoreCase("GET")) {
				/*
				response.sendRedirect("guest_main.do");
				return;
				*/
				forwardPath="redirect:guest_main.do";
			}else {
				String guest_noStr = request.getParameter("guest_no");
				String guest_name = request.getParameter("guest_name");
				String guest_email = request.getParameter("guest_email");
				String guest_homepage = request.getParameter("guest_homepage");
				String guest_title = request.getParameter("guest_title");
				String guest_content = request.getParameter("guest_content");
				Guest guest = new Guest(Integer.parseInt(guest_noStr), guest_name, null, guest_email, guest_homepage,
						guest_title, guest_content);
				int rowCount = guestService.updateGuest(guest);
				//response.sendRedirect("guest_view.do?guest_no=" + guest_noStr);
				//forwardPath = String.format("redirect:guest_view.do?guest_no=%s", guest_noStr);
				forwardPath = "redirect:guest_view.do?guest_no="+guest_noStr;
			}
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		}
		/******************** forward,redirect **************/
		/*
			forward --> forward:/WEB-INF/views/guest_xxx.jsp
			redirect--> redirect:guest_xxx.do
		 */
		String[] pathArray = forwardPath.split(":");
		String forwardOrRedirect = pathArray[0];
		String path = pathArray[1];
		if (forwardOrRedirect.equals("redirect")) {
			response.sendRedirect(path);
		} else if (forwardOrRedirect.equals("forward")) {
			RequestDispatcher rd = request.getRequestDispatcher(path);
			rd.forward(request, response);
		}
		/*************************************************/

	}

}
