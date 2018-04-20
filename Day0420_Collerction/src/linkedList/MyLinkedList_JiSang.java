package linkedList;

public class MyLinkedList_JiSang {
	// 가져야할값:
	// Node에 대이터를 저장할건데..
	// 첫번째 노드만 저장하고 있으면 연결되어있는 모든 노드들에 접근가능
	// 데이터가 몇개있는지를 알아야 함 : size
	// remove(int index), get(int index), size(), add(String data), set(int index,
	// String data)
	private int size;
	private Node_JiSang head;

	public MyLinkedList_JiSang() {
		super();
		this.size = 0;
		this.head = null;
	}

	public MyLinkedList_JiSang(int size, Node_JiSang head) {
		super();
		this.size = size;
		this.head = head;
	}

	public void add(String str) {
		Node_JiSang newNode = new Node_JiSang(str);

		if (head == null) {
			head = newNode;
		} else {
			getTail().setNext(newNode);
		}
		size++;
	}

	public void remove(int index) {

		if (index == 1) {
			head = head.next();
		} else if (index > size) {
			System.out.println("해당하는 인덱스가 존재하지 않습니다.");
			return;
		} else {
			get(index - 1).setNext(get(index).next());
		}
		size--;
	}

	public void set(int index,String date) {
		get(index).setData(date);
		
	}
	public Node_JiSang get(int index) {
		Node_JiSang node = head;

		for (int i = 1; i < index; i++) {
			node = node.next();
		}
		return node;
	}

	public Node_JiSang getTail() {
		// Node_JiSang tail = head;
		// while(tail.next() != null) {
		// tail = tail.next();
		// }
		return get(size);
	}

	public int size() {
		return size;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		Node_JiSang cur = head;
		for (int i = 0; i < size; i++) {
			sb.append(cur.getData()).append(" ");
			cur = cur.next();
		}
		String result = sb.toString();
		return result;
	}
}
