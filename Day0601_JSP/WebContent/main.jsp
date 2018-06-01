<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String userId = "이름없음";
	if (session != null) {
		userId = (String) session.getAttribute("userId");
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
</head>
<body>
	<!--
		form 양식 하나 만들어서 회원가입 정보 입력
		form에서 입력한 정보가 요청 파라미터로 넘어오면
		받아서 사용하기
	 -->
	<%=userId%>
	님 반갑습니다!
	<br>
	<button onclick="location.href='memberList'">회원목록보기</button>
	<button onclick="location.href='modifyForm'">회원정보수정</button>
	<button onclick="location.href='logout'">로그아웃</button>
	<hr>
</body>
</html>
