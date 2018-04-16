import java.util.Scanner;

public class Salary {

	public static void main(String[] args) {
		// 저축액을 계산하는 프로그램

		// 메인메서드작성
		// 저축(정수) 를 입력받아서 10년 동안 저축액 (원금)을 구하는 프로그램 작성
		// 단, 월급의 인상은 없음, 월급의 절반을 저축한다고 가정.

		// 프로그램 실행 예)
		// 저축을 입력하세요.
		// 1000000
		// 10년동안의 저축액 : ~~~원.

		Scanner scan = new Scanner(System.in);
		; // 인풋 선언
		int save; // 저축액 변수
		int year = 10; // 저축할 연수

		System.out.println("저축액을 입력하세요");

		while (!scan.hasNextInt()) {
			scan.next(); // 잘못된 입력 값 버리기
			System.out.print("정수를 입력해주세요.");
		}

		save = scan.nextInt();

		int totalSave = save * year * 12; // 저축액 * 연수

		System.out.println(year + "년동안의 저축액 : " + totalSave + "원 입니다.");
		scan.close();
	}

}
