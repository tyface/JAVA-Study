import java.util.Scanner;

public class CircleTest2_유지상 {
	public static void main(String[] args) {
		// 사용자로부터 다수의 원의 반지름과 중심정의 좌표를 입력받아서
		// 출력하는 프로그램을 작성하라

		// 입출력예) 저장할 원의 개수를 입력하세요
		// 3
		// 원의 반지름을 입력하세요
		// 10
		// // 원의 x좌표를 입력하세요
		// 4
		// // 원의 y표를 입력하세요
		// 4

		// 원1의 반지름은 3, 넚이는 xxx.xx 줌심좌표는 3,5 입니다.
		// 배열에다가 Circle을 저장해서 출력하기

		int num; // 원의 개수를 저장할 변수

		Scanner sc = new Scanner(System.in); // 스캐너

		System.out.println("저장할 원의 개수를 입력하세요.");
		num = sc.nextInt();

		Circle_유지상[] circles = new Circle_유지상[num]; // 입력받은 개수의 크기만큼 원을 담을 배열 생성

		//사용자에게 입력받은 숫자만큼 Circle객체를 만드는 반복문
		for (int i = 0; i < num; i++) {
			int radius, x, y; //원의 반지름, x축, y축을 저장할 변수 생성

			System.out.println("원의 반지름을 입력하세요."); 
			radius = sc.nextInt();
			System.out.println("원의 x좌표를 입력하세요.");
			x = sc.nextInt();
			System.out.println("원의 y좌표를 입력하세요.");
			y = sc.nextInt();

			circles[i] = new Circle_유지상(x, y, radius); //입력받은 데이터를 토대로 Circler객체를 만든후 배열에 저장
		}

		//Circle배열 객체에있는 Circle객체들의 정보를 출력하는 반복문
		for (int i = 0; i < circles.length; i++) { 
			int radius = circles[i].getRadius();
			int x = circles[i].getCenter().getX();
			int y = circles[i].getCenter().getY();
			double area = circles[i].getArea(radius);
			
			System.out.printf("원 %d의 반지름은 %d, 넚이는 %.2f 중심좌표는 %d,%d 입니다.\r\n",
					i + 1, radius, area, x, y);
		}
		sc.close();
	}
}
