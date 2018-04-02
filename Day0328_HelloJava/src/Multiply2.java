import java.util.Scanner;

public class Multiply2 {

	public static void main(String[] args) {

		Scanner scan;
		int a, b, result; // 정수를 저장할 변수 a,b,result 선언

		while (true) {

			scan = new Scanner(System.in);

			try {

				System.out.println("첫번째 숫자 a를 입력하세요");
				a = scan.nextInt(); // 키보드로 보투 숫자를 읽어와서 a에 대입
				System.out.println("두번째 숫자 b를 입력하세요");
				b = scan.nextInt(); // 키보드로 보투 숫자를 읽어와서 b에 대입
				result = a * b;
				System.out.println("a * b의 결과는 " + result + "입니다.");

			} catch (Exception e) {

				System.out.println("숫자만 입력 해주세요.");
				continue;
				
			}
			
			break;
		}
	}
}
