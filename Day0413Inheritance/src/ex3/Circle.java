package ex3;

public class Circle extends Shape {
	protected int radius;
	public static final double PI  = 3.14;;

	public Circle() {
		super(0, 1, "원");
		radius = 0;
	}

	public Circle(int radius) {
		super(0, 1, "원");
		this.radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("원을 그립니다.");
	}

	@Override
	public void calArea() {
		this.area = PI * radius * radius;
	}

	@Override
	public String toString() {
		return "Circle [radius=" + radius + ", PI=" + PI + "area=" + area + ", numOfLines=" + numOfLines + ", name="
				+ name + " ]";
	}

}
