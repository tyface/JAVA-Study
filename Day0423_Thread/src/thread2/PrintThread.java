package thread2;

public class PrintThread extends Thread{
	// 스레드의 상태값 받아오기 : getState
	TargetThread targetTrd;

	public PrintThread(TargetThread targetTrd) {
		this.targetTrd = targetTrd;
	}

	public void run() {
		while (true) {
			Thread.State state = targetTrd.getState();
			System.out.println("Target State : " + state);
			if (state == Thread.State.NEW) {
				targetTrd.start();
			} else if (state == Thread.State.TERMINATED) {
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
