<%@page import="com.itwill.librarian.service.MemberService"%>
<%@page import="com.itwill.librarian.domain.Book"%>
<%@page import="com.itwill.librarian.service.BookService"%>
<%@page import="com.itwill.librarian.service.LoanService"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="memberLoginCheck.jspf" %>
<%
	String bookNo = request.getParameter("bookNo");
	String pageNo = request.getParameter("pageNo");
	if (pageNo == null || pageNo.equals("")) {
		pageNo = "1";
	}
	
	try{
		LoanService loanService = new LoanService();
		BookService bookService = new BookService();
		MemberService memberService = new MemberService();
		Member member = memberService.getMember(Integer.parseInt(sMemberNo));
		Book loanBook = bookService.getBookByNo(bookNo);
		
		if (loanBook.getBookLoan() >= loanBook.getBookHoldings()) {
			out.println("<script>");
			out.println("alert('" + loanBook.getBookTitle() + " 도서가 모두 대출되었습니다. 예약 서비스를 이용해주세요.');");
			out.println("history.go(-1);");
			out.println("</script>");
			return;
		}
		
		if (member.getMemberLoan() >= Member.MAX_LOAN_CNT) {
			out.println("<script>");
			out.println("alert('대출 가능 도서 수는 총 " + Member.MAX_LOAN_CNT + "권 입니다. 대출 중인 도서를 반납 후 이용해주시기 바랍니다.');");
			out.println("location.href='loanList.jsp';");
			out.println("</script>");
			return;
		}
		
		int rowCount = loanService.addLoan(Integer.parseInt(sMemberNo), bookNo);
		
		if(rowCount == 1) {
			out.println("<script>");
			out.println("alert('" + loanBook.getBookTitle() + " 도서를 대출 했습니다');");
			out.println("location.href='loanList.jsp';");
			out.println("</script>");
			return;
		} else {
			out.println("<script>");
			out.println("alert('이미 대여한 도서 입니다');");
			out.println("history.back();");
			out.println("</script>");
			return;
		}
	} catch(Exception e) {
		e.printStackTrace();
		response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);	
	}
%>















