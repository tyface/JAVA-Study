
public class NestedLoop {
	public static void main(String[] args) {
		//
		
		//세로 출력
//		for (int i = 2; i <= 9; i++) { 
//			for (int j = 1; j <= 9; j++) {
//				System.out.printf("%d X %d = %d\n",i,j,i*j);
//			}
//				System.out.println("");
//		}
		
		//가로 출력
		for (int i = 1; i <= 9; i++) { 
			for (int j = 2; j <= 9; j++) {
				System.out.printf("%d X %d = %d	", j, i, i * j);
			}
			System.out.println("");
		}
	}
}
