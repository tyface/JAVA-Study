<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>타이틀</title>
<style type="text/css">
  #button{
    text-align: right;
  }
</style>
</head>
<body>
	<form action="board" method="post">
		<table border="1px" solid=>
			<tr>
				<th>제목 :</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>작성자 :</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>이메일 :</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<th>비밀번호 :</th>
				<td><input type="password" name="pass"></td>
			</tr>
			<tr>
				<th>내용 :</th>
				<td><textarea name="content" rows="15"></textarea></td>
			</tr>
			<tr>
				<th></th>
				<td id="button">
				<input type="submit" name="save" value="save">
				<input type="reset" value="reset">
				</td>
			</tr>
		</table>

	</form>


</body>
</html>
