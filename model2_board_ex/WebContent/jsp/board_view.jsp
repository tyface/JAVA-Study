<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
</head>
<body>
	<jsp:include page="layout/header.jsp" />
	<article class="wrap" align="center">
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
			value="${board.userIdx}" id="user_idx" /> 
			<input type="button" value="수정" id="update_btn" onclick="location.href='board?command=update-form&board_idx=${board.boardIdx}'" />
		<input type="button" value="삭제" id="delete_btn"
			onclick="open_win('board?command=check-pass-form&board_idx=${board.boardIdx}','delete')">
		<input type="button" value="목록"
			onclick="location.href='board?command=list'"> <input
			type="button" value="새글쓰기"
			onclick="location.href='board?command=write-form'">
	</article>
	<jsp:include page="layout/aside.jsp" />
	<jsp:include page="layout/footer.jsp" />
	<script type="text/javascript">
	$(function() {
		var userIdx = "${sessionScope.member.userIdx}";
		if (userIdx != $("#user_idx").val()) {
			$("#update_btn").hide();
			$("#delete_btn").hide();
		}
	})
</script>
</body>
</html>
