
public class Account {
	// 입금과 출금 기능이 있고, 잔고를 저장할 수 있다.
	// 잔고 조회 기능이 있다.

	private int balance;

	public void deposit(int amount) throws NagativeNumberException {

		if (amount < 0) {
			throw new NagativeNumberException();
		}
		balance += amount;
	}

	public void withdraw(int amount) throws NagativeNumberException {

		if (amount < 0) {
			throw new NagativeNumberException();
		}
		balance -= amount;
	}

	public void showBalance() {

		System.out.println("잔고는 : " + balance);
	}

}
