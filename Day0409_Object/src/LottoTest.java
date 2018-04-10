
public class LottoTest {
	public static void main(String[] args) {
		// 1~45사이의 중복되지 않는 6개의 수를 생성하는 Lotto 클래스 생성
		// 상태값은 생성된 로또 번호를 저장할 수 있는 크기6인 정수형 배열 lotto[]
		// 기능은
		// 1-랜덤한 숫자를 만들어 내는 makeNumber()
		// 2-만들어진 배열을 정렬하는 sort()
		// 3-만들어진 배열을 출력하는 printLotto()
		// 생성자는 배열을 받아서 lotto에 넣어줄수 있는 생성자1
		// 기본생성자1

		Lotto lotto = new Lotto();

		lotto.makeNumber();

		lotto.printLotto();

		lotto.sort();

		lotto.printLotto();

		Lotto lotto2 = new Lotto(new int[] { 4, 23, 7, 6, 40, 10 });

		lotto2.printLotto();

		lotto2.sort();

		lotto2.printLotto();

	}
}
