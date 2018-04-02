import java.util.Scanner;

public class ControlEx1 {

	public static void main(String[] args) {
		// 사용자에게 정수를 하나 입력받아서 짝수인지 홀수 인지 출력하는 프로그램

		int num;
		boolean rs;
		Scanner sc = new Scanner(System.in);

		// 인풋
		System.out.println("짝수와 홀수를 구분하는 프로그램 입니다.");
		System.out.println("숫자를 입력하세요.");

		// 입력받은 값이 정수인지 확인하는 소스
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print("정수를 입력해주세요.");
		}

		num = sc.nextInt();

		// 짝수와 홀수를 확인하는 소스
		rs = num % 2 == 0;

		// 아웃풋
		if (num == 0) {
			System.out.print("입력하신 숫자가 0입니다.");
		} else if (rs) {
			System.out.printf("%d는 짝수입니다.", num);
		} else {
			System.out.printf("%d는 홀수입니다.", num);
		}

	}

}
