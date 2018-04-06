import java.util.Scanner;

public class Jungol_167 {
	public static void main(String[] args) {
		// 4행 2열의 배열을 입력받아 가로평균과 세로평균 그리고 전체평균을 출력하는 프로그램을 작성하시오. (소수점 이하는 버림 한다.)
		// 입력
		// 16 27
		// 39 100
		// 19 88
		// 61 20
		// 출력
		// 21 69 53 40
		// 33 58
		// 46

		final int ROW = 4; // 배열의 행값 저장
		final int COL = 2; // 배열의 열값 저장
		int[][] arr = new int[ROW][COL]; // 입력받을 숫자를 담을 2차원 배열 생성

		int totalSum = 0; // 전체합을 저장할 변수
		int totalAvg = 0; // 전체평균을 저장할 변수
		int count = 0; // 입력받은 숫자의 개수
		Scanner sc = new Scanner(System.in); // 스캐너 생성

		// 숫자를 입력받아 2차원 배열에 저장하면서하는 반복문
		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {
				totalSum += arr[i][j] = sc.nextInt(); // 입력받은 숫자를 totalSum변수에 합함
				count++; // 입력받을때마다 카운트 증가
			}
		}

		// 행의 평균을 구하는 반복문
		for (int i = 0; i < arr.length; i++) {
			int rowSum = 0; // 행의 합
			int rowAvg; // 행의 평균

			for (int j = 0; j < arr[i].length; j++) {
				rowSum += arr[i][j];
			}
			rowAvg = rowSum / COL; // 행의 평균을 구하는 식
			System.out.print(rowAvg + " "); // 행의 평균 출력
		} // 행의 평균 end

		System.out.println();

		// 열의 평균을 구하는 반복문
		for (int i = 0; i < arr[i].length; i++) {
			int colSum = 0; // 열의 합
			int colAvg; // 열의 평균

			for (int j = 0; j < arr.length; j++) {
				colSum += arr[j][i];
			}
			colAvg = colSum / ROW; // 열의 평균을 구하는 식
			System.out.print(colAvg + " "); // 열의 평균 출력
		} // 열의 평균 end

		System.out.println();

		totalAvg = totalSum / count; // 총합의 평균을 구하는식
		System.out.print(totalAvg); // 총합의 평균 출력
		sc.close(); // 스캐너 종료
	}

}
