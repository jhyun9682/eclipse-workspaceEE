<%@page import="com.itwill.shop.dto.Notice"%>
<%@page import="com.itwill.shop.service.NoticeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getMethod().equalsIgnoreCase("get")){
		response.sendRedirect("notice_list.jsp");
		return;
	}
	NoticeService noticeService = new NoticeService();
	Notice notice = new Notice(
			Integer.parseInt(request.getParameter("notino")),
			request.getParameter("title"),
			request.getParameter("content"),
			null,
			request.getParameter("noti_file")); 
	noticeService.update(notice);
	String pageno="1";
	if(request.getParameter("pageno")!=null){
		pageno=request.getParameter("pageno");
	}
	response.sendRedirect(
		String.format("notice_view.jsp?notino=%d&pageno=%s",notice.getNoti_no(),pageno));
	
	
%> 