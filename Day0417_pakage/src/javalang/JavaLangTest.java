package javalang;

import static java.lang.Math.*;

public class JavaLangTest {
	public static void main(String[] args) {
		System.out.println("큰값 : " + Math.max(3, 5));
		System.out.println("작은 값은 : " + min(4, 5));
		System.out.println("4의 제곱 : " + pow(4, 2));
		System.out.println("4의 제곱근 : " + sqrt(4));
		System.out.println("PI : " + PI);
		System.out.println("4의 절대값 : " + abs(-4));
		int x = 5;
		Integer numbur = new Integer(5);

		numbur.parseInt("123"); // 문자열을 숫자로 바꿈
	}
}
