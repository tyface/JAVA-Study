
public class AnonymousTest {
	public static void main(String[] args) {
		//객체를 사용하기 위해서 필요한 것
		//객체를 참조할 참조 변수, 객체
		//참조변수를 만드는 방법 
		//클래스의이름 변수이름; ex) Car myCar;
		//익명클래스는  이름이 없음 >> 참조변수를 만들 수 없음
		//항상 부모클래스의 참조변수에 참조되어서 사용됨
		//익명클래스를 만드는 방법
		Car myCar = new Car() {
			boolean isTurbo;
			public void turboOn() {
				System.out.println("터보 온!!");
			}
			public void method1() {
				System.out.println("이거 부를수 있나요??");
			}
			public void speedUp() {
				turboOn();
				isTurbo = true;
				super.speedUp();
			}
		};
		//실제로는 인터페이스나, abstract 클래스 구현에 많이 사용됨
	  //////////////////////////////////////	
		myCar.speedUp();
		
	}
}
