package linkedList;

public class NoteTest {
	public static void main(String[] args) {
		Node_JiSang n1 = new Node_JiSang("a");
		Node_JiSang n2 = new Node_JiSang("b");
		Node_JiSang n3 = new Node_JiSang("c");

		n1.setNext(n2);
		n1.next().setNext(n3);

		Node_JiSang current = n1;
		for (int i = 0; i < 3-1; i++) {
			System.out.println(current);
			current = current.next();
		}

	}
}
