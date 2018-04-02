
public class Literal {

	public static void main(String[] args) {
		// Literal(상수, 값)에 대해서 공부합니다.
		/* 정수를 표현할때 주로 10진수를 사용하지만, 8진수나, 16진수, 2진수도 사용할수있다
		 */

		int decimal; //10진수를 저장할 변수
		int octal; //8진수를 저장할 변수
		int hexaDecimal; //16진수를 저장할 변수
		int binary; //2진수를 저장할 변수
		
		decimal = 14; //10진수 14를 변수에저장
		octal = 016; //8진수 14를 변수에저장
		hexaDecimal = 0xe; //16진수 14를 변수에저장
		binary = 0b1110; //2진수 14를 변수에저장
		
		System.out.printf("decimal : %d \n", decimal);
		System.out.printf("octal : %d \n", octal);
		System.out.printf("hexaDecimal : %d \n", hexaDecimal);
		System.out.printf("binary : %d \n", binary);
		
		//문자열을 저장할 수 있는 자료형
		String octaStr,hexaStr,binaryStr;
		
		//Integer 정수와 관련된 기능을 만들어 놓은 클래스
		octaStr = Integer.toOctalString(14);
		hexaStr = Integer.toHexString(14);
		binaryStr = Integer.toBinaryString(14);
		
		System.out.println(octaStr);
		System.out.println(hexaStr);
		System.out.println(binaryStr);
		
	}

}
