import java.util.Scanner;

public class TaxEx {

	public static void main(String[] args) {
		// 사용자로 부터 연봉(정수,만원) 을 입력받아 소득세를 구하는 프로그램 작성
		/*
		 * 연봉 세율 기준 : 
		 * 2000만원 이하, 9% 
		 * 2000< 18% >4000 
		 * 4000< 27% >8000 
		 * 8000< 36% 
		 * 
		 * if-else if를 사용하시오 생각해야 할것 
		 * 1. 어떤 순서로 문제를 해결할 것인가? 
		 * 2. 문제를 해결하기 위한 데이터는 어떤 것이 필요한가? 
		 * 3.문제 해결을 위해 어떤 방법을 사용할 것인가?
		 * 예) 연봉을 입력하세요 
		 * 2000 
		 * 소득세는 180.00 (만원) 입니다.
		 */
		int salary;
		double tax;
		Scanner sc = new Scanner(System.in);

		
		System.out.println("연봉을 입력받아 소득세를 구하는 프로그램입니다.");
		System.out.println("연봉을 입력하세요.");

		// 입력받은 값이 정수인지 확인하는 소스
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print("정수를 입력해주세요.");
		}
		
		// 인풋
		salary = sc.nextInt();

		//입력받은 연봉에 세금을 계산하는 소스
		if (salary <= 2000) {
			tax = salary * 0.09;
		} else if (salary <= 4000) {
			tax = salary * 0.18;
		} else if (salary <= 8000) {
			tax = salary * 0.27;
		} else {
			tax = salary * 0.36;
		}
		
		//아웃풋
		System.out.printf("연봉 %d만원의 소득세는 %.2f (만원) 입니다.",salary,tax);
		sc.close();
	}

}
