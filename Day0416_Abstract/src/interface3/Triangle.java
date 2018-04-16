package interface3;

public class Triangle implements Drawable {
	protected int bottom;
	protected int height;

	public Triangle() {
		bottom = 0;
		height = 0;
	}

	public Triangle(int bottom, int height) {
		this.bottom = bottom;
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println("삼각형을 그립니다.");
	}

}
