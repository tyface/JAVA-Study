import java.util.Scanner;

public class LeafYear {

	public static void main(String[] args) {
		// 사용자에게 연도를 입력받아서 해당 년도가 윤년인지 아닌지 검사하는 프로그램 작성
		/*
		 * 윤년의 조건 
		 * 1. 4로 나누어 떨어지면서 100으로 나누어 떨어지지 않음 
		 * 2. 400으로 나누어 떨어짐 
		 * 3. 1,2중 하나라도 만족하면
		 * 윤년
		 */
		int year; // 입력받을 년도
		boolean temp1, temp2; // 조건 검사용 임시저장소
		String rs; // 결과값
		Scanner sc = new Scanner(System.in); // 스캐너

		System.out.println("연도를 입력하세요");

		year = sc.nextInt(); // 인풋

		// 윤년인지 검사하는 소스
		temp1 = year % 4 == 0 && year % 100 != 0; 
		temp2 = year % 400 == 0;
		rs = temp1 || temp2 ? "윤년" : "평년";

		System.out.printf("%d년은 %s입니다.", year, rs); // 아웃풋

	}
}
