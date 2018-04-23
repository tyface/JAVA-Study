package thread1;

public class ThreadTest3{
	public static void main(String[] args) {

		
		Runnable r = new MyRunnable();
		
		Thread thread1 = new Thread(r);
		thread1.start();

		for (int i = 0; i < 100; i++) {
			System.out.println("loopMain : " + i);
		}
		System.out.println("End");
	}
}
