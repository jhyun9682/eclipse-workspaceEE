<%@page import="java.io.File"%>
<%@page import="com.itwill.librarian.domain.Reply"%>
<%@page import="com.itwill.librarian.service.MemberService"%>
<%@page import="com.itwill.librarian.service.QnaService"%>
<%@page import="com.itwill.librarian.domain.Qna"%>
<%@ include file="qnaLoginIdCheck.jspf"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Integer qnano = null;
	int pageno = 1;
	
	try {
		qnano = Integer.parseInt(request.getParameter("qnano"));
		pageno = Integer.parseInt(request.getParameter("pageno"));
	}catch(Exception e){
		
	}
	
	if (qnano == null){
		//목록으로 이동
		response.sendRedirect("qnaList.jsp?pageno="+pageno);
		return;
	}
	
	QnaService qnaService = new QnaService();
	Qna qna = qnaService.getQnaByNo(qnano);
	
	//비공개 설정
	if(qna.getQnaVisible()==0){
		if(sMember!=null){
			if(sMember.getMemberNo() == qna.getMemberNo() || sMember.getMemberNo() == 1){
				
			}else{
				out.println("<script>");
				out.println("alert('비공개 글입니다.');");
				out.println("location.href='qnaList.jsp?pageno="+pageno+"';");
				out.println("</script>");
				return;
			}
		}else{
			out.println("<script>");
			out.println("alert('비공개 글입니다.');");
			out.println("location.href='qnaList.jsp?pageno="+pageno+"';");
			out.println("</script>");
			return;
		}
	}
	//조회수 증가
	qnaService.updateHitCount(qnano);
	
	//멤버 객체
	MemberService memberService = new MemberService();

	//파일 다운로드
	
%>    
    
    
<!DOCTYPE html>
<html>
<head>
<title>게시판</title>
<meta http-equiv="Content-Type" content="text/html; charset=euc-kr">
<link rel=stylesheet href="css/styles.css" type="text/css">
<link rel=stylesheet href="css/shop.css" type="text/css">
<link rel=stylesheet href="css/cart.css" type="text/css">
<script language="JavaScript">
	function qnaUpdate() {
		f.action = "qnaModify.jsp";
		f.submit();
	}
	
	function qnaRemove() {
		if (confirm("정말 삭제하시겠습니까?")) {
			f.action = "qnaRemoveAction.jsp";
			f.submit();
		}
	}
	
	function qnaList() {
		f.action = "qnaList.jsp?pageno=" +<%=pageno%>;
		f.submit();
	}
	
	function updateReply(f){
		if(confirm("수정하시겠습니까?")){
			var replyeditform=document.getElementById(f);
			replyeditform.submit();
		}
	}
	
	function writeReply(){
		var replyform=document.getElementById('replyform');
		replyform.submit();
	}
	
	function toggleReplyStatus(replyNo, edit) {
		document.getElementById("replyview" + replyNo).style.display = 
		edit ? 'none' : 'block';
		document.getElementById("replyedit" + replyNo).style.display = 
		edit ? 'block' : 'none';
	}
	
	function deleteReply(replyNo, qnaNo, pageNo) {
		var result = confirm("댓글을 삭제하시겠습니까?");
		if (result) {
			location.href='qnaReplyRemoveAction.jsp?' +
				'replyNo=' + replyNo + 
				'&qnaNo=' + qnaNo + '&pageNo=' + pageNo;
		}
	}
	
