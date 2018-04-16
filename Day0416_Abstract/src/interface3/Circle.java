package interface3;

public class Circle implements Drawable {
	protected int radius;
	public static final double PI = 3.14;;

	
	public Circle() {
		radius = 0;
	}

	public Circle(int radius) {
		this.radius = radius;
	}


	@Override
	public void draw() {
		System.out.println("원을 그립니다.");
	}
}
