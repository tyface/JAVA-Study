
public class Score {
	public static void main(String[] args) {
		// 학생들의 점수가 저장되는 2차원 배열을 생성
		// 2차원 배역은 각 반 별로 저장이 된다.
		// 1반은 {100,90,88,90} 네명
		// 2반은 {90,77,60} 세명
		// 3반은 {100,100,50,50,40} 다섯명
		// 4반은 {100,99,80,90,100,0} 여섯명
		// 각 반의 총점과 평균을 구하라
		// 단, 평균은 소수점 첫째자리 까지만 표시
		// 출력예) 1반: 총점 366점, 평균 91.5점
		// 2반: 총점 xxx점, 평균 xx.x점
		// 3반: 총점 xxx점, 평균 xx.x점
		// 4반: 총점 xxx점, 평균 xx.x점

		final int MAX_CLASS_NUM = 4; // 전체 반의 개수
		int[][] scores = new int[MAX_CLASS_NUM][]; // 반의 개수를 지정해주고 반마다의 점수를 저장할 2차원배열 생성

		// 각 학생들의 점수를 배열에 삽입
		scores[0] = new int[] { 100, 90, 88, 90 }; // 1반
		scores[1] = new int[] { 90, 77, 60 }; // 2반
		scores[2] = new int[] { 100, 100, 50, 50, 40 }; // 3반
		scores[3] = new int[] { 100, 91, 80, 90, 100, 0 }; // 4반

		// 모든 반의 점수를 출력하기 위한 반복문 (i는 각 반을 의미)
		for (int i = 0; i < scores.length; i++) {
			int sum = 0; // 각반의 총점을 저장하는 변수
			double avg = 0; // 각반의 평균을 저장하는 변수

			// 각 반의 모든점수를 가져오기 위한 반복문 (e는 각 점수를 의미)
			for (int e : scores[i]) {
				sum += e; // 합계 구하기
				avg = (double) sum / scores[i].length; // 평균 구하기
			}

			System.out.printf("%d반:   총점 %4d점,   평균 %5.1f점\r\n", i + 1, sum, avg); // 출력
		} // for end
	}
}
