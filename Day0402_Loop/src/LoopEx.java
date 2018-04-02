
public class LoopEx {

	public static void main(String[] args) {
		// 반복문에 대해서 공부합니다.
		// 반복문은 특정한 문장을 여러번 반복해서 실행하고자 할때 사용

		// 반복문의 종류 : while, for, do while
		// while : 조건식이 만족할 때, 계속해서 문장을 반복해서 실행할 때 사용
		// for : 보통, 반복하고자 하는 횟수가 정해져 있을때 사용한다.
		// do while : while 과 동일하나, 최소 한 번은 실행할 때 사용

		// while(조건식) {
		// 문장;
		// }
		//
		// for() {
		// 문장;
		// }
		//
		// do {
		//
		// } while() {
		// 문장;
		// }
		
		int x = 1;

		while (x <= 10) {
			System.out.println("Hello! world!!" + x * 2);
			x++;
		}
		
		
	}

}
