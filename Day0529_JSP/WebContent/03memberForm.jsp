<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파라미터 값 사용하기</title>
</head>
<body>
	<!--
		form 양식 하나 만들어서 회원가입 정보 입력
		form에서 입력한 정보가 요청 파라미터로 넘어오면
		받아서 사용하기
	 -->
	 <form action="03memberInfo.jsp" method = "post">
	 	<table>
	 		<tr>
	 			<th>아이디: </th>
	 			<td><input type="text" name = "id"></td>
	 		</tr>
	 		<tr>
	 			<th>비밀번호: </th>
	 			<td><input type="password" name = "password"></td>
	 		</tr>
	 		<tr>
	 			<th>이름: </th>
	 			<td><input type="text" name = "name"></td>
	 		</tr>
	 		<tr>
	 			<th>이메일: </th>
	 			<td><input type="text" name = "email"></td>
	 		</tr>
	 		<tr><td><input type="submit" value="회원가입"></td></tr>
	 	</table>
	 </form>
</body>
</html>
