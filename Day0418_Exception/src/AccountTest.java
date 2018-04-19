
public class AccountTest {
	public static void main(String[] args) {
		
		Account ac = new Account();
		try {
			ac.deposit(100000);
			ac.withdraw(200000);
		}catch(Exception e) {
			e.toString();
		}
		ac.showBalance();
		
		
	}
}
