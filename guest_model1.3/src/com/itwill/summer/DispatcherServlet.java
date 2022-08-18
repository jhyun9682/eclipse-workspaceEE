package com.itwill.summer;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itwill.guest.GuestService;
import com.itwill.guest.controller.GuestErrorController;
import com.itwill.guest.controller.GuestListController;
import com.itwill.guest.controller.GuestMainController;
import com.itwill.guest.controller.GuestModifyActionController;
import com.itwill.guest.controller.GuestModifyFormController;
import com.itwill.guest.controller.GuestRemoveActionController;
import com.itwill.guest.controller.GuestViewController;
import com.itwill.guest.controller.GuestWriteActionController;
import com.itwill.guest.controller.GuestWriteFormController;
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
		String contextPath=request.getContextPath();
		String command=requestURI.substring(contextPath.length());
		/*
		 * 2-1.DispatcherServlet이 클라이언트 요청에따른 업무실행할 Controller객체생성
		 */
		String forwardPath="";
		Controller controller=null;
		
		if(command.equals("/guest_main.do")) {
			/*******guest_main.do 를처리하는 Controller객체생성*************/
			controller=new GuestMainController();
		}else if(command.equals("/guest_list.do")) {
			/*******guest_list.do 를처리하는 Controller객체생성*************/
			controller=new GuestListController();
		}else if(command.equals("/guest_view.do")) {
			/*******guest_view.do 를처리하는 Controller객체생성*************/
			controller=new GuestViewController();
		}else if(command.equals("/guest_write_form.do")) {
			/******guest_write_form.do 를처리하는 Controller객체생성********/
			controller=new GuestWriteFormController();
			/***************************************************/
		}else if(command.equals("/guest_write_action.do")) {
			/******guest_write_action.do 를처리하는 Controller객체생성*******/
			controller=new GuestWriteActionController();
		}else if(command.equals("/guest_modify_form.do")) {
			/*****guest_modify_form.do 를처리하는 Controller객체생성*********/
			controller=new GuestModifyFormController();
		}else if(command.equals("/guest_modify_action.do")) {
			/*****guest_modify_action.do 를처리하는 Controller객체생성*******/
			controller=new GuestModifyActionController();
		}else if(command.equals("/guest_remove_action.do")) {
			/*****guest_remove_action.do 를처리하는 Controller객체생성*******/
			controller=new GuestRemoveActionController();
		}else {
			/***** *.do 를처리하는 Controller객체생성************************/
			controller=new GuestErrorController();
		}
		/*
		  2-2.DispatcherServlet이 Controller객체의 handlerRequest메쏘드호출(비지니스실행)
		  2-3.DispatcherServlet이 Controller객체의 handlerRequest메쏘드반환값인 forwardPath를 받는다.
		 */
		 forwardPath=controller.handleRequest(request, response);
		/*
		 * 3.DispatcherServlet이 forwardPath데이타를가지고 forward 혹은 redirect를한다
		 */
		/********************forward,redirect**************/
		/*
			forward --> forward:/WEB-INF/views/guest_xxx.jsp
			redirect--> redirect:guest_xxx.do
		 */
		String[] pathArray=forwardPath.split(":");
		/*
		  << pathArray >>
		  |----0---|-----------------1------------|
		  |forward |/WEB-INF/views/guest_main.jsp |
		  |--------|------------------------------|
		  
		  |----0---|-------1-----|
		  |redirect|guest_main.do|
		  |--------|-------------|
		 */
		
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