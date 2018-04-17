package ex4;

public class SportsAgencyTest_지상 {

	public static void main(String[] args) {
		// 테스트용 데이터 입력
		SportsAgency_지상 sa = new SportsAgency_지상();
		sa.setMaxCount(5);
		sa.setPlayers(new SportsPlayer_지상[] { 
				new BilliardPlayer_지상("유지상", "당구", 29, 171.2, 58.1, 120, "4구", "중급"),
				new FootballPlayer_지상("정성재", "축구", 28, 177, 59.6, 140, "오른발", 1),
				new FootballPlayer_지상("홍길동", "축구", 80, 196.2, 66.6, 4040, "양발", 123),
				new BilliardPlayer_지상("이준성", "당구", 26, 180.1, 60.2, 150, "3구", "상급"),
				new BasketballPlayer_지상("이순신", "농구", 140, 201.1, 66.1, 50021, 4002, 3421, 34324) 
				}
		);

		sa.strat();// 시스템 시작

	}

}
