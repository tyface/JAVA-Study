<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>네이버 책 검색</title>
</head>
<body>
	<form action="book-search">
		<input type="text" name="keyword"> <input type="submit"
			value="전송">
	</form>
	<c:forEach items="${booklist}" var="book">
		<img src="${book.image}"/> <br>
		제목 : ${book.title}  <a href="${book.link}">링크</a><br>
		저자 : ${book.author} <br>
		가격 : ${book.price} <br>
		할인가격 : ${book.discount} <br>
		출판사 : ${book.publisher} <br>
		ISBN : ${book.isbn} <br>
		내용 : ${book.description} <br>
		출판일 : ${book.pubdate} <br><hr>
		
	</c:forEach>



</body>
</html>