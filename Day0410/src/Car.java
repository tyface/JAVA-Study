
public class Car {

	private String color;
	private int speed;
	private int mileage;

	public Car() {
		color = "빨강";
		speed = 0;
		mileage = 0;
	}

	public Car(String c, int s, int m) {
		color = c;
		speed = s;
		mileage = m;
	}

	public void speedUp() {
		speed += 5;
	}

	public void speedDown() {
		speed -= 5;
	}

	public void printCar() {
		System.out.println("색깔 : " + color);
		System.out.println("현제속도 : " + speed);
		System.out.println("주행거리 : " + mileage);
	}

	@Override
	public String toString() {
		return "Car [color=" + color + ", speed=" + speed + ", mileage=" + mileage + "]";
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		//속도가 150을 넘어가면 150으로 고정하겠다.
		if(speed > 150) {
			speed = 150;
		}
		this.speed = speed;
	}

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}
}
