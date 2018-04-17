package ex4;

public class FootballPlayer_지상 extends SportsPlayer_지상 {
	private int totalScore;
	private String mainFoot;
	private int totalRedCard;

	public FootballPlayer_지상() {
		super();
		mainFoot = "없음";
	}

	public FootballPlayer_지상(String name, String event, int age, double height, double weight) {
		super(name, event, age, height, weight);
		mainFoot = "없음";
	}

	public FootballPlayer_지상(String name, String event, int age, double height, double weight, int totalScore,
			String mainFoot, int totalRedCard) {
		super(name, event, age, height, weight);
		this.totalScore = totalScore;
		this.mainFoot = mainFoot;
		this.totalRedCard = totalRedCard;
	}

	@Override
	public void play() {
		System.out.println("축구를 시작합니다.");
	}

	@Override
	public void viewInfo() {
		System.out.printf("┖ < 누적득점 : %d >< 주발 : %S >< 누적레드카드 : %d > \r\n", totalScore, mainFoot, totalRedCard);
	}

	@Override
	public String toString() {
		return "FootballPlayer [totalScore=" + totalScore + ", mainFoot=" + mainFoot + ", totalRedCard=" + totalRedCard
				+ "]" + super.toString();
	}

	// getter,setter
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public String getMainFoot() {
		return mainFoot;
	}

	public void setMainFoot(String mainFoot) {
		this.mainFoot = mainFoot;
	}

	public int getTotalRedCard() {
		return totalRedCard;
	}

	public void setTotalRedCard(int totalRedCard) {
		this.totalRedCard = totalRedCard;
	}

}
