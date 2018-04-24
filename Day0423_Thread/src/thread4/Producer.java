package thread4;

public class Producer implements Runnable {
	private Buffer bf;
	private int data;

	public Producer(Buffer bf) {
		this.bf = bf;
	}

	public void run() {
		for (int i = 1; i <= 10; i++) {
			data = i;
			bf.put(data);
			System.out.println("생산자가 데이터 " + data + "를 생산하였습니다.");
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
