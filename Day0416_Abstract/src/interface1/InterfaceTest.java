package interface1;

public class InterfaceTest {

	public static void main(String[] args) {
		// 참조변수 선언 가능, 객체 생성이 안됨: 상속용으로만 사용
		Moveable m[] = new Moveable[2];
		
		m[0]= new Dog();
		m[1]= new Cat();

//		Animal[] animals = new Animal[2];
//
//		animals[0] = new Dog();
//		animals[1] = new Cat();

		
		for (Moveable e : m) {
			e.move();
		}

	}
}
