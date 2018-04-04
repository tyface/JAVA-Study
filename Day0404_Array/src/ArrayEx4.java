import java.util.Scanner;

public class ArrayEx4 {
	public static void main(String[] args) {
		// 사용자에게 10개의 정수를 입력받아서
		// 배열에 저장해서
		// 짝수번째 입력받은 수의 합과
		// 홀수번째 입력받은 수의 합을 각각 출력하시오

		int[] arr = new int[10]; // 10개의 정수를 저장할수 있는 배열 선언
		int odd = 0, even = 0; // 홀수와 짝수의 합을 입력할 변수 선언
		Scanner sc = new Scanner(System.in); // 스캐너

		System.out.println("10개의 정수를 입력하시오."); // 출력

		for (int i = 0; i < arr.length; i++) { // arr배열에 입력받은 값을 저장
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < arr.length; i++) { //배열의 홀수번째는 odd에 짝수번째는 even에 저장
			if (i % 2 == 0) {
				odd += arr[i];
			} else if (i % 2 != 0) {
				even += arr[i];
			}
		}

		System.out.printf("odd : %d\r\neven : %d", odd, even);
		sc.close();
	}
}
