package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwill.summer.Controller;

public class UserLogoutActionController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		/****************login_check*******************/
		
		/*********************************************/
		request.getSession().invalidate();
		forwardPath="redirect:user_main.do";
		return forwardPath;
	}

}
