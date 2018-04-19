package Generic1;

public class StoreTest {

	public static void main(String[] args) {
		Store s1 = new Store();
		s1.setDate(10);
		System.out.println("s1 : " + s1.getDate());
		

		Store s2 = new Store();
		s2.setDate("he");
		System.out.println("s2 : " + s2.getDate());
	}

}
