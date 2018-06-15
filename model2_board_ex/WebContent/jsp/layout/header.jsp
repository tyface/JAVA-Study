<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
   <meta charset="utf-8">
   <meta http-equiv="X-UA-Compatible" content="chrome">
   <meta name="viewport" content="width=device-width, initial-scale=1">
   <meta name="description" content="">
   <meta name="author" content="">

   <title>호빵님의 블로그</title>

   <!-- css,js import -->
   <link href="css/bootstrap.min.css" rel="stylesheet">
   <link href="css/cover.css" rel="stylesheet">
	<link href="css/myStyle.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="js/myFunction.js"></script>
</head>

<body>
	<div class="site-wrapper">
		<div class="site-wrapper-inner">
			<div class="cover-container">
	 			<header class="masthead clearfix">
	 				<div class="inner">
						<h3 class="masthead-brand"><a href="main?command=main">Ho blog</a></h3>
						<nav>
							<ul class="masthead-login">
								<c:choose>
									<c:when test="${not empty sessionScope.member}">
										<img src="member?command=view-profile&user_idx=${sessionScope.member.userIdx}" id="profile_img"  onError="this.src='img/no_profile.jpg'" class="img-circle" alt="Cinque Terre">
										<span class="login_form">${sessionScope.member.userName}님 환영합니다.
											<button onclick="location.href='member?command=logout'" class="btn btn-default" >Logout</button>
										</span>
									</c:when>
									<c:otherwise>
										<form action="member" method="post" class="login_form">
											<table>
												<tr>
													<td>
														 <input type="text" name="user_id" id="login_id" class="form-control" placeholder="ID">
														 
													</td>
													<td>
														<input type="password" name="user_pw" value="" id="login_pw" class="form-control" placeholder="Password">
													</td>
													<td>
														<input type="hidden" name="command" value="login" >
														<button type="submit" name="login" value="Login" id="login" class="btn btn-lg btn-default">Login</button>
														<button type="button" name="join" id="join" class="btn btn-lg btn-default" onclick="location.href='member?command=join-form'">Join</button>
													</td>
												</tr>
											</table>
										</form>
									</c:otherwise>
								</c:choose>
							</ul>
			                <ul class="nav masthead-nav">
			                  <li class="active"><a href="main?command=main">Home</a></li>
			                  <li class="active"><a href="board?command=list">Board</a></li>
			                  <li class="active"><a href="member?command=modify-form">MyPage</a></li>
			                </ul>
		             	</nav>
					</div>
				</header>
