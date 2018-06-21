package di01;

public class Driver {
	public static void main(String[] args) {
		Car car = new Car();
		
//		KoreaTire tire = new KoreaTire("굴러갑니다.");
//		ChinaTire tire = new ChinaTire();
		Tire tire = new ChinaTire();
		
		car.setTire(tire);
		car.drive();
		
	}
}
