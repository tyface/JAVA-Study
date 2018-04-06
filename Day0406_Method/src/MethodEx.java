
public class MethodEx {

	public static void main(String[] args) {
		// a가 학교에 가는 프로그램을 작성
		System.out.println(goSchool("A"));
		
		
		System.out.println("DO something.");
		
	} // main end
	/*
	 * 메서드 모양 [수식자] 반환형 식별자([매개변수]) {
	 *  반환값;
	 *  }
	 * 
	 */

	public static void goSchoolA() {
		System.out.println("a가 일어난다.");
		System.out.println("a가 씻는다.");
		System.out.println("a가 밥을 먹는다.");
		System.out.println("a가 버스를 탄다.");
		System.out.println("a가 공부를 한다.");
		System.out.println("a가 귀가를 한다.");
		System.out.println("a가 씻고 잠을잔다.");
	}

	public static void goSchoolB() {
		System.out.println("b가 일어난다.");
		System.out.println("b가 씻는다.");
		System.out.println("b가 밥을 먹는다.");
		System.out.println("b가 버스를 탄다.");
		System.out.println("b가 공부를 한다.");
		System.out.println("b가 귀가를 한다.");
		System.out.println("b가 씻고 잠을잔다.");
	}
	
	public static int goSchool(String name) {
		System.out.println(name + "가 일어난다.");
		System.out.println(name + "가 씻는다.");
		System.out.println(name + "가 밥을 먹는다.");
		System.out.println(name + "가 버스를 탄다.");
		System.out.println(name + "가 공부를 한다.");
		System.out.println(name + "가 귀가를 한다.");
		System.out.println(name + "가 씻고 잠을잔다.");
		return 0;
	}

}
