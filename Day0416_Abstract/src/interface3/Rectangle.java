package interface3;

public class Rectangle implements Drawable {
	protected int width;
	protected int height;

	public Rectangle() {
		width = 0;
		height = 0;
	}

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw() {
		System.out.println("사각형을 그립니다.");
	}

}
