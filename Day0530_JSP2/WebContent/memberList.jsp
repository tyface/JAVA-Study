<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원목록</title>
</head>
<body>
	<!--
		form 양식 하나 만들어서 회원가입 정보 입력
		form에서 입력한 정보가 요청 파라미터로 넘어오면
		받아서 사용하기
	 -->
	<table border="1px">
		<tr>
			<th></th>
			<th>아이디</th>
			<th>이름</th>
			<th>이메일</th>
			<th>회원가입날짜</th>
		</tr>

		<c:forEach items="${memberList}" var="member" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${member.id}</td>
				<td>${member.name}</td>
				<td>${member.email}</td>
				<td>${member.regDate}</td>
			</tr>
		</c:forEach>

	</table>
	<button onclick="location.href='main'">메인화면으로</button>
</body>
</html>
