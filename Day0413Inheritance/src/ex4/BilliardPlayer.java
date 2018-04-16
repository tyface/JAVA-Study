package ex4;

public class BilliardPlayer extends SportsPlayer {
	private double avgGrade;
	private String billiardEvent;
	private String strokeClass;

	public BilliardPlayer() {
		super();
		billiardEvent = "없음";
		strokeClass = "보통";
	}

	public BilliardPlayer(String name, String event, int age, double height, double weight) {
		super(name, event, age, height, weight);
		billiardEvent = "없음";
		strokeClass = "보통";
	}

	public BilliardPlayer(String name, String event, int age, double height, double weight, double avgGrade,
			String billiardEvent, String strokeClass) {
		super(name, event, age, height, weight);
		this.avgGrade = avgGrade;
		this.billiardEvent = billiardEvent;
		this.strokeClass = strokeClass;
	}

	@Override
	public void play() {
		System.out.println("농구를 시작합니다.");
	}

	@Override
	public void viewInfo() {
		System.out.printf("┖ < 평균점수 : %.2f >< 당구종목 : %s >< 제구능력 : %s > \r\n", avgGrade, billiardEvent, strokeClass);
	}

	@Override
	public String toString() {
		return "BilliardPlayer [avgGrade=" + avgGrade + ", billiardEvent=" + billiardEvent + ", strokeClass="
				+ strokeClass + "]" + super.toString();
	}

	// getter,setter
	public double getAvgGrade() {
		return avgGrade;
	}

	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}

	public String getBilliardEvent() {
		return billiardEvent;
	}

	public void setBilliardEvent(String billiardEvent) {
		this.billiardEvent = billiardEvent;
	}

	public String getStrokeClass() {
		return strokeClass;
	}

	public void setStrokeClass(String strokeClass) {
		this.strokeClass = strokeClass;
	}

	

}