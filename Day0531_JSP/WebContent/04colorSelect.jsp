<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- <c:if> if
		 <c:if> if
		 <c:if> if
		 <c:if> if

		if
		else if   >> choose when otherwise 태그 사용
	--%>
	<%-- <c:if test="${param.color ==1}">
		<span style="color:red;">빨강</span>
	</c:if>
	<c:if test="${param.color ==2}">
		<span style="color:blue;">파랑</span>
	</c:if>
	<c:if test="${param.color ==3}">
		<span style="color:green;">초록</span>
	</c:if>
	<c:if test="true">
		<span style="color:green;">초록</span>
	</c:if>--%>

	<c:choose>
		<c:when test="${param.color ==1}"><span style="color:red;">빨강</span></c:when>
    <c:when test="${param.color ==2}"><span style="color:blue;">파랑</span></c:when>
    <c:when test="${param.color ==3}"><span style="color:green;">초록</span></c:when>
	  <c:otherwise><span style="color:green;">실행되나요?</span></c:otherwise>
	</c:choose>








<%-- 		<span style="color:${color};">${msg}1111</span> --%>

</body>
</html>
