import java.util.Scanner;

public class WhileEx2 {
	public static void main(String[] args) {
		// 사용자에게 숫자를 하나 입력받아서 1부터 입력받은 수 사이의 짝수를 출력하는 프로그램
		// 실핼 예) 숫자를 입력하세요
		// 3
		// 1부터 3까지의 합은 6 입니다.

		final int MIN_NUM = 1; //시작 값
		int maxNum;	//입력받아 검사할 변수
		
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자를 입력하세요.");

		maxNum = sc.nextInt();

		int num = MIN_NUM;
		boolean isEven = num % 2 == 0; // 짝수검사 공식
		
		System.out.printf("숫자 %d부터 %d까지의 짝수는 \r\n", MIN_NUM, maxNum);
		
		while (num <= maxNum) {
			
			if (isEven) {
				System.out.print(num + " ");
			}
			
			num++;
		}
		
		if (maxNum > 1)
			System.out.println("입니다.1");
		else 
			System.out.println("없습니다.");

	}
}
