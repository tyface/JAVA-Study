package ex4;

public class SportsAgencyTest {

	public static void main(String[] args) {
		// 테스트용 데이터 입력
		SportsAgency sa = new SportsAgency();
		sa.setCount(5);
		sa.setPlayers(new SportsPlayer[] { 
				new BilliardPlayer("유지상", "당구", 29, 171.2, 58.1, 120, "4구", "중급"),
				new FootballPlayer("정성재", "축구", 28, 177, 59.6, 140, "오른발", 1),
				new FootballPlayer("홍길동", "축구", 80, 196.2, 66.6, 4040, "양발", 123),
				new BilliardPlayer("이준성", "당구", 26, 180.1, 60.2, 150, "3구", "상급"),
				new BasketballPlayer("이순신", "농구", 140, 201.1, 66.1, 50021, 4002, 3421, 34324) 
				}
		);

		sa.strat();// 시스템 시작

	}

}
