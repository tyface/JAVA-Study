
public class CarTest {
	public static void main(String[] args) {
		// 색깔, 현재속도, 주행거리의 상태갑을 가지고
		// 출발, 정지, 상태출력의 기능을 할 수 있는 객체 만들어보기
		// car객체를 만들어서 객체가 가지고 있는 출발, 정지, 상태출력기능을 호출
		Car myCar = new Car();
		myCar.color = "빨강";
		myCar.speed = 300;
		myCar.mileage = 2000;
	
		Car yourCar = new Car();
		yourCar.color = "검정";
		yourCar.speed = 150;
		yourCar.mileage = 250000;
		myCar.printCar();
		yourCar.printCar();
		
	}
}

class Car {
	String color;
	int speed;
	int mileage;

	public void start() {
		System.out.println("시동을 걸고 출발합니다.");
	}

	public void stop() {
		System.out.println("멈추고 시동을 끕니다.");
	}

	public void printCar() {
		System.out.printf("색깔은 %s \r\n최고속도는 %d \r\n주행거리는 %d 입니다.\r\n", color, speed, mileage);
	}

}