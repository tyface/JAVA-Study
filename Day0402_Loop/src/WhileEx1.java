import java.util.Scanner;

public class WhileEx1 {
	public static void main(String[] args) {
		// 사용자에게 입력받은 수 만큼 반복해서 더하기
		// 실핼 예) 	숫자를 입력하세요
		// 			3
		// 			1부터 3까지의 합은 6 입니다.

		final int MIN_NUM = 1;
		int maxNum;
		int rs = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자를 입력하세요.");

		maxNum = sc.nextInt();

		int num = MIN_NUM;

		while (num <= maxNum) {
			rs += num++;
		}

		System.out.printf("숫자 %d부터 %d까지의 합은 %d입니다.", MIN_NUM, maxNum, rs);
	}
}