</script>
</head>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0
	marginwidth=0 marginheight=0>
	<form id="xxx">
		<input type="hidden" name="a"> <input type="hidden" name="b">
	</form>
	<!-- container start-->
	<div id="container">
		<!-- header start -->
		<div id="header">
			<!-- include_common_top.jsp start-->
			<jsp:include page="includeCommonTop.jsp" />
			<!-- include_common_top.jsp end-->
		</div>
		<!-- header end -->
		<!-- navigation start-->
		<div id="navigation">
			<!-- include_common_left.jsp start-->
			<jsp:include page="includeCommonLeft.jsp" />
			<!-- include_common_left.jsp end-->
		</div>
		<!-- navigation end-->
		<!-- wrapper start -->
		<div id="wrapper">
			<!-- content start -->
			<!-- include_content.jsp start-->
			<div id="content">
				<table border=0 cellpadding=0 cellspacing=0>
					<tr>
						<td><br />
							<table style="padding-left: 10px" border=0 cellpadding=0
								cellspacing=0>
								<tr>
									<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp; <b> 게시물
											내용보기 </b>
									</td>
								</tr>
							</table> <!-- view Form  -->
							<form name="f" method="post">
								<input type="hidden" name="qnano" value="<%=qna.getQnaNo()%>"> 
								<input type="hidden" name="memberno" value="<%=qna.getMemberNo()%>"> 
								<input type="hidden" name="pageno" value="<%=pageno%>">
								<input type="hidden" name="fileone" value="<%=qna.getQnaFile()%>">
								<table border="0" cellpadding="0" cellspacing="1" width="590px"
									bgcolor="BBBBBB">
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">작성자</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left">
											<%=memberService.getMember(qna.getMemberNo()).getMemberName().toString().substring(0, 1)%>**</td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">제목</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><%=qna.getQnaTitle()%></td>
									</tr>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">작성일자</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><%=qna.getQnaRegDate().toString().substring(0, 10)%></td>
									</tr>
									<%if(qna.getQnaFile() != null){ %>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">첨부파일</td>
										<td width=490 bgcolor="ffffff" style="padding-left: 10px"
											align="left"><img src="image/fileimg.png" width = "15"><%
											String directory = application.getRealPath("/upload/"+qna.getMemberNo()+"/");
											File targetDir = new File(directory);
											if(!targetDir.exists()){
												targetDir.mkdirs();
													}
													
											String files[] = new File(directory).list();	
														
											for(String file : files){
															
											out.write("<a href=\"" + request.getContextPath() + "/qnaDownloadAction?memberno="+qna.getMemberNo()+"&file="+
												java.net.URLEncoder.encode(file,"UTF-8") + "\">" + file + "</a><br>");
													}
											%></td>
											
									</tr>
									<%} %>
									<tr>
										<td width=100 align=center bgcolor="E6ECDE" height="22">내용</td>
										<td width=490 bgcolor="ffffff" height="180px"
											style="padding-left: 10px" align="left"><%=qna.getQnaContent().replace("\n", "<br/>")%><br />

										</td>
									</tr>
								</table>

							</form> 
							<table border=0 cellpadding=0 cellspacing=0>
								<tr>
									<td align=right>
									<%if(sMember!=null && ((sMember.getMemberNo() == qna.getMemberNo()) || sMember.getMemberNo() == 1)) { %>
									<input type="button" value="수정" onClick="qnaUpdate()"> &nbsp; 
									<input type="button" value="삭제" onClick="qnaRemove()"> &nbsp; 
									<%}%>
									<input type="button" value="목록" onClick="qnaList()"></td>
								</tr>
							</table>
							<br>
							<form id="replyform" action="qnaReplyWriteAction.jsp" method="post">
								<input type="hidden" name="qnano" value="<%=qna.getQnaNo()%>" />
								<input type="hidden" name="memberno" value="<%=qna.getMemberNo()%>">  
								<input type="hidden" name="pageno" value="<%=pageno%>" />
								<table border="0" cellpadding="0" cellspacing="1">
									<tr>
										<td bgcolor="ffffff" align="left"> 
										<textarea name="content" rows="1" style="width: 460px"></textarea> &nbsp; 
										</td>
										<td bgcolor="ffffff" width="30px">
										<input type="button" value="댓글등록" onClick="writeReply();">
										</td>
									</tr>
								</table>
							</form>							
							<%
							 if (qna.getReplys().size() == 0) {
							 %>
														<div id="nodata" style="text-align: center">
															<b>작성된 댓글이 없습니다.</b>
														</div> <%
							 } else {
							 %>
							<table style="padding-left: 10px; width: 550px" background="gray"
								border="0" cellpadding="0" cellspacing="1">
								<%
								for (Reply reply : qna.getReplys()) {
								%>
								<tr>
									<td bgcolor="ffffff">
										<div
											style="border: 1px solid gray; background-color: lightgray; padding: 0px; margin: 1px"
											id="replyview<%=reply.getReplyNo()%>">
											<table>
												<tr>
													<td style="border: 1px solid; width: 75px;font-size:1pt;padding:3px">
													<img style="vertical-align:middle" width="30px" height="30px" src='image/bookimg.png'>
													<p style="display: inline;margin: 0px;padding: 0px, text-aglin:center">
													<%if(reply.getMemberNo() == 1){ %>
													<%=memberService.getMember(reply.getMemberNo()).getMemberName()%>
													<%}else {%>
													<%=memberService.getMember(reply.getMemberNo()).getMemberName().toString().substring(0, 1)%>**
													<%} %>
													</p></td> 		
													<td style="width: 400px; padding-left: 5px; margin: 0px;font-size:2pt;"><%=reply.getReplyContent().replace("\r\n", "<br />")%>
													</td>
													<%if(sMember!=null && ((sMember.getMemberNo() == reply.getMemberNo()) || sMember.getMemberNo() == 1)) { %>
													<td style="width: 40px">
														<input type="button" value="편집" onclick="toggleReplyStatus(<%=reply.getReplyNo()%>, true);" />
														<input type="button" value="삭제" onclick="deleteReply(<%=reply.getReplyNo()%>,<%=qna.getQnaNo()%>,<%=pageno%>)" /></td>
													<%} else {%>
													<td style="width: 40px">
													<%} %>
													
												</tr>
											</table>
										</div>

										<div id='replyedit<%=reply.getReplyNo()%>'
											style="border: 1px solid gray; background-color: #dfdfdf; padding: 0px; margin: 0px; display: none">
											<table>
												<tr>
													
													<%-- <td style="border: 1px solid; width: 50px;font-size:1pt;padding:3px""><%=bcomment.getWriter()%><br />
														<%=bcomment.getRegDate()%></td>
													 --%>
													<td style="border: 1px solid; width: 75px;font-size:1pt;padding:3px">
													<img style="vertical-align:middle" width="30px" height="30px" src='image/bookimg.png'>
													<p style="display: inline;margin: 0px;padding: 0px, text-aglin:center"><%=memberService.getMember(reply.getMemberNo()).getMemberName().toString().substring(0, 1)%>**</p></td> 			
													<td style="width: 400px; adding-left: 5px; margin: 0px;font-size:2pt;">
														<form id="replyeditform<%=reply.getReplyNo()%>"
															action="qnaReplyModifyAction.jsp" method="post"
															style="width: 400px; padding: 0px; margin: 0px">
															<input type="hidden" name="qnano" value="<%=qna.getQnaNo()%>" /> 
															<input type="hidden" name="memberno" value="<%=qna.getMemberNo()%>" /> 
															<input type="hidden" name="pageno" value="<%=pageno%>" /> 
															<input type="hidden" name="replyno" value="<%=reply.getReplyNo()%>" />
															<textarea name="content" rows="2" style="width: 400px; padding: 0px; margin: 0px;font-size:1pt;"><%=reply.getReplyContent()%></textarea>
														</form>
													</td>
													<td style="width: 40px">
														<input type="button" value="수정" onclick="updateReply('replyeditform<%=reply.getReplyNo()%>');" /><br /> 
														<input type="button" value="취소" onclick="toggleReplyStatus(<%=reply.getReplyNo()%>, false);" /></td>
												</tr>
											</table>

										</div>
									</td>
								</tr>
								<%
								}
								%>
							</table> <!-- ------------ --> 
							<%
							 }
							%>
							
						</td>
					</tr>
				</table>
			</div>
			<!-- include_content.jsp end-->
			<!-- content end -->
		</div>
		<!--wrapper end-->
		<div id="footer">
			<!-- include_common_bottom.jsp start-->
			<jsp:include page="includeCommonBottom.jsp" />
			<!-- include_common_bottom.jsp end-->
		</div>
	</div>
	<!--container end-->
</body>
</html>