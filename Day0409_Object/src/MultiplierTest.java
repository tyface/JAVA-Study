
public class MultiplierTest {
	public static void main(String[] args) {
		// 결과를 저장하는 변수 : result
		// 동작 : 출력x , 매개변수로 전달받은 두정수를 곱해서 결과를 result에 저장하고,
		// 결과를 반환 하는 메서드를 작성 multiply()
		//
		// test main에서 해야할일
		// Multiplier 객체 만들고 multiply() 실행해보기

		Multiplier mtp = new Multiplier(1);

		System.out.println(mtp.multiply(2.5, 2));
	}
}

class Multiplier {
	public Multiplier(int number) {
		System.out.println("기본생성자입니다.");
		result = number;
	}

	int result;
	double rsDouble;

	public double multiply(int num1, double num2) {
		rsDouble = num1 * num2;
		System.out.println("22");
		return rsDouble;
	}

	public double multiply(double num1, int num2) {
		rsDouble = num1 * num2;
		System.out.println("11");
		return rsDouble;
	}

}