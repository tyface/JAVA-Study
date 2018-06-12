<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BoradList Page</title>
</head>
<body>
	<jsp:include page="layout/header.jsp" />
	<jsp:include page="layout/navi.jsp" />
	<div class="wrap" align="center">
		<table id="list">

			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.boardIdx}</td>
					<td><a href="board?command=view&board_idx=${board.boardIdx}">${board.title}</a></td>
					<td>${board.userId}</td>
					<td>${board.regDate}</td>
					<td>${board.readCount}</td>
				</tr>
			</c:forEach>

		</table>
			<a href="board?command=list&pageNum=1">[처음]</a>
			<a href="board?command=list&pageNum=${pageNum-1}">[이전]</a>
		
		<c:forEach var="num" begin="${startPage}" end="${endPage}">
			<c:choose>
				<c:when test="${pageNum == num}">
					<b>[${num}]</b>
				</c:when>
				<c:otherwise>
					<a href="board?command=list&pageNum=${num}">[${num}]</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		
			<a href="board?command=list&pageNum=${pageNum + 1}">[다음]</a>
			<a href="board?command=list&pageNum=${lastPage}">[마지막]</a>
	</div>
	<hr>
	<a href="board?command=write-form">게시글 등록</a>
	<jsp:include page="layout/footer.jsp" />
</body>
</html>

