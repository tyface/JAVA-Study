package thread4;

public class ThreadTest {
	public static void main(String[] args) {
		// 생산자-소비자 문제 : 송급과잉과 소비과잉
		// wait(), notify()

		Buffer bf = new Buffer();
		Runnable pr = new Producer(bf);
		Runnable ct = new Customer(bf);

		Thread t1 = new Thread(pr);
		Thread t2 = new Thread(ct);

		t1.start();
		t2.start();
	}
}
