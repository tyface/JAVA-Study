package linkedList;

public class Node_JiSang<E> {
	private E data;
	private Node_JiSang<E> next;

	public Node_JiSang() {
		super();
		this.data = (E)new Object();
		this.next = null;
	}

	public Node_JiSang(E data) {
		this.data = data;
		this.next = null;
	}

	public Node_JiSang(E data, Node_JiSang<E> next) {
		super();
		this.data = data;
		this.next = next;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public Node_JiSang<E> next() {
		return next;
	}

	public void setNext(Node_JiSang<E> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return data + " ";
	}

}
