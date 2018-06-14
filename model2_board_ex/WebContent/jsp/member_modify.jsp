<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="layout/header.jsp" />
	<article>
	<form action="member" id="modify_form" method="post"
		enctype="multipart/form-data">
		<fieldset>
			<legend>회원정보 수정</legend>
			<table>
				<tr>
					<th>아이디 :</th>
					<td><input type="text" name="user_id" id="user_id"
						value="${sessionScope.member.userId}" readonly> <span
						id="id_result"></span></td>
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
						value="${sessionScope.member.userName}"></td>
				</tr>
				<tr>
					<th>이메일 :</th>
					<td><input type="text" name="email" id="email"
						value="${sessionScope.member.email}"> <span
						id="email_result"></span></td>
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
		<input type="hidden" name="user_idx"
			value="${sessionScope.member.userIdx}"> <input type="hidden"
			name="command" value="modify"> <input type="submit"
			name="submit" value="전송"> <input type="reset" name="reset"
			value="초기화"> <input type="button" name="delete"
			value="회원탈퇴" id="delete_btn"> <input type="button" name="main" value="메인으로"
			onclick="location.href='main?command=main'">
	</article>
	<jsp:include page="layout/aside.jsp" />
	<jsp:include page="layout/footer.jsp" />
	<script type="text/javascript">
	$(function() {
		
		var chkPw = false, chkPwDup = false, chkEmail = false;
		
		//비밀번호 유효성 검사
		$("#user_pw").blur(function() {
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

		$("#modify_form").submit(function() {

			if (!(chkId && chkPw && chkPwDup && chkEmail)) {
				alert("유효성 검사 실패");
				return false;
			}
		});

		$("#delete_btn").click(function() {
			confirm
			alert("삭제");
			return false;
		});

	});
</script>
</body>
</html>
