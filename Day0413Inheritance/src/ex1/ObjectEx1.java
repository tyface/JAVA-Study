package ex1;

public class ObjectEx1 {
	public static void main(String[] args) {
		// instanceof : 인스턴스가 어느 클래스의 객체인지 확인하는 연산자
		// (특히 부모클래스의 참조변수에 참조되어있는 객체가 어떤 자식클래스의 객체인지 확인할 때 사용)
		Car c1 = new SportsCar();
		Car c2 = new Bus();

		if (c1 instanceof Bus) {
			System.out.println("맞아요");
			Bus bus = (Bus) c2;
			bus.switchGate();
		} else if (c1 instanceof SportsCar) {
			System.out.println("아니에요!");
			SportsCar sc = (SportsCar) c1;
			sc.turboOff();
			sc.turboOn();
		}

	}
}
