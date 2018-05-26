<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>gugudan</title>
</head>
<body>
	<%-- 화면에 구구단 출력하기
		2 X 1  = 2
		2 X 2  = 4
		2 X 3  = 6
		2 X 4  = 8
	 --%>
	<%
		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				out.print(i + " X " + j + " = " + i * j + "<br>");
			}
			out.print("<hr>111");
		}
	%>

</body>
</html>
