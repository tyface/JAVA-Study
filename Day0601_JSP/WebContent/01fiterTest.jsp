<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>필터 테스트 입니다.</title>
</head>
<body>
	<h1>요청받았습니다!!!</h1>
	ID : <%= request.getParameter("id")%> <br>
	NAME : <%= request.getParameter("name")%> <br>
	PAY : <%= request.getParameter("pay")%> <br>
</body>
</html>