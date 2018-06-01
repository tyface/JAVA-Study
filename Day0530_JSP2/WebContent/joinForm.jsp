<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입</title>
<style type="text/css">
  #button{
    text-align: right;
  }
</style>
</head>
<body>
	<!--
		form 양식 하나 만들어서 회원가입 정보 입력
		form에서 입력한 정보가 요청 파라미터로 넘어오면
		받아서 사용하기
	 -->
	<form action="join" method="post">
		<table>
			<tr>
				<th>아이디:</th>
				<td><input type="text" name="userId"></td>
			</tr>
			<tr>
				<th>비밀번호:</th>
				<td><input type="password" name="userPw"></td>
			</tr>
			<tr>
				<th>이름:</th>
				<td><input type="text" name="userName"></td>
			</tr>
			<tr>
				<th>이메일:</th>
				<td><input type="text" name="userEmail"></td>
			</tr>
			<tr>
				<th></th>
				<td id="button">
				<input type="submit" name="save" value="save">
				<input type="reset" value="reset">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
