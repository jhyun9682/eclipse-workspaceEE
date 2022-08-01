<%@page import="com.itwill.librarian.service.MemberService"%>
<%@page import="com.itwill.librarian.domain.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String sMemberNo = (String)session.getAttribute("sMemberNo");
%>	
	
<script type="text/javascript">
	function login_message() {
		alert('로그인하세요');
		location.href = 'memberLogin.jsp';
	}
</script>
<ul>
	<li>&nbsp;&nbsp;<strong>메 뉴</strong></li>
	<%
	if(sMemberNo == null){ 
	%>
	    <li>
	    	<a href="memberLogin.jsp">
	    		<img src='image/image__header-mypage.svg' align="bottom" width="18px" height="14px">
	    		&nbsp;로그인
	    	</a>
	    </li>
		<li><a href="memberJoin.jsp">회원가입</a></li>
	<%
	}else{ 
		Member sMember = new MemberService().getMember(Integer.parseInt(sMemberNo));
	%>	
		<li><a href="memberMyInfo.jsp">
				<img alt='aa' src='image/image__header-mypage.svg' align="bottom" width="18px" height="14px">
				&nbsp;<%= sMember.getMemberName() + "님" %>
			</a>
		</li>
		<li><a href="memberLogoutAction.jsp">로그아웃</a></li>
		<li><a href=""></a></li>
		<li><a href="loanList.jsp">대출 현황</a></li>
		<li><a href="loanReturnList.jsp">반납 현황</a></li>
		<li><a href="reservationList.jsp">예약 현황</a></li>
		<li><a href="favoriteList.jsp">관심도서</a></li>
		<li><a href="hopeBookList.jsp">희망도서</a></li>
		
	<%} %>
		<li><a href=""></a></li>
		<li><a href="bookList.jsp">도서 전체 목록</a></li>
		<li><a href="bookSearchForm.jsp">도서 검색</a></li>
		<li><a href=""></a></li>
		<li><a href="noticeList.jsp">공지사항</a></li>
		<li><a href="faqList.jsp">FAQ</a></li>
		<li><a href="qnaList.jsp">문의게시판</a></li>
</ul>
