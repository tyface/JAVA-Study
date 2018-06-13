<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function() {
		var chkId = false, chkPw = false, chkPwDup = false, chkEmail = false;
		//비밀번호 유효성 검사
		$("#user_pw")
				.blur(
						function() {
							var pattern = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$/;
							var pw = $(this).val();

							if (pattern.test(pw)) {
								chkPw = true;
								$("#pw_result").text("사용가능");
							} else {
								chkPw = false;
								$("#pw_result").text(
										"영문,특수문자,숫자 혼합 8~20글자만 가능합니다.");
							}
						});//end 비밀번호 검사

		//비밀번호 확인
		$("#password_dup").blur(function() {
			var pw = $("#user_pw").val();
			var pwDup = $(this).val();

			if (pw == pwDup) {
				chkPwDup = true;
				$("#pwdup_result").text("사용가능");
			} else {
				chkPwDup = false;
				$("#pwdup_result").text("비밀번호가 일치하지 않습니다.");
			}
		});//end 비밀번호 확인

		//아이디 중복검사
		$("#user_id").blur(function() {
			var pattern = /^[A-Za-z0-9_]{4,20}$/;
			var id = $(this).val();

			if (pattern.test(id)) {
				$.ajax({
					url : "member?command=check-id",
					type : "post",
					data : {
						"user_id" : id
					},
					dataType : "text",
					success : function(result) {
						if (result == "true") {
							$("#id_result").text("사용가능");
							chkId = true;
						} else {
							chkId = false;
							$("#id_result").text("사용불가능");
						}
					},
					error : function(request, status, error, result) {
						alert("request: " + request);
						alert("status: " + status);
						alert("error: " + error);
						alert("erresultror: " + result);
					}

				});
			} else {
				$("#id_result").text("영문,숫자 4~20글자만 사용가능 합니다.");
			}

		});//end 아이디 중복검사

		//이메일 중복검사
		$("#email").blur(function() {
			var email = $(this).val();
			$.ajax({
				url : "member?command=check-email",
				type : "post",
				data : {
					"email" : email
				},
				dataType : "text",
				success : function(result) {
					if (result == "true") {
						chkEmail = false;
						$("#email_result").text("사용불가능");
					} else {
						chkEmail = true;
						$("#email_result").text("사용가능");
					}
				},
				error : function(request, status, error, result) {
					alert("request: " + request);
					alert("status: " + status);
					alert("error: " + error);
					alert("erresultror: " + result);
				}

			});
		});//end 이메일 중복검사

		//미리보기 소스 (ie는 10이상부터 지원)

		$("#upload_img").change(function(e) {
			var holder = $("#holder")[0];
			e.preventDefault();

			var file = $(this)[0].files[0], reader = new FileReader();

			reader.onload = function(event) {
				var img = new Image();
				img.src = event.target.result;
				img.width = 150;
				holder.innerHTML = '';
				holder.appendChild(img);
			};

			reader.readAsDataURL(file);
			return false;
		});//end 미리보기

		$("#join_form").submit(function() {

			if (!(chkId && chkPw && chkPwDup && chkEmail)) {
				alert("유효성 검사 실패");
				return false;
			}
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="member" id="join_form" method="post"
		enctype="multipart/form-data">
		<fieldset>
			<legend>회원가입</legend>
			<table>
				<tr>
					<th>아이디 :</th>
					<td><input type="text" name="user_id" id="user_id" value="">
						<span id="id_result"></span></td>
				</tr>
				<tr>
					<th>비밀번호 :</th>
					<td><input type="password" name="user_pw" id="user_pw"
						value=""> <span id="pw_result"></span></td>
				</tr>
				<tr>
					<th>비밀번호 확인 :</th>
					<td><input type="password" name="password_dup"
						id="password_dup" value=""> <span id="pwdup_result"></span>
					</td>
				</tr>
				<tr>
					<th>이름 :</th>
					<td><input type="text" name="user_name" id="user_name"
						value=""></td>
				</tr>
				<tr>
					<th>이메일 :</th>
					<td><input type="text" name="email" id="email" value="">
						<span id="email_result"></span></td>
				</tr>
				<tr>
					<th>사진 :</th>
					<td><input type="file" name="user_img" id="upload_img">
					</td>
				</tr>
				<tr>
					<th>미리보기 :</th>
					<td id="holder"></td>
				</tr>
			</table>

		</fieldset>
		<input type="hidden" name="command" value="join"> <input
			type="submit" name="" value="전송"> <input type="reset"
			name="reset" value="초기화"> <input type="button" name="main"
			value="메인으로" onclick="location.href='main?command=main'">
</body>
</html>
