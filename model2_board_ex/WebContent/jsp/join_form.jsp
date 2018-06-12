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

		/* $("#user_id").blur(function() {
			var id  = $(this).val();
			$.ajax({
				url : "checkId",
				type : "post",
				data : {
					"userId" : id
				},
				dataType : "text",
				success : function(result) {
					if(result == true){
						$("#id_result").text(result);
					}else{
						$("#id_result").text(result);
					}
				},
				error : function(request,status,error,result){
					  alert("request: " + request);
					  alert("status: " + status);
					  alert("error: " + error);
					  alert("erresultror: " + result);
				}

			});
		}); */

		//미리보기 소스 (ie 10이상부터 지원)
		var upload = document.getElementById('upload_img'), holder = document
				.getElementById('holder');

		upload.onchange = function(e) {
			e.preventDefault();

			var file = upload.files[0], reader = new FileReader();

			reader.onload = function(event) {
				var img = new Image();
				img.src = event.target.result;
				img.width = 150;
				holder.innerHTML = '';
				holder.appendChild(img);
			};

			reader.readAsDataURL(file);
			return false;
		};//end 미리보기

	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="member" id="joinForm" method="post"
		enctype="multipart/form-data">
		<fieldset>
			<legend>회원가입</legend>
			<table>
				<tr>
					<th>아이디 :</th>
					<td><input type="text" name="user_id" id="user_id" value=""><span
						id="id_result"></span></td>
				</tr>
				<tr>
					<th>비밀번호 :</th>
					<td><input type="password" name="user_pw" id="user_pw"
						value=""></td>
				</tr>
				<tr>
					<th>비밀번호 확인 :</th>
					<td><input type="password" name="password_dup"
						id="password_dup" value=""></td>
				</tr>
				<tr>
					<th>이름 :</th>
					<td><input type="text" name="user_name" id="user_name"
						value=""></td>
				</tr>
				<tr>
					<th>이메일 :</th>
					<td><input type="text" name="email" id="email" value="">
					</td>
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
