<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h1>header zone</h1>


<c:choose>
	<c:when test="${not empty sessionScope.member}">
		${sessionScope.member.userName}님 환영합니다.
		<button onclick="location.href='member?command=logout'">로그아웃</button>
	</c:when>
	<c:otherwise>
		<form action="member" method="post">
			<table>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="user_id" value="" id="user_id">
					</td>
					<th>비밀번호</th>
					<td>
						<input type="password" name="user_pw" value="" id="user_pw">
					</td>
					<th></th>
					<td>
						<input type="hidden" name="command" value="login">
						<input type="submit" name="login" value="로그인" id="login">
						<input type="button" name="join" value="회원가입" id="join" onclick="location.href='member?command=joinForm'">
					</td>
				</tr>
			</table>
		</form>
	</c:otherwise>
</c:choose>

