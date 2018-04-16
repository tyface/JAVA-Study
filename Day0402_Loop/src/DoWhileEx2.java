import java.util.Scanner;

public class DoWhileEx2 {

	public static void main(String[] args) {
		// 사용자가 특정한 수를 맞추는 게임 프로그램 작성
		// 사용자에게 숫자를 입력받아서 입력받은 수가 지정한 수보다 큰지 작은지 알려주다가
		// 사용자가 정답을 입력하면 정답! 이라고 알려주고 종료
		// do-while 사용

		int answer = 67;
		int num = 0;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("숫자를 입력해주세요.");
			num = sc.nextInt();

			if (num > answer) {
				System.out.println("입력하신 수가 정답보다 큽니다.");
			} else if (num < answer) {
				System.out.println("입력하신 수가 정답보다 작읍니다.");
			} else {
				System.out.println("정답입니다.");
			}

		} while (answer != num);
		sc.close();
	}

}
