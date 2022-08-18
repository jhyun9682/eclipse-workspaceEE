package com.itwill.guest.controller;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
import com.itwill.summer.Controller;

public class GuestListController implements Controller {
	private GuestService guestService;
	public GuestListController() {
		guestService=new GuestService();
	}
	
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
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
		return forwardPath;
	}
}
