
public class CarTest {

	public static void main(String[] args) {
		// 상태값 : 색깔, 현재속도, 주행거리
		// 동작 : speedUp() : 현재속도를 5증가 시킨다
		// speedDown() : 현재속도를 5감소 시킨다.
		// printCar() : 현재 상태값 출력
		//
		// 생성자 : 기본: 색:빨강, 현재속도:0, 주행거리:0
		// 색깔, 현제속도, 주행거리를 매개변수로 전달받아서 멤버변수로 초기화하는생성자.

		Car car = new Car();
		car.speedUp();
		car.speedUp();
		car.speedUp();

		car.setColor("파랑");
		car.setSpeed(200);
		car.printCar();
		
		System.out.println(car);
	}

}
