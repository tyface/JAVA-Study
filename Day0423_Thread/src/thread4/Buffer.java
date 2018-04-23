package thread4;

public class Buffer {
	private int data;
	boolean isEmpty;

	public Buffer() {
		isEmpty = true;
	}

	public synchronized int get() {
		
		while (isEmpty == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isEmpty = true;
		notifyAll();
		return data;
	}

	public synchronized void put(int data) {

		while (isEmpty == false) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		this.data = data;
		isEmpty = false;
		notifyAll();
	}
}
