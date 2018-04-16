import java.util.Scanner;

public class ControlEx2 {

	public static void main(String[] args) {
		// if-else 를 이용한 학점 계산기
		/*
		 * 점수를 입력받아서 점수가 
		 * 90이상일 경우 학점A 
		 * 80이상일경우 B 
		 * 70이상은 C 
		 * 60이상은 D 
		 * 60이하는 E 를 출력하는 프로그램 작성
		 * 예) 점수를 입력하세요 88 등급은 B 입니다.
		 */

		int score; // 학점을 저장할 변수
		char grade; // 등급을 저장할 변수
		Scanner sc = new Scanner(System.in);

		// 인풋
		System.out.println("학점을 을 입력받아 등급을 구하는 프로그램입니다.");
		System.out.println("학점를 입력하세요.");

		// 입력받은 값이 정수인지 확인하는 소스
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print("정수를 입력해주세요.");
		}

		score = sc.nextInt();

		// 점수별 등급을 구하는 소스
		if (score < 60) {
			grade = 'E';
		} else if (score < 70) {
			grade = 'D';
		} else if (score < 80) {
			grade = 'C';
		} else if (score < 90) {
			grade = 'B';
		} else {
			grade = 'A';
		}

		// 아웃풋
		System.out.printf("당신의 점수는 %d 등급은 %C 입니다.", score, grade);
		sc.close();
	}
}
