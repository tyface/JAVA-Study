package list;

public class ListTest {
	public static void main(String[] args) {
		MyList<Integer> ls = new MyList<Integer>();
		ls.add(1);
		ls.add(3);
		ls.add(5);
		ls.add(7);
		
		ls.remove(0);
		ls.remove(1);
		
		
		for(int i = 0; i < ls.size();i++) {
			System.out.println(ls.get(i));
		}
		System.out.println(ls.size());
	}
}
