package ex4;

public class BasketballPlayer extends SportsPlayer {
	private int totalScore;
	private int totalAassist;
	private int totalRebound;
	private int totalThreePoint;

	public BasketballPlayer() {
		super();
	}

	public BasketballPlayer(String name, String event, int age, double height, double weight) {
		super(name, event, age, height, weight);
	}

	public BasketballPlayer(String name, String event, int age, double height, double weight, int totalScore,
			int totalAassist, int totalRebound, int totalThreePoint) {
		super(name, event, age, height, weight);
		this.totalScore = totalScore;
		this.totalAassist = totalAassist;
		this.totalRebound = totalRebound;
		this.totalThreePoint = totalThreePoint;
	}

	@Override
	public void play() {
		System.out.println("농구를 시작합니다.");
	}

	@Override
	public void viewInfo() {
		System.out.printf("┖ 누적득점 : %d / 누적어시스트 : %d / 누적리바운드 : %d / 누적3점득점 : %d \r\n\n", totalScore, totalAassist,
				totalRebound, totalThreePoint);
	}

	@Override
	public String toString() {
		return "BasketballPlayer [totalScore=" + totalScore + ", totalAassist=" + totalAassist + ", totalRebound="
				+ totalRebound + ", totalThreePoint=" + totalThreePoint + "]" + super.toString();
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getTotalAassist() {
		return totalAassist;
	}

	public void setTotalAassist(int totalAassist) {
		this.totalAassist = totalAassist;
	}

	public int getTotalRebound() {
		return totalRebound;
	}

	public void setTotalRebound(int totalRebound) {
		this.totalRebound = totalRebound;
	}

	public int getTotalThreePoint() {
		return totalThreePoint;
	}

	public void setTotalThreePoint(int totalThreePoint) {
		this.totalThreePoint = totalThreePoint;
	}

	//getter,setter
	
}
