<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="layout/header.jsp" />
<h3>Board</h3>
<br>
<br>
<article class="wrap" align="center">
	<table id="borad_list" class="table table-condensed">
		<tr>
			<th>번호</th>
			<th class="th_title">제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${boardList}" var="board">
			<tr>
				<td>${board.boardIdx}</td>
				<td class="td_title">
					<a href="board?command=view&board_idx=${board.boardIdx}&page_num=${pageNum}">${board.title}</a>
				</td>
				<td>${board.userId}</td>
				<td>${board.regDate}</td>
				<td>${board.readCount}</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<div class="write-btn">
		<a href="board?command=write-form">게시글 등록</a>
	</div>
	<br>
	<br>
	<c:if test="${pageNum > 1}">
		<a href="board?command=list&page_num=1" class="page-nav">[처음]&nbsp;</a>
		<a href="board?command=list&page_num=${pageNum - 1}" class="page-nav">[이전]&nbsp;</a>
	</c:if>
	
	<c:forEach var="num" begin="${startPage}" end="${endPage}">
		<c:choose>
			<c:when test="${pageNum == num}">
				<b class="page-nav">[${num}]&nbsp;</b>
			</c:when>
			<c:otherwise>
				<a href="board?command=list&page_num=${num}" class="page-nav">[${num}]&nbsp;</a>
			</c:otherwise>
		</c:choose>
	</c:forEach>
	
	<c:if test="${pageNum < lastPage}">
		<a href="board?command=list&page_num=${pageNum + 1}" class="page-nav">[다음]&nbsp;</a>
		<a href="board?command=list&page_num=${lastPage}" class="page-nav">[마지막]&nbsp;</a>
	</c:if>
	<hr>

</article>
<jsp:include page="layout/footer.jsp" />

