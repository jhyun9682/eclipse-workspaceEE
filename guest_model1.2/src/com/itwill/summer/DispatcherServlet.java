package com.itwill.summer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;

/*
 * 1. 클라이언트(웹브라우져)의 모든요청을 받는 서블릿작성(front Controller)
 * 2. 확장자가 *.do인 모든클라이언트의 요청이 서블릿을 실행하도록 web.xml에 url pattern mapping
   << web.xml >>
    <servlet>
		<servlet-name>dispatcher</servlet-name>
		<servlet-class>com.itwill.summer.DispatcherServlet</servlet-class>
	</servlet>
	<servlet-mapping>
		<servlet-name>dispatcher</servlet-name>
		<url-pattern>*.do</url-pattern>
	</servlet-mapping>
 */

public class DispatcherServlet extends HttpServlet {
	
	private GuestService guestService;
	
	public DispatcherServlet() {
		System.out.println("DispatcherServlet()생성자!!!");
		guestService=new GuestService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		/*****************************
		<<클라이언트 요청 url(command)>>
		/guest_main.do  		
		/guest_list.do			
		/guest_view.do			
		/guest_write_form.do	
		/guest_write_action.do	
		/guest_modify_form.do	
		/guest_modify_action.do	
		/guest_remove_action.do	
		 ***************************/
		
		/*
		 * 1.DispatcherServlet이 클라이언트 요청URI를 사용해서 요청분석
		 */
		String requestURI = request.getRequestURI();
		//System.out.println("requestURI:"+requestURI);
		String contextPath=request.getContextPath();
		//System.out.println("contextPath:"+contextPath);
		String command=requestURI.substring(contextPath.length());
		//System.out.println("command:"+command);
		
		/*
		 * 2.DispatcherServlet이 클라이언트 요청에따른 비지니스실행[Service객체사용]
		 *   (비지니스실행후 forwardPath에 이동할패쓰설정)
		 */
		String forwardPath="";
		if(command.equals("/guest_main.do")) {
			/******************guest_main.do********************/
			forwardPath="forward:/WEB-INF/views/guest_main.jsp";
			/***************************************************/
		}else if(command.equals("/guest_list.do")) {
			/******************guest_list.do********************/
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
			/***************************************************/
		}else if(command.equals("/guest_view.do")) {
			/******************guest_view.do********************/
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
			/***************************************************/
		}else if(command.equals("/guest_write_form.do")) {
			/*************guest_write_form.do*******************/
			forwardPath="forward:/WEB-INF/views/guest_write_form.jsp";
			/***************************************************/
		}else if(command.equals("/guest_write_action.do")) {
			/*************guest_write_action.do*****************/
			try {
				if(request.getMethod().equalsIgnoreCase("GET")){
					/*
					response.sendRedirect("guest_main.do");
					return;
					*/
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
					
					//response.sendRedirect("guest_list.do");
					forwardPath="redirect:guest_list.do";
					
				}
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
			/***************************************************/
		}else if(command.equals("/guest_modify_form.do")) {
			/***************guest_modify_form.do****************/
			try {
				if(request.getMethod().equalsIgnoreCase("GET")){
					/*
					response.sendRedirect("guest_main.do");
					return;
					*/
					forwardPath="redirect:guest_main.do";
				}else {
					String guest_noStr=request.getParameter("guest_no");
					
					Guest guest=
							guestService.selectByNo(Integer.parseInt(guest_noStr));
					request.setAttribute("guest", guest);
					forwardPath="forward:/WEB-INF/views/guest_modify_form.jsp";
				}
			}catch (Exception e) {
				e.printStackTrace();
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
			/***************************************************/
		}else if(command.equals("/guest_modify_action.do")) {
			/***************guest_modify_action.do**************/
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
			/***************************************************/
		}else if(command.equals("/guest_remove_action.do")) {
			/**************guest_remove_action.do***************/
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
				forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			}
			/***************************************************/
		}else {
			/********************* *.do ************************/
			forwardPath="forward:/WEB-INF/views/guest_error.jsp";
			/***************************************************/
		}
		
		/*
		 * 3.DispatcherServlet이 forwardPath데이타를가지고 forward 혹은 redirect를한다
		 */
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















