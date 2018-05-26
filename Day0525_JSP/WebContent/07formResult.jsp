<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>요청에서 파라미터 얻어오기</title>
</head>
<body>
	<%--get방식에서 주소값에 한글을 표시할 땐 RFC2396 규약에 의해서 한글변환한 형태로 전송
		http 표준의 기본 인코딩 ISO-8859-1
	--%>


	<%-- ***파라미터의 데이터 타입은 모두 문자열*** --%>
	<%-- 얘가 하는일은 요청정보를 담고있는 request 객체에서 정보 읽어서 화면에 출력 --%>
	<%--request 객체에서 특정 이름의 파라미터 가져오기  --%>
	<% request.setCharacterEncoding("utf-8"); %>
	이름  : <%=request.getParameter("name") %> <br>
	주소  : <%=request.getParameter("address") %><br>

<%-- 	애완동물  : <%=request.getParameter("pet") %> --%>

	<%-- 해당하는 key의 파라미터가 여러개일 경우 배열 반환 --%>
	<% String[] pets = request.getParameterValues("pet");
		for(int i=0;i<pets.length;i++){
			out.print("애완동물 : "+ pets[i]+"<br>");
		}
	%>

	=========================request.getParameterNames()=============
	<!--  request에 포함된 모든 파라미터의 이름을 반환하는 함수  -->
	<br>
	<% Enumeration<String> params = request.getParameterNames();

		//params의 내용을 하나씩 가져와서 확인하기
		while(params.hasMoreElements()){
			String pName = params.nextElement();

			out.print("파라미터 이름 : " + pName + " = "
			+ request.getParameter(pName)+"<br>");
		}

	%>
	<br>
	=====================request.getParameterMap()===================
	<br>
	<!-- 파라미터들을 Map형태로 반환하는 메서드  -->
	<!-- Map: key - value
		key:String, value : String[]
	-->

	<%
		Map<String,String[]> paramMap
		= request.getParameterMap();
		String[] paramValues = paramMap.get("pet");

		for(String s:paramValues){
			out.print("pet : " + s+ "<br>");
		}
		out.print("name : " + paramMap.get("name")[0]+"<br>");
		out.print("address : " + paramMap.get("address")[0]+"<br>");
	%>
	<br>
	=================Header Information ==============
	<br>

	<%
		//헤더이름 가져오기
		Enumeration<String> headerNames =
		request.getHeaderNames();

		//반복문 돌면서 header 정보 출력하기

		while(headerNames.hasMoreElements()){
			String headerName = headerNames.nextElement();
			String headerValue = request.getHeader(headerName);
			out.print(headerName + " : " +headerValue +"<br>");
		}

	%>
		<br>








</body>
</html>
