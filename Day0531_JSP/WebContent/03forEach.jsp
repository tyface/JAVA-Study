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
	<%-- forEach 태그 연습
		배열, collection, Map 에 있는 값들을 순차적으로 접근해서 처리 
	 	 items : 순차적으로 접근하고자 하는 데이터들의 모음 
	 	 var : 각 회차에서 요소가 저장될 변수의 이름  
	 	 begin : 시작인덱스 설정
	 	 end  :종료 인덱스 설정
	 	 step  :인덱스 증가분 설정
	 	 
	 	 varStatus 속성: index, count에 접근 가능
	 	 index : 실행중 index 
	 	 count : 루프실행 횟수
	 	 first : 루프실행이 첫 번째 실행이면 true, 아니면 false
	 	 last : 루프실행이 마지막이면 true 아니면 false
	 --%>
	<%
		String[] movieList 
		={"독전","데드풀2","데자뷰","데자뷰","스탠바이,웬디","어벤져스"};
		request.setAttribute("mList", movieList);
	%>	
	<c:forEach items="${mList}" var="movie" varStatus="status" step="2">
		${movie} :index = ${status.index} 
		        , count = ${status.count}
		        , first = ${status.first}
		        , last  = ${status.last}<br>
	</c:forEach>
	
</body>
</html>




