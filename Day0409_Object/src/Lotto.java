import java.util.Random;

public class Lotto {
	// 1~45사이의 중복되지 않는 6개의 수를 생성하는 Lotto 클래스 생성
	// 상태값은 생성된 로또 번호를 저장할 수 있는 크기6인 정수형 배열 lotto[]
	// 기능은
	// 1-랜덤한 숫자를 만들어 내는 makeNumber()
	// 2-만들어진 배열을 정렬하는 sort()
	// 3-만들어진 배열을 출력하는 printLotto()
	// 생성자는 배열을 받아서 lotto에 넣어줄수 있는 생성자1
	// 기본생성자1
	int[] lotto; // 로또 번호를 저장할 배열 생성

	public Lotto() {
		//super();
		lotto = new int[6];
	}

	public Lotto(int[] arrLotto) {
		//super();
		lotto = arrLotto;
	}

	public void makeNumber() {
		int num; // 랜덤으로 생성된 숫자를 저장할 변수
		Random ran = new Random(); // 랜덤 객체 생성

		outFor: for (int i = 0; i < lotto.length; i++) { // 배열객체 길이만큼 반복
			num = ran.nextInt(45) + 1; // 1~45까지의 숫자를 받아 num변수에 삽입

			for (int j = 0; j < i; j++) { // 현제 생성된 배열원소의 갯수만큼만 중복숫자 검사

				// 중복검사 소스
				if (lotto[j] == num) { // 기존에 넣은 배열원소의 갑과 새로 생성된 난수가 같다면
					i--; // outFor 문의 인덱스를 되돌리고,
					continue outFor; // 되돌린 인덱스부터 재시작
				}
			}
			lotto[i] = num; // 중복검사 이상 없을시 배열에 난수 삽입
		} // outFor end
	}

	public void sort() {

		// 오름차순 정렬을 시작하는 반복문_(배열의 크기) -1 만큼 반복
		for (int i = 0; i < lotto.length - 1; i++) {
			int minIndex, temp;
			minIndex = i;
			// 상위 반복문에 인덱스에 해당하는 정수와 나머지 수들을 한번씩 비교하기위한 반복문
			for (int j = i + 1; j < lotto.length; j++) {
				if (lotto[minIndex] > lotto[j]) {
					minIndex = j;
				}
			}
			temp = lotto[minIndex];
			lotto[minIndex] = lotto[i];
			lotto[i] = temp;
		}
	}

	public void printLotto() {

		for (int e : lotto) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
}
