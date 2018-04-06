
public class MethodEx2 {

	public static void main(String[] args) {
		// 메서드 만들기
		// 수식자는 public static
		// 이름은 add
		// 매개변수는 정수2개
		// 반환형은 정수
		// 반황값은 매개변수 2개를 더한 값

//		System.out.println(add(1, 2));
		System.out.println(mod(2, 2));
		
		
	}

	// 매개변수로 받은 정수값 2개를 더한후 출력
	public static int add(int num1, int num2) {
		return num1 + num2;
	}
	
	// 두정수를 입력 받아서 나머지 값을 반환하는 메서드 
	public static int mod(int num1, int num2) {
		return num1 % num2;
	}
}
