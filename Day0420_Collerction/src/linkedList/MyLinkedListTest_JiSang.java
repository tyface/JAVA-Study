package linkedList;

public class MyLinkedListTest_JiSang {

	public static void main(String[] args) {
		MyLinkedList_JiSang my = new MyLinkedList_JiSang();
		
		my.add("하나");
		my.add("둘");
		my.add("셋");
		my.add("넷");
		my.set(1,"다섯");
		
		my.remove(1);
		my.remove(1);
		my.remove(1);
		my.remove(2);
		
		System.out.println(my.toString());
	}

}
