package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Loan;

@WebServlet("/loanService")
public class LoanServlet extends HttpServlet {
	//'loanService' 요청 받아서 처리, post 방식으로
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//아이디랑 비밀번호 요청에서 꺼내와서 원래 가지고 있던 아이디랑 비밀번호 비교
		
		String amountStr = request.getParameter("amount");
		String rateStr = request.getParameter("rate");
		String periodStr =request.getParameter("period");
		String typeStr =request.getParameter("type");

		//파라미터에 있는 숫자를 적절한 데이터 타입으로 변환
		int amount = Integer.parseInt(amountStr);
		double rate = Double.parseDouble(rateStr);
		int period = Integer.parseInt(periodStr);
		int type = Integer.parseInt(typeStr);
		
		int repayTotal = amount;
		int repayOrigin;
		int interest;
		int repaySum = 0;
		int repayRemain = amount;
		double mRate = rate/100/12;
		List<Loan> loanList = new ArrayList<Loan>();
		
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
			
			loanList.add(new Loan(repayTotal, repayOrigin, interest, repaySum, repayRemain));
		}
		
		RequestDispatcher dispatcher
		= request.getRequestDispatcher("04loanResult.jsp");
		request.setAttribute("loanList", loanList);
		dispatcher.forward(request, response);
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
}






