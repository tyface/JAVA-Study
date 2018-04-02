
public class BreakEx {
	public static void main(String[] args) {
		// break 연습
		// 반복문을 빠져 나올때 사용
		// 반복문의 조건식과 상관없이 반복문을 종료하고 싶은 때 사용
		// break를 만나면, 더이상 반복문을 실행하지 않고, 즉시 종료
		int i = 1;

		while (true) {
			System.out.println("i : " + i);

			if (i == 10) {
				break;
			}
			i++;
		}
	}
}
