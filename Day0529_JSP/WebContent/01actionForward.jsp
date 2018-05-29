<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	<jsp:forward> 사용해보기

	넘어온 파라미터의 값에 따라서 적절한 페이지로 포워딩
--%>
<%
	request.setCharacterEncoding("UTF-8");
	//파라미터 받아오기
	String color = request.getParameter("color");
	String url=null;
	if(color.equals("red")){
		//빨간페이지 이동
		url = "red.jsp";
	}else if(color.equals("blue")){
		//파란페이지 이동
		url = "blue.jsp";
	}else if(color.equals("yellow")){
		//노란페이지 이동
		url = "yellow.jsp";
	}
// 	RequestDispatcher dispatcher
// 	 = request.getRequestDispatcher(url);

// 	dispatcher.forward(request, response);
//request.setCharacterEncoding("UTF-8");
%>
<jsp:forward page="<%=url%>">
	<jsp:param value="홍길동" name="name"/>
</jsp:forward>
