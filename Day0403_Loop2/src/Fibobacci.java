import java.util.Scanner;

public class Fibobacci {

	public static void main(String[] args) {
		// 피보나치 수열 만들기
		// 사용자로 부터 정수하나를(3이상) 입력받아서 수만큼의 피보나치 수열을 출력
		// 0 1 1 2 3 5 8 13 21 34 ...
		// 단 1항과 2항은 0 과 1로 고정
		// 입출력 예)
		// 출력할 항의 개수를 입력하세요
		// 5
		// 0 1 1 2 3
		// for문 사용

		int num1 = 0, num2 = 1, num3;	//피보나치 수열을 넣을 변수
		int count;	//몇개의 수열을 나열할건지 저장할 변수
		Scanner sc = new Scanner(System.in);	//스캐너

		System.out.println("출력할 항의 개수를 입력하세요.");	//출력

		count = sc.nextInt();	//인풋

		if (count < 3) {	//입력받은 수가 3보다 작을경우
			
			for (int i = 0; i < count ; i++) {
				System.out.printf("%d ", i);
			}
		} else {			//입력받은 수가 3보다 클경우
			
			// 피보나치 수열 표출 계산 소스
			for (int i = 0; i < count; i++) {
				num3 = num1 + num2;
				
				System.out.printf("%d ", num1);
				
				num1 = num2;
				num2 = num3;
			}
		}  //if end
		sc.close();	//스캐너 종료
	}
}
