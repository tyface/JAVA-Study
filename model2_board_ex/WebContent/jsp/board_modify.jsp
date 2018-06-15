<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<jsp:include page="layout/header.jsp" />
	<article class="wrap" align="center">
		<h1>게시글 수정화면</h1>
	    <form action="board" name="frm" method="post" id="frm">
			<input type="hidden" name="command" value="update"/>
			<input type="hidden" name="board_idx" value="${board.boardIdx}"/>
			<div class="form-group">
			    <label for="user_id">아이디</label>
			    <input type="text" name=""user_id"" class="form-control" id="user_id" value="${board.userId}" readonly/>
			</div>
	      	<div class="form-group">
				    <label for="title">제목</label>
				    <input type="text" name="title" class="form-control" id="title" value="${board.title}"/>
			</div>
			<div class="form-group">
			    <label for="content">내용</label>
			    <textarea rows="15" cols="70" name="content" id="content" class="form-control">${board.content}</textarea>
			</div>
	        <br>
			<input type="submit" name="modify" value="Modify" class="btn btn-default"/>
			<input type="reset" name="reset" value="Reset" class="btn btn-default"/>
			<input type="button" value="List" onclick="location.href='board?command=list'" class="btn btn-default">
	    </form>
	</article>
<jsp:include page="layout/footer.jsp" />
