
public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = { 3, 5, 4, 1, 2, 12, 4, 167,345,23416,166,34,43, 6, 47, 58, 33 }; // 정렬할 정수들은 배열에 저장

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp; // 정수의 자리를 바꿀때 사용할 임시변수
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		// 출력
		for (int e : arr) {
			System.out.print(e + " ");
		}
	}

}
