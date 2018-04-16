import java.util.Random;
import java.util.Scanner;

public class Dice {
	public static void main(String[] args) {
		// 주사위 프로그램 만들기 (1~6까지 랜덤하게 숫자 생성해서 보여주기)
		// 랜덤숫자 생성방법 : Math클래스 나 Random 클래스 이용하기
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		int dice;
		String srs;

		// 인풋
		System.out.println("주사위 프로그램입니다.");
		System.out.println("Enter키를 눌러 주사위를 굴려주세요");

		// 입력받은 값이 정수인지 확인하는 소스

		//Math클래스 와 Random 클래스 두가지 사용법
		//dice = ran.nextInt(6) + 1;
		dice = (int)(Math.random() * 6) + 1;
		
		switch (dice) {

		case 1:
			System.out.println("주사위 값은 1입니다.");
			break;
		case 2:
			System.out.println("주사위 값은 2입니다.");
			break;
		case 3:
			System.out.println("주사위 값은 3입니다.");
			break;
		case 4:
			System.out.println("주사위 값은 4입니다.");
			break;
		case 5:
			System.out.println("주사위 값은 5입니다.");
			break;
		case 6:
			System.out.println("주사위 값은 6입니다.");
			break;
		default :
			System.out.println("오류가 발생하였습니다.");
		}
		sc.close();
	}
}
