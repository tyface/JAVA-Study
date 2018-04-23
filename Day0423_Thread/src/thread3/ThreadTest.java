package thread3;

public class ThreadTest {
	public static void main(String[] args) {
		BankAccount myAcc = new BankAccount();
		Runnable p1 = new User(myAcc);
		Runnable p2 = new User(myAcc);
		
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		t1.start();
		t2.start();
		
	}
}
