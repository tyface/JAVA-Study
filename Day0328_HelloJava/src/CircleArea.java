import java.util.Scanner;

public class CircleArea {

	public static void main(String[] args) {
		// 원의 넓이를 구하는 프로그램 작성
		// 반지름(정수)을 입력받아서 원의 넓이를 구하는 프로그램

		// 3.14 * r * r = 원의 넓이 (r = 반지름)
		// 반지름 5인 원의 넓이는 xxx.xxxxx입니다.

		Scanner sc = new Scanner(System.in);// 인풋 선언
		int radius; // 반지름

		System.out.println("반지름을 입력해주세요.");

		while (!sc.hasNextInt()) { //정수값을 받았는지 검사
			sc.next(); // 잘못된 입력 값 버리기
			System.out.println("정수를 입력해주세요.");
		}

		radius = sc.nextInt();

		double clArea = 3.14 * radius * radius; // 입력받은 반지름값으로 원의 넓이를 구하는 공식

		System.out.println("반지름 " + radius + "인 원의 넓이는 " + clArea + "입니다.");
		System.out.printf("반지름 %d인 원의 넓이는 %.2f입니다.",radius,clArea);
		//printf >>출력시 포맷을 결정해놓고 출력하는 메서드
		sc.close();
	}

}
