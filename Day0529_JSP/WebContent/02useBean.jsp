<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Member" %>
<% Member m = (Member)request.getAttribute("member"); %>
<jsp:useBean id = "member" class="model.Member"/>
<jsp:setProperty name="member" property="password" value="123"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>액션태그</title>
</head>
<body>
		Member m : <%=m%> <br>
		Member member : <%=pageContext.getAttribute("member") %>

</body>
</html>
