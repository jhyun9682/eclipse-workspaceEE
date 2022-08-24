<%@page import="com.itwill.librarian.service.BookService"%>
<%@page import="com.itwill.librarian.domain.HopeBook"%>
<%@page import="com.itwill.librarian.service.HopeBookService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="memberLoginCheck.jspf" %>    
<%
	if(request.getMethod().equalsIgnoreCase("GET")){
		response.sendRedirect("index.jsp");
		return;
	}

	try {
		String bookTitle = request.getParameter("bookTitle");
		String bookPublisher = request.getParameter("bookPublisher");
		String bookAuthor = request.getParameter("bookAuthor");
		
		HopeBookService hopeBookService = new HopeBookService();
		HopeBook newHopeBook = new HopeBook(Integer.parseInt(sMemberNo), bookTitle, bookPublisher, bookAuthor);
		
		int rowCount = hopeBookService.addHopeBook(newHopeBook);
		
		response.sendRedirect("hopeBookList.jsp");
	} catch(Exception e) {
		e.printStackTrace();
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	}	
%>