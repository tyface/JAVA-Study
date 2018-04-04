
public class BreakEx {

	public static void main(String[] args) {
		// break- continue
		// break : 반복문을 반복문의 조건문과 상관없이 빠져 나올때 사용
		// continue : 해당 반복 순서의 문장을 더이상 실행하지 않고, 다음 반복문으로 넘어갈때 사용
		
		for (int i = 1; i<=10; i++) {
			
			if(i%5 == 0) {
				break;
			}
			System.out.println("i = "+ i);
		}
		
		
		
	}

}
