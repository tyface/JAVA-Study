import java.util.Scanner;

public class Gugudan {
	public static void main(String[] args) {
		// 사용자에게 숫자를 입력받아서 해당하는 숫자의 구구단을 출력하기

		int num = 0, rs;
		Scanner sc = new Scanner(System.in);

		System.out.println("구구단 프로그램입니다.");
		System.out.println("1~9까지의 숫자중 하나를 입력해주세요.");

		num = sc.nextInt();

		System.out.println(num + "단은 ");

		for (int i = 1; i <= 9; i++) {
			rs = i * num;
			System.out.printf("%d X %d = %d\r\n", num, i, rs);
		}
		sc.close();
	}
}
