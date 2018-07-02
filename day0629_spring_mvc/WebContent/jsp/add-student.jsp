<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>학생 추가 페이지</title>
</head>
<body>
	학생 추가 페이지 <br />
	<form action="add-student" method="post">
		이름 : <input type = "text" name="name"/>
		학년 : <input type = "text" name="grade"/>
		<input type="hidden" value="add-student"/>
		<input type="submit" value="전송"/>
	</form>

</body>
</html>