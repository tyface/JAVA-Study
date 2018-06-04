package model;

public class Loan {
	
	//회차별 대충 상환정보를 저장할 수 있는 클래스
	//변수선언
	//상환액 : repayTotal : 월 상환원금 + 월 이자
		//상환원금: repayOrigin : 월 상환원금
		//이자 : interest
		//상환총액 : repaySum : 상환 누적음액
		//대출잔액 : repayRemain : 원금 - 상환원금 총액
//	int amount;
//	double rate;
//	int period;
//	int type;
	
	private int repayTotal;
	private int repayOrigin;
	private int interest;
	private int repaySum;
	private int repayRemain;
	
	public Loan(int repayTotal, int repayOrigin, int interest, int repaySum, int repayRemain) {
		this.repayTotal = repayTotal;
		this.repayOrigin = repayOrigin;
		this.interest = interest;
		this.repaySum = repaySum;
		this.repayRemain = repayRemain;
	}

	@Override
	public String toString() {
		return "Loan [repayTotal=" + repayTotal + ", repayOrigin=" + repayOrigin + ", interest=" + interest
				+ ", repaySum=" + repaySum + ", repayRemain=" + repayRemain + "]";
	}

	public int getRepayTotal() {
		return repayTotal;
	}

	public void setRepayTotal(int repayTotal) {
		this.repayTotal = repayTotal;
	}

	public int getRepayOrigin() {
		return repayOrigin;
	}

	public void setRepayOrigin(int repayOrigin) {
		this.repayOrigin = repayOrigin;
	}

	public int getInterest() {
		return interest;
	}

	public void setInterest(int interest) {
		this.interest = interest;
	}

	public int getRepaySum() {
		return repaySum;
	}

	public void setRepaySum(int repaySum) {
		this.repaySum = repaySum;
	}

	public int getRepayRemain() {
		return repayRemain;
	}

	public void setRepayRemain(int repayRemain) {
		this.repayRemain = repayRemain;
	} 
	
	
}
