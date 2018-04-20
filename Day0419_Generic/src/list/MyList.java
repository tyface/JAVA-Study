package list;

public class MyList<E> {

	private E[] arr; // 임의의 데이터타입 E를 담을 배열 변수

	public MyList() { // 기본생성자
		arr = (E[]) new Object[0];
	}

	public MyList(E[] e) { // 기본생성자
		arr = e;
	}

	public void add(E element) { // 데이터를 받아서 배열의 크기를 늘리고 해당 데이터를 삽입
		E[] tempArr = (E[]) new Object[arr.length + 1];

		for (int i = 0; i < arr.length; i++) {
			tempArr[i] = arr[i];
		}

		tempArr[tempArr.length - 1] = element;
		arr = tempArr;
		System.out.println("추가 완료");
	}

	public void remove(int index) { // 인덱스를 받아서 해당하는 인덱스의 값을 삭제
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

	public E get(int index) { // 인덱스를받아 해당하는 인덱스의 데이터를 반환
		return arr[index];
	}

	public void set(int index, E e) { // 배열의 인덱스테 데이터를 삽입
		if (index >= size()) {
			System.out.println("해당 인덱스가 존재하지 않습니다.");
			return;
		}
		arr[index] = e;
	}

	public int size() { // 배열의 길이를 반환
		return arr.length;
	}

}
