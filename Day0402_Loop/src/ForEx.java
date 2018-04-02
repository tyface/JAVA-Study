
public class ForEx {
	public static void main(String[] args) {
		// 반복문 for를 실습
		//
		// for(초기화;조건신;증감식) {
		// 문장;
		// }
		//
		// 1.초기화는 최초 한 번만 실행
		// 2.조건식이 참이면 문장을 실행
		// 3.문장을 실행하고 난뒤 증감식이 실행됨
		// 4.증감식 실행뒤, 조건식을 다시 검사
		// 5.조건식이 참이면, 2~4를 반복, 거짓이면 for문 종료

		int x = 1;

		while (x <= 10) {
			System.out.println(x);
			x++;
		}

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}

	}
}
