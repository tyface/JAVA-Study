
public class LoopEx1 {
	public static void main(String[] args) {
		//예제 1부터 10까지의 합을 출력하는 프로그램을 작성하라
		//단, while 문장을 사용하시오
		
		final int MIN_NUM = 1;
		final int MAX_NUM = 10;
		int num = MIN_NUM;
		int rs = 0;
		
		while ( num <= MAX_NUM) {
			rs += num++;
		}
		
		System.out.printf("숫자 %d부터 %d까지의 합은 %d입니다.",MIN_NUM,MAX_NUM,rs);
	}
}
