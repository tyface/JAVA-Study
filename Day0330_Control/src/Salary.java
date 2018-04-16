import java.util.Scanner;

public class Salary {

	public static void main(String[] args) {
		// 사용자에게 일한 시간을 입력받고, 일한 시간의 수당을 계산해서 화면에 보여주는 프로그램
		 /* 정규 근무 시간은 8시간, 8시간을 초과하여 근무하였을 경우 추가 수당을 지급한다. 
		 * 시급은 7530원이다. 8시간을 초과하였을 경우 초과한 시간만큼은 시급의 1.5배를 적용 
		 * 예) 
		 * 10시간 일했다고 가정할 경우 8*7530 + 2*7530*1.5
		 * 
		 * 급여는 소수점 둘째자리 까지 출력
		 */

		int hour; //입력받을 근무시간을 저장할변수
		final int TIME_PAY = 7530, REG_HOURS = 8; //최저시급과 정규근무시간을 저장할 변수
		final double OVER_PAY_RATE = 1.5; //초과 근무 수당배율
		double totalPAY; //급여를 저장할 변수
		
		Scanner sc = new Scanner(System.in); //스캐너

		// 인풋
		System.out.println("급여계산 프로그램입니다.");
		System.out.println("근무시간을 입력하세요.");

		// 입력받은 값이 정수인지 확인하는 소스
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print("정수를 입력해주세요.");
		}

		hour = sc.nextInt();

		// 급여를 구하는 공식
		if (hour <= REG_HOURS) {
			totalPAY = hour * TIME_PAY;
		} else {
			totalPAY = REG_HOURS * TIME_PAY + (hour - REG_HOURS) * TIME_PAY * OVER_PAY_RATE;
		}

		// 아웃풋
		System.out.printf("급여는 %.2f원 입니다.", totalPAY);
		sc.close();
	}

}
