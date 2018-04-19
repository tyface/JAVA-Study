package Generic2;

public class StoreTest {

	public static void main(String[] args) {
		Store<Integer> s1 = new Store<Integer>();
		s1.setDate(10);
		System.out.println("s1 : " + s1.getDate());
		

		Store<String> s2 = new Store<String>();
		s2.setDate("he");
		System.out.println("s2 : " + s2.getDate());
		
		Store<?> s3 = new Store<String>() ;//와일드카드
		System.out.println("s3 : " + s3.getDate());

		
	}

}
