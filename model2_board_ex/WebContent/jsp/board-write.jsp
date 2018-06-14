<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 등록</title>
</head>
<body>
	<jsp:include page="layout/header.jsp" />
	<article class="wrap" align="center">
		<h1>게시글 등록</h1>
		<form action="board" name="frm" method="post" id="frm">
			<input type="hidden" name="command" value="write" />
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" id="title">*필수</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="15" cols="70" name="content" id="content"></textarea></td>
				</tr>
			</table>
			<br> <input type="submit" name="" value="등록" /> <input
				type="reset" name="" value="다시작성" /> <input type="button"
				value="목록" onclick="location.href='board?command=list'">
		</form>
	</article>
	<jsp:include page="layout/aside.jsp" />
	<jsp:include page="layout/footer.jsp" />
	<script type="text/javascript">
	$(function() {
		$("#frm").on("submit", function() {
			var title = $("#title");
			var result = false;

			if (title.val() == "") {
				alert("제목을 입력해주세요");
			} else {
				result = true;
			}

			return result;
		});
	});
</script>
</body>
</html>
