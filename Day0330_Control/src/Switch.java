
public class Switch {
	public static void main(String[] args) {
		/* if-else 문과 마찬가지로 선택 제어문 중 하나이다
		 * if-else는 조건문을 검사하는데 반하여, switch는
		 * 변수의 상태값에 따른 선택
		 * 
		 * switch () {
		 * case 값 : 
		 * 	문장;
		 * 	break;
		 * case 값 : 
		 * 	문장;
		 * 	break;
		 * case 값 : 
		 * 	문장;
		 * 	break;
		 * default : 
		 * 	문장;
		 * }
		 */
		
		int num = 2;
		
		switch (num) {
		case 0:
			System.out.println("num은 0입니다.");
			break;
		case 1:
			System.out.println("num은 1입니다.");
			break;
		case 2:
			System.out.println("num은 2입니다.");
			break;
		default:
			System.out.println("num은 0,1,2가 아닙니다.");
		}

	}
}
