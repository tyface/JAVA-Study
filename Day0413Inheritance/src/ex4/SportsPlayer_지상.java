package ex4;

public class SportsPlayer_지상 {
	private String name;
	private String event;
	private int age;
	private double height;
	private double weight;

	public SportsPlayer_지상() {
		this.name = "무명";
		this.event = "없음";
	}

	public SportsPlayer_지상(String name, String event, int age, double height, double weight) {
		this.name = name;
		this.event = event;
		this.age = age;
		this.height = height;
		this.weight = weight;
	}

	public void play() {
		System.out.println("운동을 시작합니다.");
	}

	public void viewBaseInfo() { //기본정보를 출력
		System.out.printf("┎ < 이름 : %s >< 종목 : %s >< 나이 : %d >< 신장 : %.1f >< 체중 : %.1f > \r\n", this.name, this.event,
				this.age, this.height, this.weight);
	}

	public void viewInfo() { //상속받은 객체들이 Override할 메서드 
	}

	// getter,setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "SportsPlayer [name=" + name + ", event=" + event + ", age=" + age + ", height=" + height + ", weight="
				+ weight + "]";
	}

}
