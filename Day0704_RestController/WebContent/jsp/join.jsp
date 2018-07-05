<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입 페이지</h2>
	<form action="join" method="post">
		아이디 : <input type="text" name="user_id" /> <br>
		비밀번호 : <input type="password" name="user_pw" /> <br>
		이름 : <input type="text" name="user_nm" /> <br>
		이메일 : <input type="text" name="user_email" /> <br><br>
		<input type="submit" value="회원가입">
		<input type="reset" value="초기화">
	</form>
</body>
</html>