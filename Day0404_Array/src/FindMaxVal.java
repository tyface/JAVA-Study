
public class FindMaxVal {

	public static void main(String[] args) {
		// 1.{77,50,64,100,25} 형태의 임의의 숫자 5개로 초기화된 정수형 배열을 생성
		// 2.해당 배열에서 가장 큰 숫자를 찾아서 화면에 출력

		int[] arr = { -77, -50, -64, -100, -25 }; // 임의의 숫자 5개 생성
		int maxNum; // 가장큰 숫자를 저장할 변수

		maxNum = arr[0]; // arr 값중 임의의 값을 넣어 초기화
		
		for (int e : arr) { // 배열 반복

			if (e > maxNum) { // 배열의 원소와 maxNum를 비교하여 현제 원소값이 크다면 maxNum에 저장
				maxNum = e;
			}
		}

		System.out.printf("가장 큰 숫자는 %d입니다.", maxNum); // 출력
	}

}
