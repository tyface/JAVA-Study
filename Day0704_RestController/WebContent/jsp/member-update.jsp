<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원정보 수정 페이지</h2>
	<form action="update" method="post">
		아이디 : <input type="text" name="user_id" value="${member.id}" readonly="readonly"/> <br>
		비밀번호 : <input type="password" name="user_pw" value=""/> <br>
		이름 : <input type="text" name="user_nm" value="${member.name}"/> <br>
		이메일 : <input type="text" name="user_email" value="${member.email}"/> <br><br>
		<input type="submit" value="회원정보 수정">
		<input type="reset" value="초기화">
	</form>
</body>
</html>