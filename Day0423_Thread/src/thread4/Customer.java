package thread4;

public class Customer implements Runnable {
	private Buffer bf;
	private int data;

	public Customer(Buffer bf) {
		this.bf = bf;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			data = bf.get();
			System.out.println("소비자가 데이터 " + data + "를 소비하였습니다.");

			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
