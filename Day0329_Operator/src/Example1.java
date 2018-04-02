import java.util.Scanner;

public class Example1 {

	public static void main(String[] args) {
		// 사용자에게 숫자 2개를 입력받아서 어떤숫자가 더 큰지 알려주는프로그램.

		int i1, i2, rs;

		Scanner sc = new Scanner(System.in);

		//인풋
		System.out.println("숫자1을 입력하세요");
		i1 = sc.nextInt();
		System.out.println("숫자2를 입력하세요");
		i2 = sc.nextInt();

		//2개의 숫자중 큰수를 결과값 rs에 넣는다
		rs = i1 > i2 ? i1 : i2;
		
		//아웃풋
		if (i1 != i2) {
			System.out.println("더 큰 숫자는 " + rs + "입니다");
		} else {
			System.out.println("두개의 숫자가 중복 되었습니다.");
		}
	}

}
