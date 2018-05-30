<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="05header.jsp">
	<jsp:param value="hong" name="name"/>
	</jsp:include>
	<hr>
	<h2>메인입니다.</h2>
	<a href="05sub.jsp">서브페이지로 이동</a>
	<hr>
	<jsp:include page="05footer.jsp"/>
  
</body>
</html>
