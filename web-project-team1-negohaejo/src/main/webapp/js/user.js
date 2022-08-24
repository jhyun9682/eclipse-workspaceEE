function userModify() {
		document.f.action = "user_update_all_form.jsp";
		document.f.method = "POST";
		document.f.submit();
	}
function userModifyPassword() {
	if (document.f.u_password.value != f.u_password2.value){
		alert("새로운 비밀번호와 새로운 비밀번호 확인이 일치하지 않습니다.");
		f.u_password.focus();
		f.u_password.select();
		return false;
		}
		
		document.f.action = "user_modify_password_action.jsp";
		document.f.method = "POST";
		document.f.submit();
	}
	
function userModifyAll() {
	if (document.f.u_phone.value == "") {
		alert("휴대전화를 입력하십시오.");
		document.f.u_phone.focus();
		return false;
	}

	if (document.f.u_birth.value == "") {
		alert("생일을 입력하십시오.");
		document.f.u_birth.focus();
		return false;
	}
	if (document.f.u_address.value == "") {
		alert("주소를 입력하십시오.");
		document.f.u_address.focus();
		return false;
	}
		document.f.action = "user_update_all_action.jsp";
		document.f.method = "POST";
		document.f.submit();
	}
function userRemove() {
		if (confirm("정말 탈퇴하시겠습니까?")) {
			document.f.action = "user_remove_action.jsp";
			document.f.method='POST';
			document.f.submit();
		}
	}

function userCreate() {
	if (document.f.u_id.value == "") {
		alert("사용자 아이디를 입력하십시오.");
		document.f.u_id.focus();
		return false;
	}
	if (document.f.u_password.value == "") {
		alert("비밀번호를 입력하십시오.");
		document.f.u_password.focus();
		return false;
	}
	if (document.f.u_password2.value == "") {
		alert("비밀번호확인을 입력하십시오");
		document.f.u_password2.focus();
		return false;
	}
	if (document.f.u_password.value != f.u_password2.value){
		alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
		f.u_password.focus();
		f.u_password.select();
		return false;
		}
	if (document.f.u_name.value == "") {
		alert("이름을 입력하십시오.");
		document.f.u_name.focus();
		return false;
	}
	if (document.f.u_phone.value == "") {
		alert("휴대전화를 입력하십시오.");
		document.f.u_phone.focus();
		return false;
	}

	if (document.f.u_birth.value == "") {
		alert("생일을 입력하십시오.");
		document.f.u_birth.focus();
		return false;
	}
	if (document.f.u_address.value == "") {
		alert("주소를 입력하십시오.");
		document.f.u_address.focus();
		return false;
	}
	
	document.f.action = "user_write_action.jsp";
	document.f.method = 'POST';
	document.f.submit();
}
