<%@page import="com.itwill.shop.dto.Notice"%>
<%@page import="com.itwill.shop.service.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("get")){
		response.sendRedirect("notice_list.jsp");
		return;
	}
	
	Notice notice=new Notice();
	notice.setNoti_title(request.getParameter("title"));
	notice.setNoti_content(request.getParameter("content"));
	
	NoticeService noticeService = new NoticeService();
	noticeService.create(notice);
	response.sendRedirect("notice_list.jsp");
%> 