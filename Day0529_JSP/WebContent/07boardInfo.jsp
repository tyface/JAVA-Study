<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Board"%>
<% Board board = (Board)request.getAttribute("board"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>타이틀</title>
</head>
<body>

	<table border="1px">
		<tr>
			<th>제목 :</th>
			<td><%= board.getTitle() %></td>
		</tr>
		<tr>
			<th>작성자 :</th>
			<td><%= board.getName() %></td>
		</tr>
		<tr>
			<th>이메일 :</th>
			<td><%= board.getEmail() %></td>
		</tr>
		<tr>
			<th>비밀번호 :</th>
			<td><%= board.getPass() %></td>
		</tr>
		<tr>
			<th>내용 :</th>
			<td><textarea name="content" rows="15"><%= board.getContent() %>
			</textarea></td>
		</tr>
	</table>


</body>
</html>
