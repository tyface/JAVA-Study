
public class ScoreTest {

	public static void main(String[] args) {
		Score sc = new Score();
		
		
		sc.showTotal();
		try {
			sc.setTotal(4);
		}catch (OddNumberException e) {
			System.out.println(e);
		}
		sc.showTotal();
	}

}
