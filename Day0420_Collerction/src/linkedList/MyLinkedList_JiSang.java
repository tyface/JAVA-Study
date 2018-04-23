package linkedList;

public class MyLinkedList_JiSang<E> {
	// 가져야할값:
	// Node에 대이터를 저장할건데..
	// 첫번째 노드만 저장하고 있으면 연결되어있는 모든 노드들에 접근가능
	// 데이터가 몇개있는지를 알아야 함 : size
	// remove(int index), get(int index), size(), add(String data), set(int index,
	// String data)
	private int size;
	private Node_JiSang<E> head;

	public MyLinkedList_JiSang() {
		this.size = 0;
		this.head = null;
	}

	public MyLinkedList_JiSang(int size, Node_JiSang<E> head) {
		this.size = size;
		this.head = head;
	}

	public void add(E e) { // 노드 추가
		Node_JiSang<E> newNode = new Node_JiSang<E>(e);
		if (head == null) {
			head = newNode;
		} else {
			getTail().setNext(newNode);
		}
		size++;
	}

	public Node_JiSang<E> get(int index) { // 노드 가져오기
		Node_JiSang<E> node = head;
		if (index < 0 || index >= size) { // 인덱스 유효성 검사
			System.out.println("해당하는 인덱스가 존재하지 않습니다.");
			return null;
		}

		for (int i = 1; i < index; i++) { // 해당하는 인덱스의 노드 찾기
			node = node.next();
		}
		return node;
	}

	public void set(int index, E date) { // 노드 변경

		if (get(index) == null) {
			return;
		}
		get(index).setData(date);
	}

	public Node_JiSang<E> getTail() { // 마지막 노드 가져오기
		// Node_JiSang tail = head;
		// while (tail.next() != null) {
		// tail = tail.next();
		// }
		return get(size - 1);
	}

	public void remove(int index) { // 노드 삭제

		if (index == 0) { // 첫번째인덱스(헤드) 삭제시 다음값을 헤더에 삽입
			head = head.next();
		} else if (get(index) == null) { // 인덱스 유효성 검사
			return;
		} else { // 해당 인덱스의 전의 노드를 다음노드와 연결
			get(index - 1).setNext(get(index).next());
		}
		size--;
	}

	public int size() { // 저장된 노드의 개수를 반환
		return size;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node_JiSang<E> cur = head;

		for (int i = 0; i < size; i++) {
			sb.append(cur.getData()).append(" ");
			cur = cur.next();
		}
		String result = sb.toString();
		return result;
	}
}
