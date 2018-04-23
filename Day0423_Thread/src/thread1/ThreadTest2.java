package thread1;

public class ThreadTest2{
	public static void main(String[] args) {

		MyThread thread1 = new MyThread();
		thread1.start();

		for (int i = 0; i < 100; i++) {
			System.out.println("loopMain : " + i);
		}
		System.out.println("End");
	}
}
