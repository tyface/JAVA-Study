<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


	

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>두 번째 페이지</title>
</head>
<body>
	 pageContext 속성 : <%=pageContext.getAttribute("name") %> <br>
	 request 속성 : <%=request.getAttribute("name") %> <br>
	 session 속성 : <%=session.getAttribute("name") %> <br>
	 application 속성 : <%=application.getAttribute("name") %> <br>
</body>
</html>