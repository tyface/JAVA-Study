<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp" />
<article class="wrap" align="center">
	<h1>게시글 상세보기</h1>
	<br> <br>
	<table class="table table-condensed" id="board-view-tbl">
		<tr>
			<th>작성자</th>
			<td colspan="3">${board.userId}</td>
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
	<br> <br> <br> 
	<input type="hidden" value="${board.userIdx}" id="user_idx" /> 
	<input type="button" value="Modify" id="board_update_btn" onclick="location.href='board?command=update-form&board_idx=${board.boardIdx}'" class="btn btn-default">
	<input type="button" value="Delet" id="board_delete_btn" onclick="board_delete(${board.boardIdx})"class="btn btn-default">
	<input type="button" value="List" onclick="location.href='board?command=list&page_num=${pageNum}'" class="btn btn-default">
	<input type="button" value="Create" onclick="location.href='board?command=write-form'" class="btn btn-default">
</article>
<jsp:include page="layout/footer.jsp"/>
<script type="text/javascript">
	$(function() {
		var userIdx = "${sessionScope.member.userIdx}";
		if (userIdx != $("#user_idx").val()) {
			$("#board_update_btn").hide();
			$("#board_delete_btn").hide();
		}
	})
</script>
