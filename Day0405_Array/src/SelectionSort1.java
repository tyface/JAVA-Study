
public class SelectionSort1 {

	public static void main(String[] args) {
		// 배열 오름차순 정렬 하기

		int[] arr = { 3, 5, 4, 2, 6, 12, 1, 167, 345, 23416, 166, 34, 43, 6, 47, 58, 33 }; // 정렬할 정수들은 배열에 저장
		
		// 오름차순 정렬을 시작하는 반복문_(배열의 크기) -1 만큼 반복
		for (int i = 0; i < arr.length - 1; i++) {
			int minIndex, temp;
			minIndex = i;
			// 상위 반복문에 인덱스에 해당하는 정수와 나머지 수들을 한번씩 비교하기위한 반복문
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[minIndex] > arr[j]) {
					minIndex = j;
				}
			}
			temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;
		}

		// 출력
		for (int e : arr) {
			System.out.print(e + " ");
		}
	}

}
