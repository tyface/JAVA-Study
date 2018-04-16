import java.util.Scanner;

public class ArrayEx2 {
	public static void main(String[] args) {
		// 학생의 점수(정수)를 입력받는 10칸짜리 배열하나 생성
		// 반복문을 이용하여 배열에 데이터 채워 넣지.
		// 데이터가 입력되고 난 뒤 점수 출력하기
		// 입출력 예)
		// 점수를 입력하세요.
		// 50
		// 점수를 입력하세요.
		// 50
		// ...
		// 10번반복
		//
		// 입력된 점수는 50 50 ... (10개)

		int[] scores = new int[10];

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < scores.length; i++) {
			System.out.println("점수를 입력하세요.");
			scores[i] = sc.nextInt();
		}
		System.out.print("입력된 점수는 ");
		
		for (int i = 0; i < scores.length; i++) {
			System.out.printf("%d ", scores[i]);
		}
		System.out.printf("(%d개) ", scores.length);
		sc.close();
	}
}





