import java.util.Scanner;

public class BreakEx2 {

	public static void main(String[] args) {
		// 사용자에게 정수를 입력받으면 해당 정수의 배수를 출력하다가
		// 100이상이면
		// 종료하는 프로그램 작성

		final int MAX_NUM = 100;
		int num, rs = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("숫자를 입력하세요.");
		num = sc.nextInt();

		while (true) {
			rs += num; //배수계산
			System.out.printf("%d ", rs);
			
			if (rs >= MAX_NUM || num < 1) {
				break;
			}
		}
	}

}
