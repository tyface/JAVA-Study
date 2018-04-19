package list;

import java.util.ArrayList;
import java.util.Random;

public class LottoMaker {

	ArrayList<Integer> lotto = new ArrayList<Integer>(); // 로또 번호를 저장할 배열 생성

	public void makeNumber() {
		int num; // 랜덤으로 생성된 숫자를 저장할 변수
		Random ran = new Random(); // 랜덤 객체 생성

		outFor: 
		for (int i = 0; i < 6; i++) { // 배열객체 길이만큼 반복
			num = ran.nextInt(45) + 1; // 1~45까지의 숫자를 받아 num변수에 삽입
			
			for (int j = 0; j < i; j++) { // 현제 생성된 배열원소의 갯수만큼만 중복숫자 검사
				
				// 중복검사 소스
				if (lotto.get(j) == num) { // 기존에 넣은 배열원소의 갑과 새로 생성된 난수가 같다면
					i--; // outFor 문의 인덱스를 되돌리고,
					continue outFor; // 되돌린 인덱스부터 재시작
				}
			} // for end
			lotto.add(num); // 중복검사 이상 없을시 배열에 난수 삽입
		} // outFor end

		for (int e : lotto) {
			System.out.print(e + " "); // 출력
		}
	}

}
