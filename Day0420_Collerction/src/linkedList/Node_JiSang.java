package linkedList;

public class Node_JiSang {
	private String data;
	private Node_JiSang next;

	public Node_JiSang() {
		super();
		this.data = new String();
	}

	public Node_JiSang(String data) {
		this.data = data;
	}

	public Node_JiSang(String data, Node_JiSang next) {
		super();
		this.data = data;
		this.next = next;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node_JiSang next() {
		return next;
	}
	
	public void setNext(Node_JiSang next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return data + " ";
	}

}
