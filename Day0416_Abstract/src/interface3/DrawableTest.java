package interface3;

public class DrawableTest {

	public static void main(String[] args) {

		Drawable[] arr = new Drawable[3];

		arr[0] = new Circle(4);
		arr[1] = new Triangle(4, 5);
		arr[2] = new Rectangle(6, 4);

		for (Drawable e : arr) {
			e.draw();
		}
	}

}
