import java.util.Scanner;

public class Practice {
	public static void main(String[] args) {
		// while - break 연습예제
		// 사용자에게 숫자(정수)를 입력받아서 계속해서 더합니다.
		// -1을 입력받으면 그 전까지 더한 숫자의 총합과 평균을 출력하는 프로그램입니다.
		// 단 평균은 소수점 둘째 자리에서 반올림 하여 한 자리만 표시
		// 입출력 예)
		// 5
		// 10
		// 6
		// 7
		// -1
		// 총합은 28 평균은 7.0 입니다.

		final int RESULT_KEY = -1;		//결과 표출키
		int num;		// 입력받을 숫자를 담을 변수
		int sum = 0;	// 총합을 담을 변수
		double avg;		// 평균을 담을 변수
		Scanner sc = new Scanner(System.in);		// 스캐너 생성
		
		System.out.println("입력받은 숫자의 총합과 평균을 구하는 프로그램입니다.(-1 입력시 결과표출)");		// 프로그램 설명

		int i = 0;		// while문의 반복 회차_평균을 구할때 사용
		
		while (true) {	// while start
			System.out.print("숫자를 입력하세요.");		

			while (!sc.hasNextInt()) {		// 유효성검사_입력받은 값이 정수인지 확인
				sc.next();
				System.out.print("정수를 입력하세요.");
			}								// 유효성검사_end
			
			num = sc.nextInt();				// 인풋
			
			if (num == RESULT_KEY) {		// RESULT_KEY를 입받았을때 총합과 평균을 구한 후 출력
				
				if (i == 0) {				// 총합과 평균을 구할 숫자가 없을때 재시작
					System.out.println("입력받은 숫자가 없습니다. ");
					continue;
				}								
				break;						//반복 종료
			}
			sum += num;			// 총합을 구하는식
			i++;				// 반복 회차 증가
		}	// while end
		
		avg = (double)sum / i;	// 평균을 구하는 식
		System.out.printf("총합은 %d 평균은 %.1f 입니다.", sum, avg);		// 출력
		
		sc.close();				//스캐너 종료
	}
}
