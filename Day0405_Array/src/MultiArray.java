
public class MultiArray {
	public static void main(String[] args) {
		// 정수5개를 저장할 수 있는 배열 a 선언 및 생성
		// 정수형 배열 5개를 저장할 수 있는 배열 b 선언 및 생성
		// 크기 4인 정수형 배열 6개를 저장하는 배열 c선언 및 생성
		
		int[] a = new int[6];
//		int[][] b = new int[5][];
		int[][] c = new int[6][4];
		
//		double[][] d = new double[1][];
		c[0] = a;
		a[0] = 10;
		for(int i = 0; i<c.length;i++) {
			for (int e : c[i]) {
				System.out.println(e);
			}

		}
	}
}
