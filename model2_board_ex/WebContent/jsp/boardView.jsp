<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="css/board.css" type="text/css"/>
<script type="text/javascript" src="js/board.js"></script>

</head>
<body>
	<div class="wrap" align="center">
		<h1>게시글 상세보기</h1>
		<table>
			<tr>
				<th>작성자</th>
				<td>${board.name}</td>
				<th>이메일</th>
				<td>${board.email}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${board.writeDate}</td>
				<th>조회수</th>
				<td>${board.readCount}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${board.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">${board.content}</td>
			</tr>
		</table>
		<br><br><br>
		<input type="button" value="수정"
			onclick="open_win('board?command=board_check_pass_form&num=${board.num}','update')">
		<input type="button" value="삭제"
			onclick="open_win('board?command=board_check_pass_form&num=${board.num}','delete')">
		<input type="button" value="목록"
			onclick="location.href='board?command=board_list'">
		<input type="button" value="새글쓰기"
			onclick="location.href='board?command=board_write_form'">
	</div>
</body>
</html>
