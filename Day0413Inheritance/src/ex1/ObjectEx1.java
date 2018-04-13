package ex1;

public class ObjectEx1 {
	public static void main(String[] args) {
		Car c1 = new SportsCar();
		Car c2 = new Bus();
		
		SportsCar sc = (SportsCar)c2;
		sc.turboOff();
		sc.turboOn();
		
		System.out.println(sc);
	}
}
