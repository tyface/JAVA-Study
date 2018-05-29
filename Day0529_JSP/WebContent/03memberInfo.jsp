<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id = "member" class = "model.Member" />
<%-- <jsp:setProperty property="id" name="member"/> --%>
<%-- <jsp:setProperty property="name" name="member"/> --%>
<%-- <jsp:setProperty property="email" name="member"/> --%>
<%-- <jsp:setProperty property="password" name="member"/> --%>
<jsp:setProperty property="*" name="member" />


<%-- 위에서 만든 member 에  파라미터로 넘어오는 값 넣기 --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- memberForm에서 입력한 정보 확인하는 페이지 --%>
<%--
	기존에 우리가 알던 파라미터 접근 방법
	<% String id = request.getParameter("id"); %>
	<jsp:useBean>으로 bean 하나 만들고 해당하는 bean에 파라미터 넣기

	파라미터 값중에 "password"라는 이름을 가지는 파라미터가 있으면
	member.setPassword(파라미터)를 실행
	<jsp:setProperty property="password" name="member"/>

--%>
<%-- 	<% String id = request.getParameter("id"); %> --%>
<%-- 	id : <%=id %> --%>
	memberID : <%=member.getId() %> <br>
	memberPassword : <%=member.getPassword()%><br>
 	memberName : <%=member.getName()%><br>
  	memberEmail : <%=member.getEmail()%><br>
</body>
</html>
