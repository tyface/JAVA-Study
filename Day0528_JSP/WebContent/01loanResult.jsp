<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Loan Result</title>
<style type="text/css">
	table,td,th {
		border: 1px solid black;
		border-collapse: collapse;
		text-align: center;
	}
	table{
		margin: 0px auto;
	}
</style>
</head>
<body>
	<%-- 요청에 포함된 파라미터를 받아와서, 데이터 기준으로 표만들기
	 --%>
	<%
		//파라미터는 모두 문자열 또는 문자열[]
		String amountStr = request.getParameter("amount");
		String rateStr = request.getParameter("rate");
		String periodStr =request.getParameter("period");
		String typeStr =request.getParameter("type");

		//파라미터에 있는 숫자를 적절한 데이터 타입으로 변환
		int amount = Integer.parseInt(amountStr);
		double rate = Double.parseDouble(rateStr);
		int period = Integer.parseInt(periodStr);
		int type = Integer.parseInt(typeStr);

		double mRate = rate/100/12;  //계산할 때 연이율이 아니라, 월 이율이 필요


	%>
	<table>
		<tr>
			<th>회차</th>
			<th>상환액</th>
			<th>상환원금</th>
			<th>이자</th>
			<th>상환총액</th>
			<th>대출잔액</th>
		</tr>

		<%-- tr 생성 부분을 for 문으로 작성 --%>
		<%
			//변수선언
			//상환액 : repayTotal : 월 상환원금 + 월 이자
 			//상환원금: repayOrigin : 월 상환원금
 			//이자 : interest
 			//상환총액 : repaySum : 상환 누적음액
 			//대출잔액 : repayRemain : 원금 - 상환원금 총액
			int repayTotal,repayOrigin,interest,repaySum,repayRemain;
			repayRemain = amount;  //처음 총 잔금은 내가 빌린금액
			repaySum = 0;

			//두 가지 방식으로 계산을 해야한다.
			//매월 똑같은 금액을 낼 금액을 계산을 해야한다. 상환방식에 따라서 금액이 달라짐..
			int repayMonth; //매월 같은 금액을 내는 액수를 저장할 변수

			if(type == 1){
				//원금 균등상환
				repayMonth = amount/period;
			}else{
				//원리금 균등상환
				//원리금 균등상환 계산식: (원금*월이율*Math.pow((1+월이율),period))
				//                      /(Math.pow(1+월이율,period)-1)

				repayMonth = (int)((amount*mRate*Math.pow(1+mRate,period))
						               /(Math.pow(1+mRate,period)-1));
			}
			//원금 균등상환 : repayMonth + 이자
			//원리금 균등상환: repayMonth
			for(int i=1;i<=period;i++){
				//이자 계산 , 잔금 * 이율
				interest = (int)(repayRemain*mRate);


				if(type == 1){
					//원금 균등상환
					repayTotal = repayMonth + interest;  //이번달 낼 금액의 총합
					repayOrigin = repayMonth;  //이번달 낸 원금
				}else{
					//원리금 균등상환
					repayTotal = repayMonth;
					repayOrigin = repayMonth - interest; //이번달 낸 원금
				}
				repayRemain = repayRemain - repayOrigin;

				repaySum = repaySum + repayTotal;

				%>
				<tr>
					<td><%=i%></td>
					<td><%=repayTotal%></td>
					<td><%=repayOrigin%></td>
					<td><%=interest%></td>
					<td><%=repaySum%></td>
					<td><%=repayRemain%></td>
				</tr>
				<%
			}
		%>










	</table>
</body>
</html>
