
public class ExceptionTest {
	public static void main(String[] args) {
		int x = 1;
		int y = 0;
		int result = 0;
		try {
			 result = x / y;
		
		} catch (ArithmeticException|ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 처리");
		} catch(Exception a) {
			System.out.println("11");
		}

		System.out.println(result);
	}

}
