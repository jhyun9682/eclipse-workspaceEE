<%@page import="com.itwill.librarian.service.ReservationService"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.itwill.librarian.domain.Reservation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="memberLoginCheck.jspf"%>
<%
/*
if(request.getMethod().equalsIgnoreCase("GET")){
	response.sendRedirect("bookSearchResult.jsp");
	return;
}	
*/	

try{
	ReservationService reservationService = new ReservationService();
	
	
	String bookNo = request.getParameter("bookNo");

	
	Reservation rv = new Reservation(sMemberNo, bookNo);
	

	reservationService.removeReservation(rv);
	response.sendRedirect("reservationList.jsp");
	
} catch(Exception e){
	e.printStackTrace();
}

%>