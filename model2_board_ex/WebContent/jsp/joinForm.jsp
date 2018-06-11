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

		$("#user_id").blur(function() {
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
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="member"  id="joinForm" method="post">
		<fieldset>
			<legend>회원가입</legend>
			<table>
				<tr>
					<th>아이디 : </th>
					<td>
						<input type="text" name="user_id" id="user_id" value=""><span id="id_result"></span>
					</td>
				</tr>
				<tr>
					<th>비밀번호 : </th>
					<td>
						<input type="password" name="user_pw" id="user_pw" value="">
					</td>
				</tr>
				<tr>
					<th>비밀번호 확인 : </th>
					<td>
						<input type="password" name="password_dup" id="password_dup" value="">
					</td>
				</tr>
				<tr>
					<th>이름 : </th>
					<td>
						<input type="text" name="user_name" id="user_name" value="">
					</td>
				</tr>
				<tr>
					<th>이메일 : </th>
					<td>
						<input type="text" name="email" id="email" value="">
					</td>
				</tr>

			</table>

		</fieldset>
		<input type="hidden" name="command" value="join">
		<input type="submit" name="" value="전송">
		<input type="reset" name="reset" value="초기화">
	</form>

</body>
</html>
