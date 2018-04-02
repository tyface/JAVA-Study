
public class Operator5 {

	public static void main(String[] args) {
		// 조건 삼항 연산자
		// 조건식 ? 값1 : 값2
		// 조건식이 참이면 값1을 선택, 거짓이면 값2를 선택
		
		//grade : 학년, 4학년 이상(4,5,6) 이면 용돈 500원 3학년 이하면 100원
		
		int grade = 3;
		int pocketMoney;
		
		pocketMoney = grade <= 3 ? 100 : 500;
		
		System.out.println(pocketMoney);
		
	}

}
