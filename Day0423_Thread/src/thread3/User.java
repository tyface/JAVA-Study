package thread3;

public class User implements Runnable {
	BankAccount ac;

	public User(BankAccount ac) {
		this.ac = ac;
	}

	public void run() {
		
		for (int i = 0; i < 50; i++) {
			ac.deposit(10000);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ac.withdraw(10000);
			
			System.out.println(ac.getBalance());
			
		}

	}
}
