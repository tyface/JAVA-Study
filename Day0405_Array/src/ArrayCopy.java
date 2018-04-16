
public class ArrayCopy {
	public static void main(String[] args) {
		// int num1 = 10;
		// int num2 = num1;
		//
		// System.out.println("num1 : " + num1);
		// System.out.println("num2 : " + num2);
		//
		// num2++; // num2를 증가시킴
		// System.out.println("num1 : " + num1);
		// System.out.println("num2 : " + num2);

		// int[] arr1 = { 1, 3, 5 };
		// int[] arr2 = arr1;
		// // 얕은 복사(shallow copy) : 주소값을 복사
		//
		// arr2[0]++;
		//
		// System.out.print("arr1 : ");
		// for (int e : arr1) {
		// System.out.print(e + " ");
		// }
		// System.out.print("\r\narr2 : ");
		// for (int e : arr2) {
		// System.out.print(e + " ");
		// }

		// 깊은 복사(deep copy) : 모든 원소를 하나 하나 복사
		// arr2 = new int[arr1.length];
		//
		// for (int i = 0; i < arr2.length; i++) {
		// arr2[i] = arr1[i];
		// }
		//
		// arr2[0]++;
		// System.out.print("\r\narr2 : ");
		// for (int e : arr2) {
		// System.out.print(e + " ");
		// }

		// 배열에서 값을 초기화 하면서 배열 생성하기
//		int[] arr1 = { 12, 20, 30, 1, 2, };
		// 2차원 배열에서 값을 초기화 하면서 배열 생성하기
		int[][] arr2 = {{02,3,4,5}, {23,5,6,32},{2,3,94,4}};
		
		for (int i = 0; i < arr2.length; i++) {
			for(int e : arr2[i]) {
				System.out.print(e + " ");
			}
			System.out.println();
		}
	}
}
