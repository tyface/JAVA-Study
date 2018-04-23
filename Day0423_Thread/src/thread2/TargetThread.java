package thread2;

public class TargetThread extends Thread{

	public void run() {
		for (long i = 0; i < 2000000000; i++) {
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
