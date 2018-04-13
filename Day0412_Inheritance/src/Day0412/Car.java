package Day0412;

public class Car {
	private int speed;
	private int mileage;
	private String color;
	static int numOfcars;
	
	public Car() {
		numOfcars++;
		speed= 100;
		System.out.println("부모클래스 생성자 호출");
	}
	
	public static void printNumOfcars() {
		System.out.println(numOfcars);
	}

	@Override
	public String toString() {
		return "Car [speed=" + speed + ", mileage=" + mileage + ", color=" + color + "]";
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

}
