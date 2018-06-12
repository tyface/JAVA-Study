<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/board.js"></script>
<script type="text/javascript">
	$(function() {
		var userIdx = "${sessionScope.member.userIdx}";
		if (userIdx != $("#user_idx").val()) {
			$("#update_btn").hide();
			$("#delete_btn").hide();
		}
	})
</script>
</head>
<body>
	<jsp:include page="layout/header.jsp" />
	<jsp:include page="layout/navi.jsp" />
	<div class="wrap" align="center">
		<h1>게시글 상세보기</h1>
		<table>
			<tr>
				<th>작성자</th>
				<td>${board.userId}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${board.regDate}</td>
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
		<br> <br> <br> <input type="hidden"
			value="${board.userIdx}" id="user_idx" /> <input type="button"
			value="수정" id="update_btn"
			onclick="open_win('board?command=check-pass-form&board_idx=${board.boardIdx}','update')">
		<input type="button" value="삭제" id="delete_btn"
			onclick="open_win('board?command=check-pass-form&board_idx=${board.boardIdx}','delete')">
		<input type="button" value="목록"
			onclick="location.href='board?command=list'"> <input
			type="button" value="새글쓰기"
			onclick="location.href='board?command=write-form'">
	</div>
	<jsp:include page="layout/footer.jsp" />
</body>
</html>
