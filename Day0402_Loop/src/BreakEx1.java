import java.util.Scanner;

public class BreakEx1 {
	public static void main(String[] args) {
		// 사용자에게 숫자를 입력받고, *2 한수를 출력하다가 -1을 입력받으면 출력하지않고 종료

		int num;
		Scanner sc = new Scanner(System.in);

		while (true) {

			System.out.println("숫자를 입력하세요.(-1을 입력하면 종료)");
			num = sc.nextInt();

			if (num != -1) {
				System.out.printf("%d X 2 = %d입니다.\r\n", num, num * 2);
			} else {
				System.out.println("종료 되었습니다.");
				break;
			}
		}
	}
}
