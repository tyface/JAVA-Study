<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	학생정보 출력합니다.<br> 
	${grade}학년 학생 목록<hr>
	<c:forEach items="${student_list}" var="student">
		번호 : ${student.SNUM} <br>
		이름 : ${student.SNAME} <br>
		학년 : ${student.SGRADE} <hr>
	</c:forEach>
	<br> 
</body>
</html>