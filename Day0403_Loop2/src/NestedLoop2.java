import java.util.Scanner;

public class NestedLoop2 {

	public static void main(String[] args) {
		// 계단모양 별찍기
		// *
		// **
		// ***
		// ****
		// *****
		// ******
		// 역계단 찍기
		//      *
		//     **
		//    ***
		//   ****
		//  *****
		// ******
		int count;
		Scanner sc = new Scanner(System.in);

		System.out.println("숫자를 입력해주세요.");
		
		count = sc.nextInt();
		
		//계단 찍기
		for (int i = 0; i < count; i++) {
			//별 출력
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		//역계단 찍기
		for (int i = 0; i < count; i++) {
			//빈공간 먼저 출력
			for(int j = i+1; j < count; j++) {
				System.out.print(" ");
			}
			//별 출력
			for(int j = 0; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		sc.close();
	}
}
