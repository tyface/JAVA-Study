<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		border: 1px solid black;
		margin : 10px;
		padding: 10px;
	}
	td{
		text-align: center;
	}
</style>
</head>
<body>
	<!--
		대출금, 대출 이율, 상환 기간 작성하면
		각 회차별 상환 금액 출력하기
		1. 상환방식 선택하기 : a.원금 균등상환 (매달 갚는 원금이 동일)
		                b.원리금 균등상환 (매달 갚는 원금+이자가 동일)
		2. 조회 하면 매달 갚아야 하는 금액에 대해서 출력
		해 주는 프로그램 작성

		목적: 요청에서 데이터 꺼내와서 사용하기
		(요청시 데이터 포함해서 보내기 + 요청에서 데이터 꺼내서 처리하기)
	 -->
	 <form action="01loanResult.jsp">
	 	<table>
	 		<tr>
	 			<th>대출원금</th>
	 			<td><input type="text" name="amount"></td>
	 			<td>원</td>
	 		</tr>
	 		<tr>
	 			<th>대출이율</th>
	 			<td><input type="text" name="rate"></td>
	 			<td>%</td>
	 		</tr>
	 		<tr>
	 			<th>대출기간</th>
	 			<td><input type="text" name="period"></td>
	 			<td>개월</td>
	 		</tr>
	 		<tr>
	 			<td colspan="3">
	 				<label><input type="radio" checked="checked" value = "1" name="type">원금균등상환</label>
	 				<label><input type="radio" value = "2" name="type">원리금균등상환</label>
	 			</td>
	 		</tr>
	 		<tr>
	 			<td colspan="3">
	 				<input type="submit" value = "계산">
	 				<input type="reset" value = "다시작성">
	 			</td>
	 		</tr>
	 	</table>
	 </form>
</body>
</html>
