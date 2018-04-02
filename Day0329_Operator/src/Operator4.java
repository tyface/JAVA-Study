
public class Operator4 {

	public static void main(String[] args) {
		// 비트연산자
		// &(and), |(or), ^(xor), ~(not)
		// 비트단위 연산을 할 수 있게 만들어 주는 연산자
		/* &(and) : 둘다 1일때1
		 * |(or) : 둘 중 하나라도 1일 때 1
		 * ^(xor) : 중 중 하나만 1일 때 1
		 * ~(not) : 비트전환
		 */
		
		int x =2;
		int y = 6;
		int result;
		
		result = x & y;
		/*
		 *  0010
		 *  0110
		 *  ----
		 *  0010
		 */
		
		
		System.out.println("x&y : " + result);
		
		x=3;
		y=6;
		
		result = x | y;
		
		/*
		 *  0011
		 *  0110
		 *  ----
		 *  0111
		 */
		System.out.println("x&y : " + result);
		
		result = x ^ y;
		
		/*
		 *  0011
		 *  0110
		 *  ----
		 *  0101
		 */
		System.out.println("x&y : " + result);
		
		result = ~x;
		
		/* 2의 보수 방싯으로 음수를 표시 
		 */
		System.out.println("~x : " + result);

		System.out.println(Integer.toBinaryString(-1));
	}

}
