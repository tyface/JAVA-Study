
public class SelectionSort {

	public static void main(String[] args) {
		// 배열 오름차순 정렬 하기

		int[] arr = { 3, 5, 4, 1, 2, 12, 4, 167, 345, 23416, 166, 34, 43, 6, 47, 58, 33 }; // 정렬할 정수들은 배열에 저장

		// 오름차순 정렬을 시작하는 반복문_(배열의 크기) -1 만큼 반복
		for (int i = 0; i < arr.length - 1; i++) {
			// 상위 반복문에 인덱스에 해당하는 정수와 나머지 수들을 한번씩 비교하기위한 반복문
			for (int j = i + 1; j < arr.length; j++) {
				// 이번 반복회차의 인덱스에 저장되어있는 정수보다 작은수가 있다면 그 두정수의 값을 서로 바꾸는 소스
				if (arr[i] > arr[j]) {
					int temp; // 정수의 자리를 바꿀때 사용할 임시변수
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		} // for end

		// 출력
		for (int e : arr) {
			System.out.print(e + " ");
		}
	}

}
