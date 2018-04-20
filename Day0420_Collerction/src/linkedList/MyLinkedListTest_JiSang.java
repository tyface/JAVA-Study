package linkedList;

public class MyLinkedListTest_JiSang {

	public static void main(String[] args) {
		MyLinkedList_JiSang my = new MyLinkedList_JiSang();
		
		my.add("1");
		my.add("2");
		my.add("3");
		my.add("4");
		my.set(1,"5");
		System.out.println(my.toString());
		
		my.remove(1);
		
		System.out.println(my.toString());
	}

}
