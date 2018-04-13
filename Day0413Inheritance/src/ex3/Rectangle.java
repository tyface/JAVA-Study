package ex3;

public class Rectangle extends Shape {
	protected int width;
	protected int height;

	public Rectangle() {
		super(0,4,"사각형");
		width = 0;
		height = 0;
	}

	public Rectangle(int width, int height) {
		super(0,4,"사각형");
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println("사각형을 그립니다.");
	}

	@Override
	public void calArea() {
		this.area = height * width;
	}

	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", width=" + width + "area=" + area + ", numOfLines=" + numOfLines + ", name="
				+ name + " ]";
	}

}
