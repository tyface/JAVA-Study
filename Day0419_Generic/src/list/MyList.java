package list;

public class MyList<E> {

	E[] arr;

	public MyList() {
		arr = (E[]) new Object[0];
	}

	public void add(E element) {
		E[] tempArr = (E[]) new Object[arr.length + 1];

		for (int i = 0; i < arr.length; i++) {
			tempArr[i] = arr[i];
		}

		tempArr[tempArr.length-1] = element;
		arr = tempArr;
		System.out.println("추가 완료");
	}

	public E get(int index) {
		return arr[index];
	}

	public void remove(int index) {
		E[] tempArr = (E[]) new Object[arr.length - 1];

		int tempIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i != index) {
				tempArr[tempIndex] = arr[i];
				tempIndex++;
			}
		}

		arr = tempArr;
		System.out.println("삭제되었습니다.");
	}

	public void set(int index, E element) {
		if (index >= size()) {
			System.out.println("해당 인덱스가 존재하지 않습니다.");
			return;
		}
		arr[index] = element;
	}

	public int size() {
		return arr.length;
	}

}
