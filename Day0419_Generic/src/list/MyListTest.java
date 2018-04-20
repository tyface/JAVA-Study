package list;

public class MyListTest {
	public static void main(String[] args) {
		MyList<String> ls = new MyList<String>();
		ls.add("하나");
		ls.add("둘");
		ls.add("셋");
		ls.add("넷");
		ls.add("다섯");
		
		ls.remove(4);
		
		
		for(int i = 0; i < ls.size();i++) {
			System.out.println(ls.get(i));
		}
	}
}
