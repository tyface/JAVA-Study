
// 원하는 구구단의 범위를 입력받아 해당 구간의 구구단을 출력하는 프로그램을 작성하시오.
//
//
// <처리조건>
// (1) 구간의 처음과 끝을 입력받는다.
// (2) 입력된 구간은 반드시 처음 입력 값이 끝의 입력 값보다 작아야 하는 것은 아니다. 즉 입력된 구간의 범위는 증가하거나 감소하는 순서
// 그대로 출력되어야 한다.
//
//
// 구구단의 시작 범위 s,와 끝 범위 e를 입력받는다. (s와 e는 2부터 9사이의 정수)
// 하나의 결과가 출력되면 프로그램을 종료한다.
//
//
// 시작 범위와 끝 범위사이의 구구단을 출력하되 모든 값과 부호 사이는 공백으로 구분하여 아래 출력 예와 같이 줄을 맞추어 출력해야 한다.
// 구구단 사이는 3개의 공백으로 구분한다. 데이터의 크기가 주어진 범위를 벗어날 경우는 "INPUT ERROR!"를 출력하고 s와 e를 다시
// 입력받는다.
import java.util.Scanner;		//스캐너 임포트

public class Jungol1291 {
	public static void main(String[] args) {
		int s, e;		//시작값과 끝값을 받을 변수

		Scanner sc = new Scanner(System.in);	//스캐너 생성

		while (true) {	//인풋과 동시에 유효성 검사
			System.out.println("구구단의 시작값과 끝값을 입력해주세요.");
			s = sc.nextInt();	//시작값 인풋
			e = sc.nextInt();	//끝값 인풋
			
			if (s < 2 || s > 9 || e < 2 || e > 9) {		//유효성 검사_(s와 e는 2부터 9사이의 정수)
				System.out.println("INPUT ERROR!");		//유효성이 맞지 않다면 에러메세지 표출후 반복
				continue;
			} 
			break;				//입력받은 값이 문제가없다면 다음 진행
		}

		int tempStartNum = s;		//시작값을 임의의 변수에 삽입
		for (int i = 1; i <= 9; i++) {
			s = tempStartNum;		//반복될때마다 변수 s값을 입력받은 초기값으로 초기화
			
			//시작값이 끝값과 다르다면 같아지기 전까지 늘어나거나 줄어들면서 구구단의 1단부터 출력
			while (s != e) {
				System.out.printf("%d * %d = %2d   ", s, i, s * i);
				if (s < e) {
					s++;
				} else if (s > e) {
					s--;
				}
			}
			
			//시작값과 끝값이 같아지면 마지막으로 출력하고 다음단 ex) 2단 출력으로 넘어감
			if (s == e) {
				System.out.printf("%d * %d = %2d   \n", s, i, s * i);
			}
		}
		sc.close();		//스캐너 종료
	}
}
