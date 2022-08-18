package com.itwill.guest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestWriteActionController implements Controller {
	private GuestService guestService;
	public GuestWriteActionController() {
		guestService=new GuestService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		try {
			if(request.getMethod().equalsIgnoreCase("GET")){
				forwardPath="redirect:guest_main.do";
			}else {
				Guest guest=new Guest(0,
									  request.getParameter("guest_name"),
									  null,
									  request.getParameter("guest_email"),
									  request.getParameter("guest_homepage"),
									  request.getParameter("guest_title"),
									  request.getParameter("guest_content")
									  );
				int rowCount=guestService.insertGuest(guest);
				forwardPath="redirect:guest_list.do";
			}
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
		}
		return forwardPath;
	}

}
