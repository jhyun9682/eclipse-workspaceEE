<%@page import="com.itwill.librarian.service.FavoriteService"%>
<%@page import="com.itwill.librarian.domain.Favorite"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="memberLoginCheck.jspf"%>
<%
/*
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("bookSearchResult.jsp");
	}
*/	
	
	try {
		FavoriteService favoriteService = new FavoriteService();
	
		//int memberNo = Integer.parseInt(request.getParameter("memberNo"));
		String bookNo = request.getParameter("bookNo");
	
		Favorite favorite = new Favorite(sMemberNo, bookNo);
	
		favoriteService.removeFavorite(favorite);
		response.sendRedirect("favoriteList.jsp");
	
	} catch (Exception e) {
		e.printStackTrace();
	}

%>