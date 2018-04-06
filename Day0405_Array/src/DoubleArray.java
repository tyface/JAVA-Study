
public class DoubleArray {

	public static void main(String[] args) {
		// 이차원배열 : 배열을 저장할 수 있는 배열
		int[] intArr = new int[3];

		// 크기 5인 정수형배열을 저장하는 크기 3인 배열
		// arr 정수형배열의 주소값을 저장하는 배열의 주소값을 저장하는 변수
		int[][] arr = new int[3][5];

		// System.out.println(arr.length);
		// System.out.println(arr[0].length);

		// arr[0], arr[1], arr[2] 는 정수형 배열의 주소값을 저장하는 참조변수

		// arr[0][0] ... 은 정수형 변수

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}

	}

}
