package thread1;

public class Horse extends Thread {
	private String name;

	public Horse(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		int sum = 0;
		while (sum < 50) {
			int temp = (int) (Math.random() * 5) + 1;
			sum += temp;

			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " : " + sum);

		}

	}
}
