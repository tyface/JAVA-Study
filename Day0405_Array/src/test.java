import java.util.Scanner;

public class test {

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

		final int ROW = 4;
		final int COL = 2;
		int[][] arr = new int[ROW][COL];
		int totalSum = 0;
		int totalAvg = 0;
		int count = 0;
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < arr.length; i++) {

			for (int j = 0; j < arr[i].length; j++) {
				totalSum += arr[i][j] = sc.nextInt();
				count++;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			int rowSum = 0;
			int rowAvg;

			for (int j = 0; j < arr[i].length; j++) {
				rowSum += arr[i][j];
			}
			
			rowAvg = rowSum / COL;
			System.out.print(rowAvg + " ");
		}

		System.out.println();

		for (int i = 0; i < arr[i].length; i++) {
			int colSum = 0;
			int colAvg;

			for (int j = 0; j < arr.length; j++) {
				colSum += arr[j][i];
			}
			colAvg = colSum / ROW;
			System.out.print(colAvg + " ");
		}

		System.out.println();

		totalAvg = totalSum / count;
		System.out.print(totalAvg);
		sc.close();
	}

}
