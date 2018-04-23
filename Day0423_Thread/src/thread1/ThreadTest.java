package thread1;

public class ThreadTest extends Thread {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println("loop : " + i);
		}
		for (int i = 0; i < 100; i++) {
			System.out.println("loop2 : " + i);
		}
		System.out.println("End");
	}
}
