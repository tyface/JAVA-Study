import java.util.Scanner;

public class Example2 {

	public static void main(String[] args) {

		int size; // 입력받을값의 개수
		double avg, temp2 , temp = 0,sum = 0; // 평균값
		int rs = 0; // 결과값

		// 스캐너
		Scanner sc = new Scanner(System.in);

		System.out.println("입력받을 숫자의 개수를 설정하시오 (홀수여야함)");

		size = sc.nextInt(); // TODO 홀수인지 검사하는 소스 작성하기

		int[] inputArr = new int[size]; // 입력받을 숫자들을 넣을 배열객체를 생성

		// 인풋
		for (int i = 0; i < inputArr.length; i++) {
			System.out.printf("가운데 값을구할 숫자를 %d개 입력해주세요. ", size);
			inputArr[i] = sc.nextInt();
			sum += inputArr[i];
		}

		/*
		 * 가운데값을 구하는 공식 : 
		 * 모든숫자들의 합의 평균을 구한후 그 편균값에서 입력받은 값을 뺄셈한 수가 
		 * 양수,음수 포함 0에 가장 가까운수가 가운대 값이다
		 */
		avg = sum / size;
		
		for (int i = 0; i < inputArr.length; i++) {
			temp2 = avg - inputArr[i];
			temp2 = 0 <= temp2 ? temp2 : -temp2;
			
			//최초에만 temp에 값을 집어넣은후 다음부터는 temp보다
			//0에 가까울경우에면 temp에 값을 넣는다
			if (i == 0) temp = temp2; 
			
			if (temp > temp2) {
				temp = temp2;
				rs = inputArr[i];
			}
			
		}

		//출력
		System.out.println("값은 : " + rs);

	}

}
