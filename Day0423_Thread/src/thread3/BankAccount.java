package thread3;

public class BankAccount {
	private int balance;
	
	public synchronized void deposit(int amount) {
		balance += amount;
	}
	
	public synchronized void withdraw(int amount) {
		balance -= amount;
	}

	public synchronized int getBalance() {
		return balance;
	}
	
}
