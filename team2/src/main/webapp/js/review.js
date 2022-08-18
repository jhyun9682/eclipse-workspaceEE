/**
 * 
 */
function reviewList(){
	location.href='review_Id_list.jsp';
}

function mainGo(){
	location.href='kyobo_main.jsp';
}

function reviewCreateGo(){
	location.href='review_insert_form.jsp';
}

function reviewReplyCreate(){
	location.href='review_reply_insert_form.jsp';
}

function reviewCreate() { 
		if (f.r_title.value == "") {
			alert("제목을 입력하십시요.");
			f.r_title.focus();
			return false;
		}
		if (f.u_id.value == "") {
			alert("아이디를 입력하십시요.");
			f.u_id.focus();
			return false;
		}
		if (f.r_contents.value == "") {
			alert("내용을 입력하십시요.");
			f.r_contents.focus();
			return false;
		}
		if (f.r_grade.value == "") {
			alert("평점을 입력하십시요.");
			f.r_grade.focus();
			return false;
		}

		document.f.action ="review_insert_action.jsp";
		document.f.method="POST";
		document.f.submit();
	}
	
function reviewReplyCreate() {
		if (f.title.value == "") {
			alert("제목을 입력하십시요.");
			f.title.focus();
			return false;
		}
		if (f.writer.value == "") {
			alert("작성자를 입력하십시요.");
			f.writer.focus();
			return false;
		}
		if (f.content.value == "") {
			alert("내용을 입력하십시요.");
			f.content.focus();
			return false;
		}
		f.action = "review_reply_insert_action.jsp";
		f.method='POST';
		f.submit();
	}

	function boardList() {
		f.action = "board_list.jsp";
		f.submit();
	}









