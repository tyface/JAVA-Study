package thread1;

public class ThreadTest4 {
	public static void main(String[] args) {

		// Runnable r1 = new Runnable() {
		// @Override
		// public void run() {
		// for (int i = 10; i > 0; i--) {
		// System.out.println("loopRunnable : " + i);
		// }
		// }
		// };

		// 인터페이스나, 추상클래스의 추상매서드가 하나 뿐일 때 람다 식을 이용할 수 있음
		Runnable r1 = () -> {
			for (int i = 10; i > 0; i--) {
				System.out.println("loopRunnable : " + i);
			}
		};
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r1);
		Thread t3 = new Thread(r1);
		t1.start();
		t2.start();
		t3.start();
		System.out.println("End");
	}
}
