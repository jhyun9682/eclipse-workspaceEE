package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.summer.Controller;
import com.itwill.user.User;
import com.itwill.user.UserService;

public class UserViewController implements Controller{
	private UserService userService;
	public UserViewController() throws Exception{
		userService=new UserService();
	}
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String forwardPath="";
		/****************login_check*******************/
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		if(sUserId==null){
			forwardPath="redirect:user_main.do";
			return forwardPath;
		}
		/*********************************************/
		/*
		1. UserService객체생성
		2. 세션의 sUserId를 사용해서 UserService.findUser()메쏘드호출
		3. 반환된 User객체출력
		*/
		try {
			User loginUser=userService.findUser(sUserId);
			request.setAttribute("loginUser", loginUser);
			forwardPath="forward:/WEB-INF/views/user_view.jsp";
		}catch (Exception e) {
			e.printStackTrace();
			forwardPath="forward:/WEB-INF/views/user_error.jsp";
		}
		
		return forwardPath;
	}

}
