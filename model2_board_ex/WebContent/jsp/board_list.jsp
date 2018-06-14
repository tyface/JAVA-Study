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
	
	<article class="wrap" align="center">
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
		<c:if test="${pageNum > 1}">
			<a href="board?command=list&page_num=1">[처음]</a>
			<a href="board?command=list&page_num=${pageNum - 1}">[이전]</a>
		</c:if>
		<c:forEach var="num" begin="${startPage}" end="${endPage}">
			<c:choose>
				<c:when test="${pageNum == num}">
					<b>[${num}]</b>
				</c:when>
				<c:otherwise>
					<a href="board?command=list&page_num=${num}">[${num}]</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${pageNum < lastPage}">
			<a href="board?command=list&page_num=${pageNum + 1}">[다음]</a>
			<a href="board?command=list&page_num=${lastPage}">[마지막]</a>
		</c:if>
	<hr>
	<a href="board?command=write-form">게시글 등록</a>
	</article>
	<jsp:include page="layout/aside.jsp" />
	<jsp:include page="layout/footer.jsp" />
</body>
</html>

