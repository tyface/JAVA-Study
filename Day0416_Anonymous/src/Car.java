

public class Car {
	protected int speed;
	private int mileage;
	private String color;
	private Tire tire;
	private Tire2 tire2;
	
	
	public void test() {
		System.out.println("Test222");
		tire2.test();
	}
	public void drive() {
		System.out.println("자동차굴러갑니다.");
		tire.roll();
	}
	
	public Car(Tire tire,Tire2 tire2) {
		this.tire = tire;
		this.tire2 = tire2;
	}
	
	//공통 데이터
	static final String MODEL = "쏘나타";
	
	//현재 만들어진 객체가 몇개인지 체크하는 변수
	static int numOfCars;
	
	public Car() {
		System.out.println("부모클래스 생성자 호출!!");
		numOfCars++; //객체가 생성될 때 마다, 1증가
		speed = 100;
	}
	
	public static void printNumOfCars() {
		System.out.println(numOfCars);
		//System.out.println(color);
		//static 메서드에서는 non-static 변수를 사용하지 못함
	}
	
	public void speedUp() {
		if(speed >= 150) {
			System.out.println("최대 속도입니다!");
		}else {
			System.out.println("속도가 증가합니다.");
			speed +=10;
		}
	}
	
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getMileage() {
		return mileage;
	}
	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public String toString() {
		return "Car [speed=" + speed + ", mileage=" + mileage + ", color=" + color + "]";
	}
	
}
