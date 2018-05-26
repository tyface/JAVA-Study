<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>데이터 전달하는 폼</title>
</head>
<body>
	<form action = "07formResult.jsp" method ="post">
		<p><label>이름  <input type="text" name="name"></label></p>
		<p><label>주소 <input type="text" name="address"></label></p>
		<p>
			<label><input type="checkbox" name="pet" value="dog">강아지</label>
			<label><input type="checkbox" name="pet" value="cat">고양이</label>
			<label><input type="checkbox" name="pet" value="pig">돼지</label>
			<label><input type="checkbox" name="pet" value="tiger">호랑이</label>
		</p>
		<input type="submit" value = "전송">
	</form>
</body>
</html>
