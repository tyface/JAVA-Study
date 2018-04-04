import java.util.Arrays;

public class ArrayEx {
	public static void main(String[] args) {
		// 배열(Array)에 대해서 공부합니다.
		// 배열은 같은 데이터타입 변수의 모임이다

		// int s1, s2, s3;
		// s1 = 100;
		// s2 = 90;
		// s3 = 80;

		// 정수형 데이터 3개를 저장할 수 있는 배열 생성하기
		// 1. 배열의 주소를 저장할 수 있는 참조 변수 만들기
		// 	만들 배열의 종류는 정수형 배열
		
		int[] array = new int[3];
		array[0] = 1;
		array[1] = 2;
		array[2] = 3;
		
		for (int i = 0 ; i < array.length ; i++) {
			System.out.println(array[i]);
		}
	}
}
