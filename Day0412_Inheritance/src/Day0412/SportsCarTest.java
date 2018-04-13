package Day0412;

public class SportsCarTest {
	public static void main(String[] args) {
		SportsCar myCar = new SportsCar();
		Car c = new SportsCar();
		SportsCar c2 = (SportsCar)c;
		System.out.println(c2.isTurbo);
	}
}
