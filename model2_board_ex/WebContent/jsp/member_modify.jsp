<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp" />
<article>
	<form action="member" id="modify_form" method="post" enctype="multipart/form-data">
		<h3>회원정보 수정</h3>
		<hr>
		<div class="form-group">
		    <label for="user_id">아이디 :</label>
		    <input type="text" name="user_id" class="form-control" id="user_id" value="${sessionScope.member.userId}" readonly>
		</div>
		<div class="form-group">
			<label for="user_pw">비밀번호 :</label>
			<input type="password" name="user_pw" class="form-control" id="user_pw"> 
			<span id="pw_result"></span>
		</div>
		<div class="form-group">
			<label for="pwdup_result">비밀번호 확인 :</label>
			<input type="password" name="password_dup" class="form-control" id="password_dup" >
			<span id="pwdup_result"></span>
		</div>
		<div class="form-group">
			<label for="user_name">이름 :</label>
			<input type="text" name="user_name" class="form-control" id="user_name" value="${sessionScope.member.userName}">
		</div>
		<div class="form-group">
			<label for="email">이메일 :</label>
			<input type="email" name="email" class="form-control" id="email" value="${sessionScope.member.email}">
			<span id="email_result"></span>
		</div>
		<div class="form-group">
			<label for="user_img">사진 :</label>
			<input type="file" name="user_img" id="upload_img">
		</div>
		<div class="form-group">
			<label for="holder">미리보기 :</label>
			<div id="holder"></div>
		</div>
		
		<input type="hidden" name="user_idx" value="${sessionScope.member.userIdx}"> 
		<input type="hidden" name="command" value="modify"> 
		<input type="submit" name="submit" value="Submit" class="btn btn-default"> 
		<input type="reset" name="reset" value="Reset" class="btn btn-default"> 
		<input type="button" name="delete" value="Delete" id="delete_btn" class="btn btn-default"> 
		<input type="button" name="main" value="Main" onclick="location.href='main?command=main'" class="btn btn-default">
	</form>
</article>
<jsp:include page="layout/footer.jsp" />
	<script type="text/javascript">
	$(function() {
		var chkPw = false, chkPwDup = false, chkEmail = true;
		
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
			var default_email = "${sessionScope.member.email}";
			
			if(!(default_email == email)){
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
			}
			
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
			if (!(chkPw && chkPwDup && chkEmail)) {
				alert("유효성 검사 실패");
				return false;
			}
			
		});

	});
</script>
