$(function() {
	
	$(".login_form").submit(function() {
		var login_id = $("#login_id");
		var login_pw = $("#login_pw");
		var result = false;

		if (login_id.val() == "") {
			alert("아이디를 입력해주세요");
		} else if (login_pw.val() == "") {
			alert("비밀번호를 입력해주세요");
		} else {
			result = true;
		}
		return result;
	})

	$("#delete_btn").click(function() {
		var conf = confirm("정말 삭제 하시겠습니까?");
		var result = false;

		if (conf) {
			location.href = "member?command=delete";
		} else {
			return result;
		}
	});

	$("#frm").on("submit", function() {
		var title = $("#title");
		var result = false;

		if (title.val() == "") {
			alert("제목을 입력해주세요");
		} else {
			result = true;
		}

		return result;
	});

});

function board_delete(e) {
	var conf = confirm("정말 삭제 하시겠습니까?");
	var result = false;

	if (conf) {
		location.href = "board?command=delete&board_idx=" + e;
	} else {
		return result;
	}
}
