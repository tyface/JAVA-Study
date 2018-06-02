<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Member" %>
<%
Member member = (Member)request.getAttribute("member");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<style type="text/css">
form{
	width:252px;
}
#button {
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
	<h1>회원정보 수정</h1>
	<form action="modify" method="post">
		<table>
			<tr>
				<th>아이디:</th>
				<td><input type="text" name="userId" value="${member.id}" readonly/></td>
			</tr>
			<tr>
				<th>비밀번호:</th>
				<td><input type="password" name="userPw" value="${member.pw}"></td>
			</tr>
			<tr>
				<th>이름:</th>
				<td><input type="text" name="userName" value="${member.name}"></td>
			</tr>
			<tr>
				<th>이메일:</th>
				<td><input type="text" name="userEmail" value="${member.email}"></td>
			</tr>

		</table>
		<div id="button">
		<input type="submit" name="secession" value="modify" />
		<input type="button" name="cencel" value="cencel" onclick="location.href='main'"/>
		</div>
	</form>
</body>
</html>
