<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- form : 다른페이지로 이동하는 요청을 보낼때, 데이터를 쉽게 전달할 수 있게
			    해주는 html 요소
	 	 url?파라미터1이름=값&파라미터2이름=값
	 	 hello요청을 하면서 name이라는 파라미터에 홍길동이라는 데이터를 담아서 넘겨주겠다.
	 ex) localhost:8080/Day0525_JSP/hello?name=홍길동&id=hong


	 localhost:8080/Day0525_JSP/logincheck.jsp?userid=123123&userpw=123123

	 url에 요청시 포함한 파라미터가 보여지는 요청방식: GET
	 url에 요청시 포함한 파라미터를 숨겨서 전달하는 방식 : POST


	 -->
	 <form action="06logincheck.jsp" method="POST">
	 	<p><label>아이디<input type="text" name="userid"></label></p>
	 	<p><label>비밀번호<input type="password" name="userpw"></label></p>
	 	<p><input type="submit" value = "로그인"></p>
	 </form>

</body>
</html>
