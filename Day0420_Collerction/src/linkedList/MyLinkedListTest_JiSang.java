package linkedList;

public class MyLinkedListTest_JiSang {

	public static void main(String[] args) {
		MyLinkedList_JiSang<Integer> my = new MyLinkedList_JiSang<>();
		
		my.add(1);
		my.add(4);
		
		my.remove(0);
		System.out.println(my);
	}

}
