<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Message" %>
<%@ page import="model.Member" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String userId = "이름없음";
	if (session != null) {
		userId = ((Member)session.getAttribute("member")).getName();
	}
	//ArrayList<Message> list = (ArrayList<Message>)request.getAttribute("messageList");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous">

</script>
<script type="text/javascript">
	/*var messageList = new Array();
	$(function() {
		$(".messageTitle").click(function(){
			var id = $(this).prev().attr("name");




			alert(messageList[id]);
			$("#name").text();
		});
	});*/
</script>
<style type="text/css">
#messageTable, #messageTable * {
	border: 1px solid gray;
}
#button{
    text-align: right;
}
.messageTitle{
	display: inline-block; 
	width: 200px;
	white-space: nowrap;
	overflow: hidden; 
	text-overflow: ellipsis;

}
</style>
</head>
<body>
	<!--
		form 양식 하나 만들어서 회원가입 정보 입력
		form에서 입력한 정보가 요청 파라미터로 넘어오면
		받아서 사용하기
	 -->
	<%=userId%>
	님 반갑습니다!
	<br>
	<button onclick="location.href='memberList'">회원목록보기</button>
	<button onclick="location.href='modifyForm'">회원정보수정</button>
	<button onclick="location.href='logout'">로그아웃</button>
	<hr>
	<table id="messageTable">
		<tr>
			<th>글번호</th>
			<th>내용</th>
			<th>글쓴이</th>
		</tr>
		<c:forEach var="messageList" items="${messageList}" varStatus="status">
			<tr>
				<td name="${status.index}">${messageList.id}</td>
				<td class="messageTitle">${messageList.message}</td>
				<td>${messageList.name}</td>
			</tr>
		</c:forEach>
	</table>

	<hr>
	<form action="write" method="post">
		<table id="writeFrom">
			<tr>
				<th>이름</th>
				<td><input type="text" name="userName" value="${member.name}">
				</td>
			</tr>
			<tr>
				<th>비번</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea name="message" rows="8" cols="40"></textarea>
				</td>
			</tr>
			<tr>
				<th></th>
				<td id="button">
					<input type="submit" name="save" value="save">
					<input type="reset" value="reset">
				</td>
			</tr>
		</table>
	</form>


</body>
</html>
