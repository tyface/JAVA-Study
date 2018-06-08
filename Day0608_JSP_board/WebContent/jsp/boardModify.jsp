<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판</title>
<link rel="stylesheet" href="css/board.css" type="text/css"/>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script type="text/javascript">
	$(function() {
		$("#frm").on("submit", function() {
			var name = $("#name");
			var password = $("#password");
			var email = $("#email");
			var title = $("#title");
			var result = false;
			
			if (name.val() == "") {
				alert("작성자를 입력해주세요");
			} else if (password.val() == "") {
				alert("비밀번호를 입력해주세요");
			} else if (email.val() == "") {
				alert("이메일을 입력해주세요");
			} else if (title.val() == "") {
				alert("제목을 입력해주세요");
			} else {
				result = true;
			}

			return result;
		});
	});
</script>
</head>
<body>
	<div class="wrap"  align="center">
	<h1>게시글 수정화면</h1>
    <form action="board" name="frm" method="post" id="frm">
      <input type="hidden" name="command" value="board_update"/>
      <input type="hidden" name="num" value="${param.num}"/>
        <table>
          <tr>
            <th>작성자</th>
            <td><input type="text" name="name" value="${board.name}" id="name"></td>
          </tr>
          <tr>
            <th>비밀번호</th>
            <td><input type="password" name="password" value="${board.pass}" id="password"></td>
          </tr>
          <tr>
            <th>이메일</th>
            <td><input type="text" name="email" value="${board.email}" id="email"></td>
          </tr>
          <tr>
            <th>제목</th>
            <td><input type="text" name="title" value="${board.title}" id="title"></td>
          </tr>
          <tr>
            <th>내용</th>
            <td><textarea rows="15" cols="70" name="content" id="content">${board.content}</textarea></td>
          </tr>
        </table>
        <br>

      <input type="submit" name="" value="수정"/>
      <input type="reset" name="" value="다시작성"/>
      <input type="button" value="목록"
			onclick="location.href='board?command=board_list'">
    </form>
  </div>
</body>
</html>
