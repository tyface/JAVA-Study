<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>메인 페이지</h2><br>
	<c:choose>
		<c:when test="${not empty member.name}">
			${member.name}님 환영합니다.
			<button type="button" onclick="location.href='logout'">로그아웃</button>
			<button type="button" onclick="location.href='update-form'">회원정보 수정</button>
			<hr>
		</c:when>
		<c:otherwise>
			<button type="button" onclick="location.href='login-form'">로그인</button>
			<button type="button" onclick="location.href='join-form'">회원가입</button>
			<hr>
		</c:otherwise>
	</c:choose>
	
	<button type="button" onclick="location.href='member-list'">회원목록 보기</button>

</body>
</html>