package ex3;

public class Triangle extends Shape {
	protected int bottom;
	protected int height;

	public Triangle() {
		super(0,3,"삼각형");
		bottom = 0;
		height = 0;
	}

	public Triangle(int bottom, int height) {
		super(0,3,"삼각형");
		this.bottom = bottom;
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println("삼각형을 그립니다.");
	}

	@Override
	public void calArea() {
		this.area = height * bottom / 2;
	}

	@Override
	public String toString() {
		return "Rectangle [height=" + height + ", bottom=" + bottom + "area=" + area + ", numOfLines=" + numOfLines
				+ ", name=" + name + " ]";
	}

}
