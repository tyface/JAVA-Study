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
		Model 2 방식으로 작성하기
		action이 일어나면 해야할 일 :
		데이터를 처리하기위해 요청에다가 데이터를 담아서 전송(서버로)
		:데이터를 처리해달라 요청 만들어 내기
		1.LoanServlet 만들기 : '/loanService' 요청 처리
		2.만들어낸 데이터를 화면으로 전달
		  Loan
		  실제 전달될 데이터는 Loan 객체가 여러개 전달되어야 함
	 -->
	 <form action="loanService" method="post">
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
