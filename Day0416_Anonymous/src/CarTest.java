
public class CarTest {
	public static void main(String[] args) {

		// Tire koreaTire = new KoreaTire();

		// Tire chinaTire = new Tire() {
		// public void roll() {
		// System.out.println("중국타이어 굴러가다 터집니다.");
		// }
		// };
//		Car car = new Car(new Tire() {
//			public void roll() {
//				System.out.println("중국타이어 굴러가다 터집니다.");
//			}
//		});
		Car car = new Car(() -> {
			System.out.println("중국타이어 굴러가다 터집니다.");
		}, () -> {
			System.out.println("test 굴러가다 터집니다.");
		});
		

	car.drive();
	car.test();

}}
