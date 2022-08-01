<%@page import="com.itwill.librarian.service.MemberService"%>
<%@page import="com.itwill.librarian.domain.Book"%>
<%@page import="com.itwill.librarian.service.BookService"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="com.itwill.librarian.service.ReservationService"%>
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
	//memberNo가 int니까 변환
	try{
		ReservationService reservationService = new ReservationService();
		BookService bookService = new BookService();
		MemberService memberService = new MemberService();
		//int memberNo = Integer.parseInt(request.getParameter("MEMBER_NO"));
		String bookNo = request.getParameter("bookNo");
		Book reservBook = bookService.getBookByNo(bookNo);
		Member member = memberService.getMember(Integer.parseInt(sMemberNo));
	
		if (reservBook.getBookReservation() >= reservBook.getBookHoldings()) {
			out.println("<script>");
			out.println("alert('" + reservBook.getBookTitle() + " 도서가 모두 예약되었습니다. 다른 회원이 반납해야 이용할 수 있습니다.');");
			out.println("history.go(-1);");
			out.println("</script>");
			return;
		}
		
		if (member.getMemberReservation() >= Member.MAX_RESERVE_CNT) {
			out.println("<script>");
			out.println("alert('예약 가능 도서 수는 총 " + Member.MAX_RESERVE_CNT + "권 입니다. 예약 중인 도서를 취소 후 이용해주시기 바랍니다.');");
			out.println("location.href='reservationList.jsp';");
			out.println("</script>");
			return;
		}
		
		//Reservation reservation = new Reservation(sMemberNo, bookNo, new SimpleDateFormat("yyyy-MM-dd").parse("2021-09-01"));
		Reservation rv = new Reservation(sMemberNo, bookNo);
		
		//reservationService.addReservation(reservation);
		int rowCount = reservationService.addReservation(rv);
		
		if(rowCount == 1) {
			out.println("<script>");
			out.println("alert('" + reservBook.getBookTitle() + " 도서를 예약 했습니다');");
			out.println("location.href='reservationList.jsp';");
			out.println("</script>");
			return;
		} else {
			out.println("<script>");
			out.println("alert('이미 예약한 도서 입니다');");
			out.println("history.back();");
			out.println("</script>");
			return;
		}
		
		
	} catch(Exception e){
		e.printStackTrace();
	}
%>