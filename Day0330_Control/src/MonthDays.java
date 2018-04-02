import java.util.Scanner;

public class MonthDays {
	public static void main(String[] args) {
		// 달을 입력받아서 달의 일수를 구하는 프로그램을 작성하자
		// 연도를 입력하세요.
		// 예) 월을 입력하세요.
		int year, month;
		int days;
		boolean temp1,temp2;
		Scanner sc = new Scanner(System.in); // 스캐너

		System.out.println("연,월을 입력받아 해당 월의 일수를 구하는 프로그램입니다.");
		System.out.println("연도를 입력하세요.");

		// 입력받은 값이 정수인지 확인하는 소스
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print("정수를 입력해주세요.");
		}
		
		year = sc.nextInt();
		
		System.out.println("월을 입력하세요.");

		// 입력받은 값이 정수인지 확인하는 소스
		while (!sc.hasNextInt()) {
			sc.next();
			System.out.print("정수를 입력해주세요.");
		}
		
		month = sc.nextInt();

		switch (month) {
		case 2:
			temp1 = year % 4 == 0 && year % 100 != 0;
			temp2 = year % 400 == 0;
			
			if(temp1||temp2) {
				days = 29;
			}else {
				days = 28;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			days = 30;
			break;
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			days = 31;
			break;
		default:
			days = 0;
			System.out.println("오류발생");
			System.exit(0);
		}

		System.out.printf("%d년 %d월의 일수는 %d일 입니다.",year , month, days);

	}
}
