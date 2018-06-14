<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="container">
<header>
<h1>header zone</h1>
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/myStyle.css">

<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<div>
<c:choose>
	<c:when test="${not empty sessionScope.member}">
		<img src="member?command=view-profile&user_idx=${sessionScope.member.userIdx}" id="profile_img"  onError="this.src='img/no_profile.jpg'">
		<span class="login_form">${sessionScope.member.userName}님 환영합니다.
			<button onclick="location.href='member?command=modify-form'">회원정보 수정</button>
			<button onclick="location.href='member?command=logout'">로그아웃</button>
			
		</span>
	</c:when>
	<c:otherwise>
		<form action="member" method="post" class="login_form">
			<table>
				<tr>
					<th>아이디</th>
					<td>
						<input type="text" name="user_id" value="" id="login_id">
					</td>
					<th>비밀번호</th>
					<td>
						<input type="password" name="user_pw" value="" id="login_pw">
					</td>
					<th></th>
					<td>
						<input type="hidden" name="command" value="login">
						<input type="submit" name="login" value="로그인" id="login">
						<input type="button" name="join" value="회원가입" id="join" onclick="location.href='member?command=join-form'">
					</td>
				</tr>
			</table>
		</form>
	</c:otherwise>
</c:choose>
</div>
</header>
