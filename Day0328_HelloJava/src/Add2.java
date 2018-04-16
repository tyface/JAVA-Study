import java.util.Scanner;

public class Add2 {

	public static void main(String[] args) {
		//숫자를 키보드로 입력받아서 더하기
		//입력받을 준비: Scanner 를 사용해야 한다.
		/* 
		 * 스캐너를 사용하기 위해서는 import를 사용하여야 한다
		*/
		
		//키보드로 부터 입력받을 준비
		Scanner scan = new Scanner(System.in);
		
		int a,b,sum; //정수를 저장할 변수 a,b,sum 선언
		

		System.out.println("첫번째 숫자 a를 입력하세요");
		a = scan.nextInt(); //키보드로 보투 숫자를 읽어와서 a에 대입
		System.out.println("두번째 숫자 b를 입력하세요");
		b = scan.nextInt(); //키보드로 보투 숫자를 읽어와서 b에 대입
		sum = a + b;

		System.out.println("a + b의 결과는 " + sum + "입니다.");
		scan.close();
	}

}
