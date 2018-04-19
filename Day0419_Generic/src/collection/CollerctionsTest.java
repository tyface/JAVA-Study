package collection;

import java.util.ArrayList;

public class CollerctionsTest {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		
		list.add("Hello");
		list.add("world");
		list.add("!!");
		
		for(String e : list) {
			System.out.println(e);
		}
		
		for (int i = 0; i < list.size(); i++) {
			String str = list.get(i);
			System.out.print(str + " ");
		}
	}
}
