<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select Forward</title>
</head>
<body>
	<%--
		<select>를 이용해서 값 하나 선택해서 해당하는 페이지로 이동
		빨강, 파랑, 노랑, 색깔 중에 하나 선택해서 해당하는 페이지로 이동
	 --%>
	 <form action="01actionForward.jsp">
	 	<select name = "color">
	 		<option value = "red">빨강</option>
	 		<option value = "blue">파랑</option>
	 		<option value = "yellow">노랑</option>
	 	</select>
	 	<input type="submit" value = "이동">
	 </form>
</body>
</html>
